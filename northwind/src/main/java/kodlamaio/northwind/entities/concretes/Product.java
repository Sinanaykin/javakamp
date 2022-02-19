package kodlamaio.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity//Product ın bir Entity oldugunu söyleriz
@Table(name="products")//db de hangi tabloya karşılık geliyor onu belirtiriz
@AllArgsConstructor
@NoArgsConstructor
@Data //Getter ve Setter için lombok kullanıyoruz burda
public class Product {
	
	@Id//primary key oldugunu göstermek için
	@GeneratedValue(strategy=GenerationType.IDENTITY)//otomatik artan  olmaı için.Db tarafından oldugunu belirtmek istersek strategy ile yapıyoruz
	@Column(name="product_id")//db de hangi kolona karşılık geldiğini gösteririz
	private int id; //bu özellikleri db deki northwind e göre yazdık
	
	//Burdan private int categoryId yi kaldırdık çünkü aşağıdaki join içinden ulaşabiliyoruz buna zaten am EF de bunu yazıyoduk , hibernate de yazmayız.
	
	@Column(name="product_name")
	private String productName; 
	
	@Column(name="unit_price")
	private double unitPrice;
	
	@Column(name="units_in_stock")
	private short unitsInStock; 
	
	@Column(name="quantity_per_unit")
	private String quantityPerUnit;
	
	@ManyToOne()//Product many category one demek bu
	@JoinColumn(name="category_id")//iki tabloyu ne ile join ettiğimizi söylüyoruz bunda.Aynı 2.cil anahtar gibi
	private Category category;
	
	

}
