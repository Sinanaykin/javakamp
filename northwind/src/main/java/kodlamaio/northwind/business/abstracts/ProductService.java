package kodlamaio.northwind.business.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;

public interface ProductService {
	
	DataResult<List<Product>> getAll();
	
	DataResult<List<Product>> getAllShorted();//sıralama yapması için metot
	
	DataResult<List<Product>> getAll(int pageNo,int pageSize);//hangi sayfada ve o sayfa da kaç tane data var bunun için metot yazdık
	
	Result add(Product product);
	
	DataResult<Product> getByProductName(String productName);//Böyle yazınca başına getBy şeklinde otomatik bizim için filtreliyor ProductName e göre
	
	DataResult<Product> getByProductNameAndCategoryId(String productName,int categoryId);//Hem ProductName hem CategoryId ye göre filtreliyor
	
	DataResult<List<Product>> getByProductNameOrCategoryId(String productName,int categoryId);//Burda veya dedik ve liste olarak istedik
	
	DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);//Birden fazla category göndericez category ıd leri içerenlerin hepsini  getiricez
	
	DataResult<List<Product>> getByProductNameContains(String productName);//Ürün ismini içerenleri getiricez
	
	DataResult<List<Product>>  getByProductNameStartsWith(String productName);//Gönderdiğimiz productName ile başlayanları getirir
	
	DataResult<List<Product>> getByNameAndCategory(String productName,int categoryId);
	
	
	
	
	

}
