package logic;

import exceptions.NegativHalvProfilhoejdeException;

public class HalvProfilhoejdeImpl implements HalvProfilhoejde {
	private double mm;

	@Override
	public double getHalvProfilhoejde() {
		return this.mm;

	}
	
	public void setMm(double mm) throws NegativHalvProfilhoejdeException {
		if (mm <= 0 || Double.isNaN(mm))
			throw new NegativHalvProfilhoejdeException();
		this.mm = mm;
	}

}