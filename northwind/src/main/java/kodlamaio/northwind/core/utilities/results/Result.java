package kodlamaio.northwind.core.utilities.results;

public class Result { //Burda Result çıplak kaldı interfaceden türetmedik C# daki gibi buda Javanın özelliği .Burda Super type  deniyor buna
	private boolean success;
	private String message;
	
	public Result(boolean success){//Burda mesaj döndürmek istemiyoruz sadece success dönsün
		this.success=success;
	
	}
	
	public Result(boolean success,String message){//Hem success hem message dönsün istiyoruz
		this(success);//yukarıdaki success demek bu.Tek parametreli ctor çalışsın diyoruz yani böyle
		this.message=message;
		
	}

	public boolean isSuccess() { //Burda getterlarını oluşturduk
		return this.success;
	}


	public String getMessage() {
		return this.message;
	}



}
