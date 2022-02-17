package kodlamaio.northwind.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T> {
	
	public ErrorDataResult(T data,String message) {
		super(data,false,message);//otomatik false döner data ve message göndeririz sadece
		
	}
	
	public ErrorDataResult(T data) {
		super(data,false);//otomatik false döner ve sadece data  göndeririz 
		
	}
	
	public ErrorDataResult(String message) {
		super(null,false,message);//otomatik false döner sadece message göndeririz 
		
	}
	
	public ErrorDataResult() {
		super(null,false);//sadece false döner
		
	}

}
