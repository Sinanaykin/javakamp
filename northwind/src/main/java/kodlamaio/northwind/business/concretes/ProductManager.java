package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;

@Service //ProductManager classının bu  projede Service görevi göreceğini Springe bildiriyoruz
public class ProductManager implements ProductService{
	
	private ProductDao productDao;
	@Autowired//Arka planda ProductDao nun instance si olabilecek bir sınıf üretiyor ve onu veriyor
	//ProductDao yu enjekte edicek ortamı verir bize.
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}


	@Override
	public List<Product> getAll() {
		return this.productDao.findAll();//ProductDao nun extend ettiği JpaRepository un hazır olusturduğu metodlar direk gelir burda
	}

}
