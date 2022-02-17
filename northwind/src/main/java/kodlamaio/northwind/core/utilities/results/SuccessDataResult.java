package kodlamaio.northwind.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T> {//DataResult ı kalıtım aldık
	
	public SuccessDataResult(T data,String message) {
		super(data,true,message);//otomatik true döner data ve message göndeririz sadece
		
	}
	
	public SuccessDataResult(T data) {
		super(data,true);//otomatik true döner ve sadece data  göndeririz 
		
	}
	
	public SuccessDataResult(String message) {
		super(null,true,message);//otomatik true döner sadece message göndeririz 
		
	}
	
	public SuccessDataResult() {
		super(null,true);//sadece true döner
		
	}

}
