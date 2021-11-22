package com.meli.projetointegradorgroup1.dto.request;
import com.meli.projetointegradorgroup1.entity.BatchStockItem;
import com.meli.projetointegradorgroup1.services.ProductService;
import com.meli.projetointegradorgroup1.services.SellerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



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

    ProductService productService;
    SellerService sellerService;

    public BatchStockItem converte(BatchStockItemRequestDTO dto){
        return BatchStockItem.builder()
                .minimumTemperature(dto.getMinimumTemperature())
                .volume(dto.getVolume())
                .maximumTemperature(dto.getMaximumTemperature())
                .product(productService.obtem(dto.product_id))
                .quantity(dto.getQuantity())
                .build();

    }
}
