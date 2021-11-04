package com.meli.projetointegradorgroup1.controller;

import com.meli.projetointegradorgroup1.dto.request.SellerRequestDTO;
import com.meli.projetointegradorgroup1.dto.response.SellerResponseDTO;
import com.meli.projetointegradorgroup1.entity.Seller;
import com.meli.projetointegradorgroup1.repository.SellerRepository;
import com.meli.projetointegradorgroup1.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    SellerService sellerService;

    public SellerController(SellerRepository sellerRepository, SellerService sellerService) {
        this.sellerRepository = sellerRepository;
        this.sellerService = sellerService;
    }


    //Cadastrar vendedor
    @PostMapping("/create")
    public SellerResponseDTO createSeller(@Valid @RequestBody SellerRequestDTO sellerRequestDTO){

        Seller seller = sellerService.convertRequestDTOToEntity(sellerRequestDTO);
        seller = sellerService.setSeller(seller);

        SellerResponseDTO sellerResponseDTO = sellerService.convertEntityToResponse(seller);

        return sellerResponseDTO;
    }

    //Consultar lista de  vendeokdores
    @GetMapping("/list")
     public List<SellerResponseDTO> getSellerList() {

        List<SellerResponseDTO> sellerList =  sellerService.getSellers();

        //ArrayList<SellerResponseDTO> sellerResponseDTOS = new ArrayList();

        //sellerList.stream()
        //        .forEach(seller -> sellerResponseDTOS.add(sellerService.convertEntityToResponse(seller)));
        return sellerList;
    }

    //busca vendedor pelo id
    @GetMapping("{id}")
    public SellerResponseDTO getSellerById(@PathVariable("id") Long id) {
        // colocar mensagem de nao encontrado
        return sellerService.getSellerById(id);
    }

    // atualizando vendedor pelo ID
    @PutMapping("/update/{id}")
    public SellerResponseDTO updateSeller(@PathVariable("id") Long id, @Valid @RequestBody Seller seller) { // Alterado para se adequar ao padrão solicitado

        return sellerService.validaUpdate(id, seller);
    }

    //delete todos vendedores
    @DeleteMapping("/deleteall")
    public boolean deleteAllSellers() {
        ///sellerRepository.deleteAll();
        return sellerService.deleteAllSellers();

    }

//deletar vendedor pelo ID
@DeleteMapping("/delete/{id}")
public ResponseEntity<HttpStatus> deleteSellerById(@PathVariable("id") Long id) {
    if(sellerService.deleteSeller(id)){
        //sellerRepository.deleteById(id);
        sellerService.deleteSeller(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}



}
