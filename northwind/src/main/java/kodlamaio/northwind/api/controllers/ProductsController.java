package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

@RestController //RestController olduğu belirttik
@RequestMapping("/api/products/") //yolunu belirttik 
public class ProductsController {
	
	private ProductService productService;
	
	@Autowired//projeyi tarar productService i bulur arkada instance olusturur zaten bizim new dememize gerek kalmaz
	//Aslında bir nevi C# da dependency injection yaparken   Ioc bizim için nesne oluşturup yönetiyordu (singleton,addscoped,transied ) 
	//burda da yine  nin nesne oluşturması için @Autowired kullanırız
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}


	@GetMapping("getall")//yolunu veriyoruz burdada
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	}
	
	@PostMapping("add")
	public Result add(@RequestBody Product product) {//@RequestBody benim gönderdiğim alanları gidiyo Product Entity si içinde karşılığını bulup map ediyor.C# daki FromBody ile aynı şey
		return this.productService.add(product);		
	}
	
	@GetMapping("getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){//Yapılan isteğin parametrelerine bak orda productName olanı oku
		return this.productService.getByProductName(productName);
	}
	
	
	@GetMapping("getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){//Yapılan isteğin parametrelerine bak orda productName olanı oku
		return this.productService.getByProductNameAndCategoryId(productName,categoryId);
	}
	
	@GetMapping("getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		return this.productService.getByProductNameContains(productName);
	}
	
	
	@GetMapping("getAllByPage")
	public DataResult<List<Product>> getAll(int pageNo,int pageSize){
		return this.productService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("getAllDesc")//azalan metod yaptık
	public DataResult<List<Product>> getAllShorted(){
		return this.productService.getAllShorted();
	}
	
	@GetMapping("getProductWtihCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
		return this.productService.getProductWithCategoryDetails();
	}
	
	
	
	
	

	
	

}
