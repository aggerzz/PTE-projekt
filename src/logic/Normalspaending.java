package logic;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.VinkelEjDefineretException;

public interface Normalspaending {
	public double beregnNormalspaending() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException;
	public void setMellemregning(String mellemregning);
	public String getMellemregning();

}
