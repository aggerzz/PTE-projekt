package logic;

import exceptions.FlydeSpaendingEjDefineretException;

public class FlydeSpaendingImpl implements FlydeSpaending {
	private double Nmm2 = Double.NaN;
	
	@Override
	public void angivFlydeSpaending(double Nmm2) throws FlydeSpaendingEjDefineretException {
		if(Nmm2<=0) 
			throw new FlydeSpaendingEjDefineretException();
		this.Nmm2 = Nmm2;

	}

	@Override
	public double getFlydeSpaending() {
		return Nmm2;
	}

	@Override
	public boolean erFlydeSpaendingNormal() {
		return(0<Nmm2 && Nmm2<=2250);
	}
}
