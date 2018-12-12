package com.companyname.springapp.service;

import java.util.List;

import com.companyname.springapp.domain.Product;

public class SimpleProductManager implements ProductManager {
	
	private static final long serialVersionUID = 1L;
	private List<Product> products;

	@Override
	public void increasePrice(int percentage) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException();
		if (products != null) {
            for( Product product : products) {
                double newPrice = product.getPrice().doubleValue() * 
                                    (100 + percentage)/100;
                product.setPrice(newPrice);
            }
        }
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		 return products;
	}
	
	public void setProducts( List<Product> products ) {
		//throw new UnsupportedOperationException();
		this.products = products;
	}

}
