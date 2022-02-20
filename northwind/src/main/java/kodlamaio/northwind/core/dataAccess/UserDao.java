package kodlamaio.northwind.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.core.entities.User;

public interface UserDao  extends JpaRepository<User,Integer>{
	//JpaRepository de çoğu kullanıcı işlemleri için metod var extra metod eklemek istersek buraya yazarız aynı ProductDao daki gibi
	User findByEmail(String email);
	
}
