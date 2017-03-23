package logic;

import java.text.DecimalFormat;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.NegativArealException;
import exceptions.NormalkraftEjDefineretException;
import exceptions.NormalspaendingEjDefineretException;
import exceptions.VinkelEjDefineretException;

public class NormalspaendingImpl implements Normalspaending {
	private Normalkraft fn;
	private Areal a;
	public double sigmaN;
	private String mellemregning;
	private double sigmaNMm2;
	
	DecimalFormat formatter = new DecimalFormat("#0.00000");
	
	public void angivNormalkraft(Normalkraft fn) throws NormalkraftEjDefineretException{
		if(fn != null){
			this.fn = fn;
		}
		else{
			throw new NormalkraftEjDefineretException();
		}
	}
	
	public void angivAreal(Areal a) throws NegativArealException{
		if(a.getMm2() > 0){
			this.a = a;
		}
		else{
			throw new NegativArealException();
		}
	}
	
	public double getSigmaNmm2() throws NormalspaendingEjDefineretException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
		
		if(fn == null | a == null){
			throw new NormalspaendingEjDefineretException();
		}
		double fnNewton = fn.getNewton();
		double mm2 = a.getMm2();
		sigmaN = fnNewton / mm2;
		String fnText = formatter.format(fnNewton);
		String mm2Text = formatter.format(mm2);
		String sigmaNText = formatter.format(sigmaN);
		//setMellemregning("Fn\t	 /\t	A " + "\t	=\t	SigmaN" + "\n" + fnNewton + "\t	/\t	" + mm2 +"\t	=\t	" +sigmaN + "\n");
		setMellemregning("Fn / A " + "= SigmaN" + "\n" + fnText + " / " + mm2Text +" = " +sigmaNText + "\n");
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
