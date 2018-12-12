package com.companyname.springapp.domain;

import java.io.Serializable;

public class Product implements Serializable {
	// Los miembros deben ser privados
    private static final long serialVersionUID = 1L;

    private String description;
    private Double price;
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Descripcion: " + description + ";");
        buffer.append("Precio: " + price);
        return buffer.toString();
    }
}