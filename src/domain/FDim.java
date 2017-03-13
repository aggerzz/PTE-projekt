package domain;

import java.math.BigDecimal;

public class FDim extends BigDecimal {
	private static final long serialVersionUID = 1L;
	BigDecimal dimensionerendeKraft;
	BigDecimal Kg;
	String mellemRegning = "";
	public static final BigDecimal tyngdeKraft = new BigDecimal("9.816");
	
	public FDim(String value){
		super(value);
	}
	public BigDecimal getFdim() {
		return dimensionerendeKraft;
	}
	public void setFdim(BigDecimal fdim) {
		dimensionerendeKraft = fdim;
	}
	@Override
	public String toString() {
		return dimensionerendeKraft.toString();
	}
	public static BigDecimal beregnDimensionerendeKraft(BigDecimal weightInKg){
		return weightInKg.multiply(tyngdeKraft);
	}
	public BigDecimal getKg() {
		return Kg;
	}
	public void setKg(BigDecimal kg) {
		Kg = kg;
		dimensionerendeKraft = beregnDimensionerendeKraft(Kg);
	}
	public String getMellemRegning() {
		return mellemRegning;
	}
	public void setMellemRegning(String mellemRegning) {
		this.mellemRegning = mellemRegning;
	}
	public static BigDecimal getTyngdekraft() {
		return tyngdeKraft;
	}
}
