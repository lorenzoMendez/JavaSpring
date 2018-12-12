package com.companyname.springapp.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProductTests {

    private Product product;
    
    // Se ejecuta primero que los Test
    @Before
    public void setUp() throws Exception {
        this.product = new Product();
    }

    // Pruebas unitarias JUnit
    @Test
    public void testSetAndGetDescription() {
        String testDescription = "Es una descripcion";
        // Que sea nulo
        assertNull(product.getDescription());
        this.product.setDescription(testDescription);
        // que sean iguales
        assertEquals(testDescription, product.getDescription());
    }

    @Test
    public void testSetAndGetPrice() {
        double testPrice = 100.00;
        // Que sean iguales
        assertEquals(0, 0, 0);    
        this.product.setPrice(testPrice);
        assertEquals(testPrice, product.getPrice(), 0);
    }

}