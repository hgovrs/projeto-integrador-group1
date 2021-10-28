package com.meli.projetointegradorgroup1.dto.response;

import com.meli.projetointegradorgroup1.entity.BatchStock;
import com.meli.projetointegradorgroup1.entity.BatchStockItem;
import com.meli.projetointegradorgroup1.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatchstockItemResponseDTO {

    private int quantity;
    private Double volume;
    private Double maximumTemperature;
    private Double minimumTemperature;
    private Product product;
    private String seller_id;

    public BatchstockItemResponseDTO(BatchStockItem batchStockItem){
        this.quantity = batchStockItem.getQuantity();;
        this.volume =batchStockItem.getVolume();
        this.maximumTemperature = batchStockItem.getMaximumTemperature();
        this.minimumTemperature = batchStockItem.getMinimumTemperature();
        this.product = batchStockItem.getProduct();

    }






}
