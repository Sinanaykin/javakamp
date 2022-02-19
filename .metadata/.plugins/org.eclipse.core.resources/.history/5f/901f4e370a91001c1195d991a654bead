package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;

@RestController //RestController olduğu belirttik
@RequestMapping("/api/products") //yolunu belirttik 
public class ProductsController {
	
	private ProductService productService;
	
	@Autowired//projeyi tarar productService i bulur arkada instance olusturur zaten bizim new dememize gerek kalmaz
	//Aslında bir nevi C# da dependency injection yaparken   Ioc bizim için nesne oluşturup yönetiyordu (singleton,addscoped,transied ) 
	//burda da yine  nin nesne oluşturması için @Autowired kullanırız
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}


	@GetMapping("/getall")//yolunu veriyoruz burdada
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {//@RequestBody benim gönderdiğim alanları gidiyo Product Entity si içinde karşılığını bulup map ediyor.C# daki FromBody ile aynı şey
		return this.productService.add(product);		
	}

}
