package logic;

import exceptions.ArmEjDefineretException;

public class ArmImpl implements Arm {
	private double arm = Double.NaN;

	@Override
	public void angivArm(double arm) throws ArmEjDefineretException {
		if (arm <= 0)
			throw new ArmEjDefineretException();
		this.arm = arm;
		
	}

	@Override
	public double getArm() {
		return arm;
	}

}
