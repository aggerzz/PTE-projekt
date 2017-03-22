package presentation;

public class KommaKontrol {
	public String kontrol(String s ){
		if(s.contains(",")){
			s.replace(",", ".");
		}
		return s;
	}
}
