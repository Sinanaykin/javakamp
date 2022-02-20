package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

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
	public DataResult<List<Product>> getAll() {
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(),"Data listelendi");//Geriye veri ve mesaj döndürdük zaten otomatik true geliyor SuccessDataResult  dolayı
			//ProductDao nun extend ettiği JpaRepository un hazır olusturduğu metodlar direk gelir burda
	}


	@Override
	public Result add(Product product) {
		this.productDao.save(product);//save JpaRepository içindeki hazır metotlardan
		return new SuccessResult("Ürün eklendi");
	}


	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>(this.productDao.getByProductName(productName),"Data listelendi");
	}


	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Ürün ismine ve Kategori id sine göre filtrelendi");
	}


	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId),"Ürün ismine veya Kategori id sine göre filtrelendi");
	}


	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByCategoryIn(categories),"Data Listelendi");
	}


	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName),"Data Listelendi");
	}


	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName),"Data Listelendi");
	}


	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByNameAndCategory(productName,categoryId),"Data Listelendi");
	}


	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {//JPARepository nin findAll metodunun türevlerinde sayfalama için metot var
		
		Pageable pageable=PageRequest.of(pageNo-1, pageSize);//pageable nesnesini PageRequest.of metodu oluşturuyor.sonra pageable yi findAll a vericez
	   return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());//dönüş tipini okumak için getContent
	}


	@Override
	public DataResult<List<Product>> getAllShorted() {
	 Sort sort=Sort.by(Sort.Direction.DESC,"productName");//sort nesnesi bizim için Sort.by metodu ile olusuyor, azalan yaptık productName alanına göre ondan DESC
	 return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort));////JPARepository nin findAll metodunun türevlerinde sıralama için metot var
	}


	@Override 
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productDao.getProductWithCategoryDetails(),"Data Listelendi");
	}

}
