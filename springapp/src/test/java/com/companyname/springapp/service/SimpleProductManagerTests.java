package com.companyname.springapp.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.companyname.springapp.domain.Product;

public class SimpleProductManagerTests {

    private SimpleProductManager productManager;
    
    private List<Product> products;
    
    private static int PRODUCT_COUNT = 2;
    
    private static Double CHAIR_PRICE = new Double(20.50);
    private static String CHAIR_DESCRIPTION = "Silla";
    
    private static String TABLE_DESCRIPTION = "Mesa";
    private static Double TABLE_PRICE = new Double(150.10);
    
    private static int POSITIVE_PRICE_INCREASE = 10;
    
    @Before
    public void setUp() throws Exception {
        this.productManager = new SimpleProductManager();
        this.products = new ArrayList<Product>();
        
        Product product = new Product();
        product.setDescription("Silla");
        product.setPrice(CHAIR_PRICE);
        this.products.add(product);
        
        product = new Product();
        product.setDescription("Mesa");
        product.setPrice(TABLE_PRICE);
        this.products.add(product);
        
        productManager.setProducts(products);

    }

    @Test
    public void testGetProductsWithNoProducts() {
        productManager = new SimpleProductManager();
        assertNull(productManager.getProducts());
    }

    @Test
    public void testGetProducts() {
        List<Product> products = productManager.getProducts();
        assertNotNull(products);        
        assertEquals(PRODUCT_COUNT, productManager.getProducts().size());
    
        Product product = products.get(0);
        assertEquals(CHAIR_DESCRIPTION, product.getDescription());
        assertEquals(CHAIR_PRICE, product.getPrice());
        
        product = products.get(1);
        assertEquals(TABLE_DESCRIPTION, product.getDescription());
        assertEquals(TABLE_PRICE, product.getPrice());      
    }
    
    @Test
    public void testIncreasePriceWithNullListOfProducts() {
        try {
            productManager = new SimpleProductManager();
            productManager.increasePrice(POSITIVE_PRICE_INCREASE);
        }
        catch(NullPointerException ex) {
            fail("Lista de productos esta nula.");
        }
    }

    @Test
    public void testIncreasePriceWithEmptyListOfProducts() {
        try {
            productManager = new SimpleProductManager();
            productManager.setProducts(new ArrayList<Product>());
            productManager.increasePrice(POSITIVE_PRICE_INCREASE);
        }
        catch(Exception ex) {
            fail("Lista de productos esta vacia.");
        }           
    }
    
    @Test
    public void testIncreasePriceWithPositivePercentage() {
        productManager.increasePrice(POSITIVE_PRICE_INCREASE);
        double expectedChairPriceWithIncrease = 22.55;
        double expectedTablePriceWithIncrease = 165.11;
        
        List<Product> products = productManager.getProducts();      
        Product product = products.get(0);
        assertEquals(expectedChairPriceWithIncrease, product.getPrice(), 0);
        
        product = products.get(1);      
        assertEquals(expectedTablePriceWithIncrease, product.getPrice(), 0);       
    }
}