package kodlamaio.northwind.core.utilities.results;

public class DataResult<T>  extends Result { //rESULT DAKİ MESAJ VE SUCCESS İ KULLANSIN DİYE RESULTI KALITIM ALDIK

	private T data;
	
	public DataResult(T data,boolean success, String message) {//Aynı Result daki gibi tek fark burda geri dönüş değeri oldugunda data ekledik
		super(success, message);//base sınıfı ctor u çalısır yani Result daki ler çalısır
		this.data=data;
		
	}
	public DataResult(T data,boolean success) {//Bunu sadece veri ve success dönmek için yaptık
		super(success);//base sınıfı ctor u çalısır yani Result daki  çalısır
		this.data=data;
		
	}
	
	public T getData() {//getter ını ekledik
		return this.data;
	}



}
