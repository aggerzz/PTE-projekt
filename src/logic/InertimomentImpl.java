package logic;

import exceptions.NegativInertimomentException;

public class InertimomentImpl implements Inertimoment {
	private double mm4 = Double.NaN;

	@Override
	public double getInertimoment() {
		return mm4;
	}
	
	public void setMm4(double mm4) throws NegativInertimomentException {
		if (mm4 <= 0 || mm4 == Double.NaN)
			throw new NegativInertimomentException();
		this.mm4 = mm4;
	}
	
}