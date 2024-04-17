package com.store.espectro.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.store.espectro.dto.ProductoDto;

@Service
public class QueryGetAll {
    private static final Logger logger = LoggerFactory.getLogger(QueryGetAll.class);

    public List<ProductoDto> getAllProducts(){
        List<ProductoDto> listProductoDtos = new ArrayList<>();
        ProductoDto productBD = new ProductoDto(); 
        Connection c = null;
        Statement stmt = null;
        try{
        Class.forName("org.postgresql.Driver");
        c = DriverManager.getConnection("jdbc:postgresql://monorail.proxy.rlwy.net:50961/espectro","vettel", "Vettel30");
        logger.info("Successfully Connected.");
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "select * from store.productos;" );

        while ( rs.next() ) {
            Long id        = rs.getLong("id");
            String codigo = rs.getString("codigo");
            int cantidad  = rs.getInt("cantidad");
            Double total  = rs.getDouble("total");
            logger.info( "id = %s , codigo = %s, cantidad = %s, total = %s ", id,codigo, cantidad,total );
            productBD.setId(id);
            productBD.setCodigo(codigo);
            productBD.setCantidad(cantidad);
            productBD.setTotal(total);
            logger.info("Producto BD: id: "+id+" codigo:"+codigo+" cantidad:"+cantidad+" total:"+total);
            listProductoDtos.add(productBD);
        }
        rs.close();
        stmt.close();
        c.close();
        }catch(Exception e){
            logger.info( e.getClass().getName()+": "+ e.getMessage());
        }
        return listProductoDtos;
    }

}
