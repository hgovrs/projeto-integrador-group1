package com.meli.projetointegradorgroup1.dto.request;

import com.meli.projetointegradorgroup1.entity.BatchStock;
import com.meli.projetointegradorgroup1.entity.BatchStockItem;
import com.meli.projetointegradorgroup1.entity.Product;

import com.meli.projetointegradorgroup1.entity.Seller;
import com.meli.projetointegradorgroup1.services.ProductService;
import com.meli.projetointegradorgroup1.services.SellerService;
import com.meli.projetointegradorgroup1.services.StockService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

//Essa classe nao conecta com BD, intermedio entre o usuario e a classe
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatchStockItemRequestDTO {


    private int quantity;
    private Double volume;
    private Double maximumTemperature;
    private Double minimumTemperature;
    private Long product_id;



    public BatchStockItem converte(BatchStockItemRequestDTO dto, ProductService productService, SellerService sellerService){
        return BatchStockItem.builder()
                .minimumTemperature(dto.getMinimumTemperature())
                .volume(dto.getVolume())
                .maximumTemperature(dto.getMaximumTemperature())
                .product(productService.obtem(dto.product_id))
                .quantity(dto.getQuantity())
//                .batchStock()  faltando buildar o batchstock TODO
                .build();

    }
}
