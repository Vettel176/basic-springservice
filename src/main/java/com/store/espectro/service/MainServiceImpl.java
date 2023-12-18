package com.store.espectro.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.store.espectro.dto.PruebaDto;

@Service
public class MainServiceImpl implements MainService {
    private static final Logger logger = LoggerFactory.getLogger(MainServiceImpl.class);
    
    @Override
    public PruebaDto prueba() {
        logger.info("Start Implementation Service");
        PruebaDto pruebaDto = new PruebaDto();
        pruebaDto.setId(9L);
        pruebaDto.setMensaje("Hello Prueba");
        return pruebaDto;
    }
    
}
