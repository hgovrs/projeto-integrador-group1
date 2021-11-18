package com.meli.projetointegradorgroup1.controller;

import com.meli.projetointegradorgroup1.dto.request.SellerRequestDTO;
import com.meli.projetointegradorgroup1.dto.response.SellerResponseDTO;
import com.meli.projetointegradorgroup1.entity.Seller;
import com.meli.projetointegradorgroup1.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @PostMapping("/create")
    public SellerResponseDTO createSeller(@Valid @RequestBody SellerRequestDTO sellerRequestDTO){
        Seller seller = sellerService.save(sellerService.convert(sellerRequestDTO));
        return sellerService.convertToDto(seller);
    }

    @GetMapping("/list")
    List<SellerResponseDTO> getSellerList() {
        return sellerService.getSellers();
    }

    @GetMapping("{id}")
    public SellerResponseDTO getSellerById(@PathVariable("id") Long id) {
        return sellerService.convertToDto(sellerService.obter(id));
    }

    @PutMapping("/update/{id}")
    public SellerResponseDTO updateSeller(@PathVariable("id") Long id, @Valid @RequestBody SellerRequestDTO sellerRequestDTO) {
        Seller sellerFind = sellerService.obter(id);
        Seller seller = sellerService.validaUpdate(sellerFind, sellerRequestDTO);
        return sellerService.convertToDto(sellerService.save(seller));
    }

    @DeleteMapping("/delete/{id}")
    public SellerResponseDTO deleteSellerById(@PathVariable("id") Long id) {
        Seller seller = sellerService.obter(id);
        sellerService.deleta(id);
        return sellerService.convertToDto(seller);
    }

}