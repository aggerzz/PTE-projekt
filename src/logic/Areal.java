package logic;

import exceptions.ArealEjDefineretException;
import exceptions.NegativArealException;

public interface Areal {
	public double getMm2() throws ArealEjDefineretException;
	
	public void setMm2(double mm2) throws NegativArealException;
	

}
