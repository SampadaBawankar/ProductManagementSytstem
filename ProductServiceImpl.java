package com.product.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.web.model.Product;
import com.product.web.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService{
    
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		this.productRepository.save(product);
	}

	@Override
	public Product getProductById(long id) {
		  Optional<Product> optional = productRepository.findById(id);
		  Product product=null;
		   if(optional.isPresent()) {
			   product= optional.get();
		   }else {
			   throw new RuntimeException("Employee not found for id ::" +id);
		   }
		   return product;
	}

	@Override
	public void deleteProductById(long id) {
		// TODO Auto-generated method stub
		this.productRepository.deleteById(id);
	}
	
}
