package logic;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.NormalspaendingEjDefineretException;
import exceptions.VinkelEjDefineretException;

public class NormalspaendingImpl implements Normalspaending {
	private Normalkraft fn;
	private Areal a;
	public double sigmaN;
	private String mellemregning;
	private double sigmaNMm2;
	
	public void angivNormalkraft(Normalkraft fn){
		if(fn != null){
			this.fn = fn;
		}
	}
	
	public void angivAreal(Areal a){
		if(a != null){
			this.a = a;
		}
	}
	
	public double getSigmaNmm2() throws NormalspaendingEjDefineretException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
		
		if(fn == null | a == null){
			throw new NormalspaendingEjDefineretException();
		}
		double fnNewton = fn.getNewton();
		double mm2 = a.getMm2();
		sigmaN = fnNewton / mm2;
		setMellemregning("Fn\t	 /\t	A " + "\t	=\t	SigmaN" + "\n" + fnNewton + "\t	/\t	" + mm2 +"\t	=\t	" +sigmaN + "\n");
		return sigmaN;
	}
	
	public void setSigmaNmm2(double sigmaNmm2){
		this.sigmaNMm2 = sigmaNmm2;
	}
	
	public void setMellemregning(String mellemregning){
		this.mellemregning = mellemregning;
	}
	
	public String getMellemregning(){
		return mellemregning;
	}

}
