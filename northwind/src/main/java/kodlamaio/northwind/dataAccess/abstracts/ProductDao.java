package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product,Integer>{ 
//ProductDao JpaRepository extend ediyor(interface interface i extend eder) ve içine Entity mizi ve primary key veri tipini gir.Artık Crud işlemlerini yapabiliriz. 
 
	
	//JpaRepository deki metotlar dışında özel metot isersek aşağıdaki gibi  olusturabiliriz otomatik filtreler bizim için ve metotların db ile ilişkisi kurulur
	
	Product getByProductName(String productName);//Böyle yazınca başına getBy şeklinde otomatik bizim için filtreliyor ProductName e göre
	
	Product getByProductNameAndCategory_CategoryId(String productName,int categoryId);//Hem ProductName hem CategoryId ye göre filtreliyor.
	//Ama metot isminde getByProductNameAndCategoryId diyemiyoruz çünkü öyle bir alan  yok getByProductNameAndCategory_CategoryId deriz çünkü Category içindeki CategoryId(PrimaryKey) alanımız var
	
	List<Product> getByProductNameOrCategory_CategoryId(String productName,int categoryId);//Burda veya dedik ve liste olarak istedik
	
	List<Product> getByCategoryIn(List<Integer> categories);//Birden fazla category göndericez category ıd leri içerenlerin hepsini  getiricez
	
	List<Product> getByProductNameContains(String productName);//Ürün ismini içerenleri getiricez
	
	List<Product> getByProductNameStartsWith(String productName);//Gönderdiğimiz productName ile başlayanları getirir
	
	//JPAQL ile yazma(Linq ya benziyor)
	//Burda database i unut entitylere göre sorgu yazıyoruz.
	//Product entity sinde productName kolonu eşitse gönderdiğimiz parametre olan productName ve
	//Product entity sinde category içindeki categoryId kolonu eşitse gönderdiğimiz parametre olan categoryId ye getir diyoruz
	@Query("From Product  where productName=:productName and category.categoryId=:categoryId")//Tüm kolonlar gelsin istediğimiz için selecte gerek yok
	List<Product> getByNameAndCategory(String productName,int categoryId);//Yukardaki(getByProductNameAndCategoryId) ile aynı ama burda isimlendirme uymadık ve JPQL(Linq ya benzeyen bir yapı) ile yazmak istedik
	
	@Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto(p.id,p.productName,c.categoryName) From Category c Inner join c.products p")//Burda giderken önce ana tablodan git yani onetomany ise one olanı ilk yaz yani category i
	//Category ile Product joinle.Ama Producta Category içindeki products dan ulaş.Daha sonra parantez içindeki 3 alanı ProductWithCategoryDto ya aktar diyoruz burda
	List<ProductWithCategoryDto> getProductWithCategoryDetails();//Sadece id,productName,categoryName çekmek istersek bu metodu kullanıcaz geri dönüş değerini oluşturduğumuz Dto(ProductWithCategoryDto) verdik.
	

	
}
