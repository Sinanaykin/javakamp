package kodlamaio.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product,Integer>{ 
//ProductDao JpaRepository extend ediyor(interface interface i extend eder) ve içine Entity mizi ve primary key veri tipini gir.Artık Crud işlemlerini yapabiliriz. 

}
