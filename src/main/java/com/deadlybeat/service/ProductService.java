package com.deadlybeat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deadlybeat.entity.Product;
import com.deadlybeat.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	//save a product in DB
	public Product SaveProduct(Product product) {
		return productRepo.save(product);
	}
	
	//save Multiple Products
	public List<Product> saveProducts(List<Product> products){
		return productRepo.saveAll(products);
	}
	
	//Find All product for DB
	public List<Product> getProducts(){
		return productRepo.findAll();
	}
	
	//Fine one product based on ID .orElse as findById() return optional
	public Product getProductById(int id) {
		return productRepo.findById(id).orElse(null);
	}
	
	//Find product by another field apart from ID this can be list<poroduct> as well
	public Product getProductByName(String name) {
		return productRepo.findByName(name);
	}
	
	//Delete product by id
	public String DeleteById(int id) {
		productRepo.deleteById(id);
		return "Product with ID "+id+"removed Successfully";
	}
	
	//Update prodcut based on ID (no usdate method, so need to get the product by ID and set the value and return it)
	public Product updateProduct(Product product) {
		
		Product existingProduct= productRepo.findById(product.getId()).orElse(null);
		
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		
		return productRepo.save(existingProduct);
	}
	
	
}
