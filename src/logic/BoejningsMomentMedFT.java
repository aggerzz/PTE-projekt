package logic;

import exceptions.ArmEjDefineretException;
import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.LaengdeEjDefineretException;
import exceptions.TvaerkraftEjDefineretException;
import exceptions.VinkelEjDefineretException;

public interface BoejningsMomentMedFT {
	public void angivTvaerkraft(Tvaerkraft ftNewton) throws TvaerkraftEjDefineretException;
	public void angivArm(Arm arm) throws ArmEjDefineretException;
	public void beregnBoejningsMoment() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, ArmEjDefineretException, TvaerkraftEjDefineretException;
	public double getBoejningsMoment() throws LaengdeEjDefineretException, DimensionerendeKraftEjDefineretException, TvaerkraftEjDefineretException, ArmEjDefineretException, VinkelEjDefineretException;
	public String getBoejningsMomentMellemRegning();

}
