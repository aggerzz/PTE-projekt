package logic;

import exceptions.InertimomentEjDefineretException;
import exceptions.NegativInertimomentException;

public class InertimomentImpl implements Inertimoment {
	private double mm4 = Double.NaN;

	@Override
	public double getInertimoment() throws InertimomentEjDefineretException {
		if(mm4==Double.NaN)
			throw new InertimomentEjDefineretException();
		return mm4;
	}
	
	public void setMm4(double mm4) throws NegativInertimomentException {
		if (mm4 <= 0 || mm4 == Double.NaN)
			throw new NegativInertimomentException();
		this.mm4 = mm4;
	}
	
}