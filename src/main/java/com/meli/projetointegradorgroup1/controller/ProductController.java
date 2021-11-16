package com.meli.projetointegradorgroup1.controller;

import com.meli.projetointegradorgroup1.dto.request.ProductRequestDTO;
import com.meli.projetointegradorgroup1.dto.response.ProductResponseDto;
import com.meli.projetointegradorgroup1.entity.Product;
import com.meli.projetointegradorgroup1.repository.ProductRepository;
import com.meli.projetointegradorgroup1.services.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Cadastrar novo produto")
    public ProductRequestDTO createProduct(@Valid @RequestBody ProductRequestDTO productRequestDTO){
        return productService.save(productRequestDTO);
    }

    @GetMapping("/list")
    @ApiOperation(value = "Retornar lista de produtos")
    public List<ProductResponseDto> responseDtoList(){
        return productService.listProductDto();
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Retornar produto único a partir do id")
    public ResponseEntity<ProductResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping("/list/{name}")
    @ApiOperation(value = "Retornar lista de produtos a partir do nome")
    public List<ProductResponseDto> getByName(@Valid @PathVariable String name){
        return productService.listProductDto(name);
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "Atualizar produto a partir do id")
    public ProductRequestDTO updateProduct(@PathVariable("id") Long id, @Valid @RequestBody ProductRequestDTO productRequestDto){

        Optional<Product> productFind = productRepository.findById(id);
        Product newProduct = productService.validaUpdate(productFind, productRequestDto);
        return productService.convertEntityToDtoRequest(productRepository.save(newProduct));
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Deletar produto a partir do id")
    public String deleteProduct(@PathVariable Long id){
        productRepository.deleteById(id);
        return "Produto de id " + id + " excluído com sucesso!";
    }

}
