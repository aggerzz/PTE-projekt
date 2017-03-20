package logic;

import exceptions.ArealEjDefineretException;
import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.ForskydningsspaendingEjDefineretException;
import exceptions.TvaerkraftEjDefineretException;
import exceptions.VinkelEjDefineretException;

public interface ForskydningsSpaendning {
	
	public String getMellemregning();
	public void angivTvaerkraft(Tvaerkraft ft) throws ForskydningsspaendingEjDefineretException;
	public void angivAreal(Areal a) throws ArealEjDefineretException;
	public double getNmm2() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, ForskydningsspaendingEjDefineretException, ArealEjDefineretException, TvaerkraftEjDefineretException;
	public void setNmm2(double nMm2);
}
