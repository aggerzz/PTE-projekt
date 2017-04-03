package logic;

import exceptions.FlydeSpaendingEjDefineretException;

public interface FlydeSpaending {
	public void angivFlydeSpaending(double value) throws FlydeSpaendingEjDefineretException;
	public double getFlydeSpaending() throws FlydeSpaendingEjDefineretException;
	public boolean erFlydeSpaendingNormal();
}
