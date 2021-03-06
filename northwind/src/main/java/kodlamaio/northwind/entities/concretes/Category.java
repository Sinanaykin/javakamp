package kodlamaio.northwind.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="categories")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})//Benim söylediğim kadar mapping yap sonsuz döngüye girme en temel adımda kes demeliyiz.
//Çünkü Product içinde Category var ,her Category içinde de Product var sonsuz döngüye girer sorgular  bunu yazmazsak
public class Category {
	
	@Id
	@Column(name="category_id")
	private int categoryId;
	
	@Column(name="category_name")
	private String categoryName;
	
	@OneToMany(mappedBy="category")//categories tablosu ile products arasında 1 e çok ilişki var diyoruz.category one  products many demek bu.
	//mappedBy daki category =Product entity si içindeki (private Category category)  category demek
	private List<Product> products;

}
