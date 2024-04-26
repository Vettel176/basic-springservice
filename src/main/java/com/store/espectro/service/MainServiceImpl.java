package com.store.espectro.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.espectro.config.QueryGetAll;
import com.store.espectro.config.QueryInsert;
import com.store.espectro.dto.ProductoDto;
import com.store.espectro.dto.PruebaDto;
import com.store.espectro.dto.ResponseDto;

@Service
public class MainServiceImpl implements MainService {
    private static final Logger logger = LoggerFactory.getLogger(MainServiceImpl.class);

    @Autowired
    QueryGetAll getAll;
    @Autowired
    QueryInsert save;
    
    @Override
    public PruebaDto prueba() {
        logger.info("Start Implementation Service");
        PruebaDto pruebaDto = new PruebaDto();
        pruebaDto.setId(9L);
        pruebaDto.setMensaje("Hello Prueba");
        return pruebaDto;
    }

    @Override
    public ResponseDto saveProduct(ProductoDto productoDto) {
        ResponseDto responseDto = new ResponseDto();
        try{
            String mensaje = save.saveProduct(productoDto);
                    responseDto.setCodigo(200);
                    responseDto.setMensaje(mensaje);
        }catch(Exception e){
                    responseDto.setCodigo(200);
                    responseDto.setMensaje("Error Espectral: "+e.getMessage());
        }        
        return responseDto;
    }

    @Override
    public List<ProductoDto> findAllProducts() {
        List<ProductoDto> listProductoDtos = new ArrayList<>();
        listProductoDtos = getAll.getAllProducts();
        return listProductoDtos;
    }


    public List<ProductoDto> orderProducts(List<ProductoDto> listProductoDtos){
        List<ProductoDto> listProductoDtosOrdered = new ArrayList<>();

        return listProductoDtosOrdered;
    }

    @Override
    public String delete(Integer id) {
        String mensaje = "";
        try{
            mensaje = save.delete(id);
        }catch(Exception e){
            System.out.println("Valio verga");
        }        
       return mensaje;
    }
    
    
}
