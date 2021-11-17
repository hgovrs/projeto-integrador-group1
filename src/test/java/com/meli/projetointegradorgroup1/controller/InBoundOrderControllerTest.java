package com.meli.projetointegradorgroup1.controller;

import com.meli.projetointegradorgroup1.dto.request.InBoundOrderRequestDTO;
import com.meli.projetointegradorgroup1.entity.InBoundOrder;
import com.meli.projetointegradorgroup1.services.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

public class InBoundOrderControllerTest {
    InBoundOrderController inBoundOrderController;
    InBoundOrderService inBoundOrderService;

    InBoundOrderRequestDTO inBoundOrderRequestDTO = new InBoundOrderRequestDTO();
    InBoundOrder inBoundOrder = new InBoundOrder(1l,2l, LocalDate.now(), null, null, null);

    @Test
    public void createOk(){
        inBoundOrderController = Mockito.mock(InBoundOrderController.class);
        inBoundOrderService = Mockito.mock(InBoundOrderService.class);
        inBoundOrderRequestDTO = Mockito.mock(InBoundOrderRequestDTO.class);

        Mockito.when(inBoundOrderService.validInboundOrder(Mockito.any())).thenReturn(inBoundOrderRequestDTO);
        Mockito.doNothing().when(inBoundOrderService).registra(Mockito.any());
        Mockito.when(inBoundOrderRequestDTO.convertedto(Mockito.any(),Mockito.any(),Mockito.any(),Mockito.any())).thenReturn(inBoundOrder);

        InBoundOrderController inBoundOrderController = new InBoundOrderController(inBoundOrderService);
        inBoundOrderController.create(inBoundOrderRequestDTO);

        assert(inBoundOrder.getId() != null);
    }
}