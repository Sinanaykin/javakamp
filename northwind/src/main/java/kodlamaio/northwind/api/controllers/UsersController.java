package kodlamaio.northwind.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.UserService;
import kodlamaio.northwind.core.entities.User;
import kodlamaio.northwind.core.utilities.results.ErrorDataResult;



@RestController
@RequestMapping(value="/api/users/")
public class UsersController {
	
	private UserService userService;
    
	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping(value="add")
	                          //@Valid doğrulama metodundan geçir demek buda.
	public ResponseEntity<?> add(@Valid @RequestBody User user) {//ekleme işleminde geriye dönüş değerimizi bu şekilde vericez Result veya DataResult şeklinde vermicez artık. olumlumu olumsuz mu bilmediğimiz için  ? veriyoruzu içine
		return ResponseEntity.ok(this.userService.add(user));//İşlem basarılı ise ekle deriz.değilse doğrulama metodundan gecemez hata verir
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)//Sistemde bir VALİDATİON hatası oluşursa aşağıdaki metodu çağır demek
	@ResponseStatus(HttpStatus.BAD_REQUEST)//DİREK BAD REQUEST DÖNSÜN DİYORUZ
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){//Hatalarımızı parametre olarak geçtik burda
		Map<String,String> validationErrors=new HashMap<String,String>();//Bir tane Dictionary oluşturduk  liste gibi yani
		for(FieldError fieldError:exceptions.getBindingResult().getFieldErrors()) {//hataları dolaş fieldError a ekle
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());//hataları ve mesajı validationErrors a yolla
		}
		ErrorDataResult<Object> errors=new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");//hatayı ve mesajı ErrroDataResult ın içine koy diyoruz
		return errors;//erorsu döndük
	}
	

}
