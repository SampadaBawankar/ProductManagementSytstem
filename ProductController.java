package com.product.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.product.web.model.Product;
import com.product.web.service.ProductService;


@Controller
public class ProductController {
    
	@Autowired
	private ProductService productService;
    //display list of employees
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listProducts", productService.getAllProducts());	
		return "index";
		
	}
	
	@GetMapping("/shownewProductForm")
	public String showNewProductForm(Model model) {
		// create model attribute to bind form data
		Product  product=new Product();
		model.addAttribute("product",  product);
		return "new_product";
	}
	
	@PostMapping("/saveProduct")
	public String saveEmployee(@ModelAttribute("product") Product product) {
		// save employee to database
		 productService.saveProduct(product);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFromForUpdate(@PathVariable (value="id") long id,Model model) {
		//get employee from the service
		Product product=productService.getProductById(id);
		
		//set employee as a model attribute to pre-populate the form 
		model.addAttribute("product", product);
		return "update_product";
	}
	
	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable(value="id") long id) {
		this.productService.deleteProductById(id);
		return "redirect:/";
	}
}
