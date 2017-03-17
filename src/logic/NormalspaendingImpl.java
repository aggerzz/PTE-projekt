package logic;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.VinkelEjDefineretException;

public class NormalspaendingImpl {
	Normalkraft fn = new NormalkraftImpl();
	Areal a = new ArealImpl();
	private double fnNewton = Double.NaN;
	private double mm2 = Double.NaN;
	public double sigmaN;
	String mellemregning;
	
	public double beregnNormalspaending() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException{
		fnNewton = fn.getNewton();
		mm2 = a.getMm2();
		sigmaN = fnNewton / mm2;
		setMellemregning("SigmaN = Fn / A = \n" + fnNewton / mm2 );
		return sigmaN;
	}
	public void setMellemregning(String mellemregning){
		this.mellemregning = mellemregning;
	}
	public String getMellemregning(){
		return mellemregning;
	}

}
