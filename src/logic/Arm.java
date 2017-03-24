package logic;

import exceptions.ArmEjDefineretException;

public interface Arm {
	public void angivArm(double arm) throws ArmEjDefineretException;

	public double getArm();
	
}
