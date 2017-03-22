package logic;

import exceptions.NegativInertimomentException;

public interface Inertimoment {

	public double getInertimoment();
	
	public void setMm4(double mm4) throws NegativInertimomentException;
}