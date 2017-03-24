package logic;

import exceptions.HalvProfilhoejdeEjDefineretException;
import exceptions.NegativHalvProfilhoejdeException;

public class HalvProfilhoejdeImpl implements HalvProfilhoejde {
	private double mm = Double.NaN;

	@Override
	public double getHalvProfilhoejde() throws HalvProfilhoejdeEjDefineretException {
		if (mm==Double.NaN)
			throw new HalvProfilhoejdeEjDefineretException();
		return this.mm;

	}
	
	public void setMm(double mm) throws NegativHalvProfilhoejdeException {
		if (mm <= 0 || Double.isNaN(mm))
			throw new NegativHalvProfilhoejdeException();
		this.mm = mm;
	}

}