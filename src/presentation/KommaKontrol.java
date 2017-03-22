package presentation;

public class KommaKontrol {
	public String kontrol(String s ){
		if(s.contains(",")){
			s = s.replaceAll(",", ".");
			if(s.indexOf(".")<s.lastIndexOf(".")){
				sletPunktummer(s);
				
			}
		}
		return s;
	}
	private String sletPunktummer(String s){
		String s1 = s.substring(0, s.indexOf("."));
		String s2 = s.substring(s.indexOf("."),s.lastIndexOf("."));
		String s3 = s.substring(s.lastIndexOf("."),s.length());
		
		return s = s1+s3;
	}
	
}
