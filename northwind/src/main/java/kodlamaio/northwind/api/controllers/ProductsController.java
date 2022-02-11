package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.entities.concretes.Product;

@RestController //RestController olduğu belirttik
@RequestMapping("/api/products") //yolunu belirttik 
public class ProductsController {
	
	private ProductService productService;
	
	@Autowired//projeyi tarar productService i bulur arkada instance olusturur zaten bizim new dememize gerek kalmaz
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}


	@GetMapping("/getall")//yolunu veriyoruz burdada
	public List<Product> getAll(){
		return this.productService.getAll();
	}

}