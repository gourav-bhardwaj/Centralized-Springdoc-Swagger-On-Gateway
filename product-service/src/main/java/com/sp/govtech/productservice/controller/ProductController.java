package com.sp.govtech.productservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@Value("${server.port}")
	private Integer serverPort;

	@GetMapping("/product-details")
	public String getProductDetails() {
		return "Product details wil be provide you soon";
	}
	
	@GetMapping("/product-details/{productId}")
	public String getProductDetails(@PathVariable Integer productId) {
		return "Product details wil be provide you soon of ID: %d".formatted(productId);
	}
	
	@GetMapping("/product-details/port")
	public String currentInstance() {
		return "Current running instance: %d".formatted(serverPort);
	}
	
}
