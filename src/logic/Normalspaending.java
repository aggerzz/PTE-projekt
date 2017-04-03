package logic;

import exceptions.ArealEjDefineretException;
import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.NegativArealException;
import exceptions.NormalkraftEjDefineretException;
import exceptions.NormalspaendingEjDefineretException;
import exceptions.VinkelEjDefineretException;

public interface Normalspaending {
	public double getSigmaNmm2() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, NormalspaendingEjDefineretException, ArealEjDefineretException;
	public void setSigmaNmm2(double nMm2);
	public void setMellemregning(String mellemregning);
	public String getMellemregning();
	public void angivNormalkraft(Normalkraft fn)throws NormalkraftEjDefineretException;
	public void angivAreal(Areal a) throws NegativArealException, ArealEjDefineretException;
}
