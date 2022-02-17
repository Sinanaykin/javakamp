package kodlamaio.northwind.core.utilities.results;

public class ErrorResult extends Result {
	public ErrorResult() { //sadece success dönebilir onuda false verdik .sadece false döner
		super(false);
	}
	
	public ErrorResult(String message) {//success ve message dönebilir ama success otomatik false verdik sadece message giricez
		super(false,message);//base sınıftaki çalısır
	}


}
