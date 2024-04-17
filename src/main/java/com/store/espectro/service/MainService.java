package com.store.espectro.service;

import java.util.List;

import com.store.espectro.dto.PruebaDto;
import com.store.espectro.dto.ResponseDto;
import com.store.espectro.dto.ProductoDto;

public interface MainService {
    PruebaDto prueba();
    ResponseDto saveProduct(ProductoDto productoDto);
    List<ProductoDto> findAllProducts();
}
