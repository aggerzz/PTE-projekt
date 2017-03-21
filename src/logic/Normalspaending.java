package logic;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.NormalspaendingEjDefineretException;
import exceptions.VinkelEjDefineretException;

public interface Normalspaending {
	public double getSigmaNmm2() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, NormalspaendingEjDefineretException;
	public void setSigmaNmm2(double nMm2);
	public void setMellemregning(String mellemregning);
	public String getMellemregning();
	public void angivNormalkraft(Normalkraft fn);
	public void angivAreal(Areal a);
}
