package com.meli.projetointegradorgroup1.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.meli.projetointegradorgroup1.dto.BatchStockDTO;
import com.meli.projetointegradorgroup1.entity.*;
import com.meli.projetointegradorgroup1.services.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InBoundOrderRequestDTO {

        private Long orderNumber;
        private LocalDate orderDate;
        @JsonProperty(value =  "seller_id")
        private Long sellerId; // falta buildar TODO
        @JsonProperty(value = "section")
        private SectionForInboundDTO sectionForInboundDTO;
        @JsonProperty(value= "batchStockList")
        private List<BatchStockDTO> batchStockDTOList;

        private Long representanteId;



        public InBoundOrder convertedto(RepresentanteServices representanteServices, SectionServices sectionServices,
                                        ProductService productService, SellerService sellerService){
            Section section = sectionServices.obterSectionByCode(sectionForInboundDTO.getCode());
            try{
                InBoundOrder inboundOrder = null;
                inboundOrder = InBoundOrder.builder()
                        .orderDate(this.orderDate)
                        .representante(representanteServices.obter(this.representanteId))
                        .orderNumber(this.orderNumber)
                        .section(section)
                        .batchStock(converte(batchStockDTOList, productService, sellerService)).build();


                return inboundOrder;
            }catch(Exception e){
                e.printStackTrace();
                return null;
            }

        }



    public List<BatchStock> converte(List<BatchStockDTO> dtos, ProductService productService, SellerService sellerService){
        List<BatchStock> resultList = new ArrayList<>();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (BatchStockDTO dto: dtos) {
            BatchStock batchStock = null;
            batchStock = BatchStock.builder()
                    .batchStockNumber(dto.getBatchStockNumber())
                    .dueDate(dto.getDueDate())
                    .manufacturingTime(LocalDateTime.parse(dto.getManufacturingTime(),fmt))
                    .currentQuality(dto.getCurrentQuality())
                    .initialQuality(dto.getInitialQuality())
                    .minimumTemperature(dto.getMinimumTemperature())
                    .currentTemperature(dto.getMaximumTemperature())
                    .seller(sellerService.obter(this.sellerId))
                    .batchStockItem(
                            BatchStockItem.builder()
                                    .quantity(dto.getQuantity())
                                    .volume(dto.getVolume())
                                    .product(productService.obtem(dto.getBatchStockItem()))
                                    .maximumTemperature(dto.getMinimumTemperature())
                                    .build()
                    )
                    .build();
            resultList.add(batchStock);
        }
        return resultList;
    }

    }


