package logic;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.FDimEjDefineret;
import exceptions.LaengdeEjDefineretException;

public interface BoejningsMoment {
	public void angivDimensionerendeKraft(Dimensionerendekraft fdim) throws DimensionerendeKraftEjDefineretException;
	public void angivLaengde(Laengde L2) throws LaengdeEjDefineretException;
	public void beregnBoejningsMoment() throws FDimEjDefineret;
	public double getBoejningsMoment() throws LaengdeEjDefineretException, DimensionerendeKraftEjDefineretException, FDimEjDefineret;
	public String getBoejningsMomentMellemRegning();
}
