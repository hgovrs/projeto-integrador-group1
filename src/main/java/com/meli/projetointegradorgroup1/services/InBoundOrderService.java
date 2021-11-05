package com.meli.projetointegradorgroup1.services;

import com.meli.projetointegradorgroup1.entity.BatchStock;
import com.meli.projetointegradorgroup1.entity.InBoundOrder;
import com.meli.projetointegradorgroup1.repository.InBoundOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InBoundOrderService {

    private InBoundOrderRepository repository;

    @Autowired
    public InBoundOrderService(InBoundOrderRepository repository){
        this.repository = repository;
    }
    public void registra(InBoundOrder inBoundOrder){
        List<BatchStock> batchStocks = inBoundOrder.getBatchStock();
        batchStocks.forEach(b -> {
            b.setInboundOrder(inBoundOrder);
            b.getBatchStockItem().setBatchStock(b);
        });
        try{
            this.repository.save(inBoundOrder);
        }catch(RuntimeException e){
            e.printStackTrace();
            throw new RuntimeException( "deu ruim");
        }
    }
}
