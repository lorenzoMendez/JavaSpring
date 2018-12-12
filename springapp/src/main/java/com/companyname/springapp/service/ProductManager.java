package com.companyname.springapp.service;

import java.util.List;

import com.companyname.springapp.domain.Product;

public interface ProductManager {
	
	public void increasePrice( int percentage );
	
	public List<Product> getProducts();

}
