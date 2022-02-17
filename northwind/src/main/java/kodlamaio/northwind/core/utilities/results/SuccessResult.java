package kodlamaio.northwind.core.utilities.results;

public class SuccessResult  extends Result{ //Result dan kalıtım aldık
	
	public SuccessResult() { //sadece success dönebilir onuda true verdik
		super(true);
	}
	
	public SuccessResult(String message) {//success ve message dönebilir ama success otomatik true verdik
		super(true,message);//base sınıftaki çalısır
	}

}
