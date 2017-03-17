package logic;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.VinkelEjDefineretException;

public interface ForskydningsSpaendning {
	
	public double beregnTau() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException;
	public void setMellemregning(String mellemregning);
	public String getMellemregning();
}
