package com.store.espectro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.espectro.dto.ProductoDto;
import com.store.espectro.dto.PruebaDto;
import com.store.espectro.dto.ResponseDto;
import com.store.espectro.service.MainService;

@RestController
@RequestMapping("/prueba")

public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping
    @ResponseBody
    public PruebaDto prueba(){
        return mainService.prueba();
    }

    @PostMapping("/product")
    public ResponseDto saveProduct(@RequestBody ProductoDto product){
        ResponseDto respuestita = mainService.saveProduct(product);
        return respuestita;
    }

    @GetMapping("/product")
    public List<ProductoDto> findAllProducts(){
        return mainService.findAllProducts();
    }

    @PostMapping("/achingarasumadre")
    public String delete(Integer id){
        String resp= mainService.delete(id);
        return resp;

    }

}
