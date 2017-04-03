package logic;

import exceptions.ArealEjDefineretException;
import exceptions.NegativArealException;

public class ArealImpl implements Areal {
	private double mm2 = Double.NaN;

	@Override
	public double getMm2() throws ArealEjDefineretException {
		if (mm2 == Double.NaN)
			throw new ArealEjDefineretException();
		return mm2;
	}

	@Override
	public void setMm2(double mm2) throws NegativArealException {
		if(mm2<=0) 
			throw new NegativArealException();
		this.mm2 = mm2;

	}

}
