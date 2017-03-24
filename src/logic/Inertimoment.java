package logic;

import exceptions.InertimomentEjDefineretException;
import exceptions.NegativInertimomentException;

public interface Inertimoment {

	public double getInertimoment() throws InertimomentEjDefineretException;
	
	public void setMm4(double mm4) throws NegativInertimomentException;
}