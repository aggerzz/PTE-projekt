package logic;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.LaengdeEjDefineretException;

public class BoejningsMomentImpl implements BoejningsMoment {
	Dimensionerendekraft fdim;
	Laengde l2 ;
	String mellemRegning = "";

	@Override
	public void angivDimensionerendeKraft(Dimensionerendekraft fdim) throws DimensionerendeKraftEjDefineretException {
		if (fdim != null) {
			this.fdim = fdim;
		} else {
			throw new DimensionerendeKraftEjDefineretException();
		}
	}

	@Override
  public void angivLaengde(LaengdeImpl L2) throws LaengdeEjDefineretException {
		if (L2 != null) {
			this.l2 = L2;
		} else {
			throw new LaengdeEjDefineretException();
		}
	}

	@Override
	public void beregnBoejningsMoment() {
		double boejningsMoment = fdim.getNewton() / l2.getLaengde();
		mellemRegning = "Bm = Fdim / l \n" + boejningsMoment + " = " + fdim.getNewton() + " / " + l2.getLaengde();
	}

	@Override
	public double getBoejningsMoment() throws LaengdeEjDefineretException, DimensionerendeKraftEjDefineretException {
		if (fdim == null) {
			throw new DimensionerendeKraftEjDefineretException();
		}
		if (l2 == null) {
			throw new LaengdeEjDefineretException();

		} else if (fdim != null && l2 != null) {
			return fdim.getNewton() / l2.getLaengde();
		} else
			return Double.NaN;
	}

}
