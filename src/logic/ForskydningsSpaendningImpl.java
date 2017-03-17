package logic;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.VinkelEjDefineretException;

public class ForskydningsSpaendningImpl implements ForskydningsSpaendning {
	private Areal a = new ArealImpl();
	private Tvaerkraft ft = new TvaerkraftImpl();
	private double mm2 = Double.NaN;
	public double tau = Double.NaN;
	private String mellemregning;	
	
	public double beregnForskydningsspaendning() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException{
		double ftNewton = ft.getNewton();
		
		mm2 = a.getMm2();
		tau = ftNewton / mm2;
		setMellemregning("Tau = Ft / A = " + "\n" + ftNewton / mm2);
		return tau ;		
	}
	
	public void setMellemregning(String mellemregning){
		this.mellemregning = mellemregning;
	}
	
	public String getMellemregning(){
		return mellemregning;
	}	
}
