package com.edusol.billing.controller;

//import java.util.Arrays;
//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.edusol.billing.model.Products;
import com.edusol.billing.service.BillingService;

@RestController
@RequestMapping("/billing")
public class BillingController {
	
	@Autowired
	BillingService billingservice;

	@GetMapping("/get-products")
	public ResponseEntity<Products[]> getProducts() {
		
		return billingservice.getProducts();	
	}
	
	@GetMapping("/get-products-by-id")
	public ResponseEntity<Products>getProductsByid(@RequestParam int id){
		return billingservice.getProductsByid(id);
	}
	
	@GetMapping("get-product-by-category")
	public ResponseEntity<Products[]> getProductByCategory(@RequestParam String category){
		
		return billingservice.getProductByCategory(category);
		}
	
	@GetMapping("/get-product-by-price")
	public ResponseEntity<Products[]> getProductByPrice(@RequestParam float price) {
		
		return billingservice.getProductByPrice(price);
		
	}
	
	@GetMapping("/get-products-by-price-and-category")
	public ResponseEntity<Products[]> getProductByPriceAndCategory(@RequestParam float price,@RequestParam String category) {
		
	return billingservice.getProductByPriceAndCategory(price,category);
	}
	
	
	@GetMapping("/get-products-by-price-range")
	public ResponseEntity<Products[]> getProductByPricerange(@RequestParam float min,@RequestParam float max) {
		
	return billingservice.getProductByPriceRange(min,max);
	}
	
	@GetMapping("/get-products-by-pricerange-and-category")
	public ResponseEntity<Products[]> getProductByPricerangeAndCategory(@RequestParam float min,@RequestParam float max,@RequestParam String category) {
		
	return billingservice.getProductByPricerangeAndCategory(min,max,category);
	}
	@PostMapping("/save-record")
	public String saveRecord(@RequestBody Products p) {
		return billingservice.saveRecord (p);
	}
	
	@PutMapping("/update-record")
	public String updateRecord(@RequestBody Products p) {
		return billingservice.updateRecord (p);
	}
	
	@DeleteMapping("/delete-record")
	public String deleteRecord(@RequestParam int id) {
		return billingservice.deleteRecord (id);
		
		
	}
	
	
	}


