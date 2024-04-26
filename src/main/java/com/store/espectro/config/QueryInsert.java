package com.store.espectro.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.store.espectro.dto.ProductoDto;

@Service
public class QueryInsert {
    private static final Logger logger = LoggerFactory.getLogger(QueryGetAll.class);

    private final String url = "jdbc:postgresql://monorail.proxy.rlwy.net:50961/espectro";
    private final String user = "vettel";
    private final String password = "Vettel30";

    private static final String INSERT_PRODUCT_SQL = "INSERT INTO store.productos" +
        "  (id, codigo, cantidad, total) VALUES " +
        " (?, ?, ?, ? );";
    private static final String DELETE_PRODUCT_SQL = "DELETE from store.productos WHERE id = ?;";


    public String saveProduct(ProductoDto productoDto) throws SQLException {
        logger.info(INSERT_PRODUCT_SQL);
        String mensaje ="Se guardó correctamente el producto";
        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager.getConnection(url, user, password);
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {
                 logger.info("Insertando");
            preparedStatement.setLong(1, productoDto.getId());
            preparedStatement.setString(2, productoDto.getCodigo());
            preparedStatement.setInt(3, productoDto.getCantidad());
            preparedStatement.setDouble(4, productoDto.getTotal());
                 logger.info("Fin Insertando");
            // Step 3: Execute the query or save or update query
            preparedStatement.executeQuery();
            logger.info("Fin excecution");
        } catch (SQLException e) {
            mensaje = "Salieron unos errores al intentar guardar, favor de revisar.";
            logger.info("Ejecucion con advetencia.");
            // print SQL exception information
            printSQLException(e);
        }
        return mensaje;

        // Step 4: try-with-resource statement will auto close the connection.
    }

    public String delete(Integer id) throws SQLException {
        logger.info(DELETE_PRODUCT_SQL);
        String mensaje ="Se eliminó correctamente el producto";
        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager.getConnection(url, user, password);
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_SQL)) {
                 logger.info("Eliminando");
                 preparedStatement.setLong(1, id);
            // Step 3: Execute the query or save or update query
            preparedStatement.execute();
            logger.info("Fin excecution");
        } catch (SQLException e) {
            mensaje = "Salieron unos errores al intentar eliminar, favor de revisar.";
            logger.info("Ejecucion con advertencia.");
            // print SQL exception information
            printSQLException(e);
        }
        return mensaje;

        // Step 4: try-with-resource statement will auto close the connection.
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}