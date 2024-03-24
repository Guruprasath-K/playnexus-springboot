package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService{

	@Autowired
	ProductRepository productRepository;
	
	public void addProduct(Product product) {
		productRepository.save(product);
	}

	public boolean productExists(String productName) {
		Product product = productRepository.findByProductName(productName);
		if(product == null) {
			return false;
		}else {
			return true;
		}
		
	}

	public List<Product> fetchAllProducts() {
		return productRepository.findAll();
	}

	public Product getProductById(int productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        return productOptional.orElse(null);
    }
	public List<Product> searchItem(String keyword) {
	    return productRepository.findByProductNameContainingIgnoreCase(keyword);
	}

	public Product findProductById(int id) {
		
		return productRepository.findById(id).orElse(null);
	}

	public void deleteProduct(Product deleteProduct) {
		productRepository.delete(deleteProduct);
	}

	public List<Integer> getAllProductIds() {
		 List<Integer> productIds = new ArrayList<>();
	        List<Product> products = fetchAllProducts();
	        for (Product product : products) {
	            productIds.add(product.getId());
	        }
	        return productIds;
	    }
	
}
	

