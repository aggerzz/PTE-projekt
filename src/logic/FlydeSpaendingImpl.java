package logic;

import exceptions.FlydeSpaendingEjDefineretException;

public class FlydeSpaendingImpl implements FlydeSpaending {
	private double SigmaTill = Double.NaN;
	
	@Override
	public void angivFlydeSpaending(double SigmaTill) throws FlydeSpaendingEjDefineretException {
		if(SigmaTill<=0) 
			throw new FlydeSpaendingEjDefineretException();
		this.SigmaTill = SigmaTill;

	}

	@Override
	public double getFlydeSpaending() {
		return SigmaTill;
	}

	@Override
	public boolean erFlydeSpaendingNormal() {
		return(0<SigmaTill && SigmaTill<=2250);
	}
}
