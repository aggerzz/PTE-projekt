package logic;

import exceptions.HalvProfilhoejdeEjDefineretException;
import exceptions.NegativHalvProfilhoejdeException;

public interface HalvProfilhoejde {
	
	public double getHalvProfilhoejde() throws HalvProfilhoejdeEjDefineretException;
	
	public void setMm(double mm) throws NegativHalvProfilhoejdeException;

}