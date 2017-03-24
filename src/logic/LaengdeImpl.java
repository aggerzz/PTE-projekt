package logic;

import exceptions.LaengdeEjDefineretException;

public class LaengdeImpl implements Laengde {
	double l2;
	@Override
	public void angivLaengde(double l2) {
		this.l2=l2;
	}

	@Override
	public double getLaengde() throws LaengdeEjDefineretException {
		if(l2==Double.NaN)
			throw new LaengdeEjDefineretException();
		return l2;
	}

}
