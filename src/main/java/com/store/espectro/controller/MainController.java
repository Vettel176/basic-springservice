package com.store.espectro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.espectro.dto.PruebaDto;
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

}
