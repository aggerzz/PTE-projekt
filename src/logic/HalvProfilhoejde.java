package logic;

import exceptions.NegativHalvProfilhoejdeException;

public interface HalvProfilhoejde {
	
	public double getHalvProfilhoejde();
	
	public void setMm(double mm) throws NegativHalvProfilhoejdeException;

}