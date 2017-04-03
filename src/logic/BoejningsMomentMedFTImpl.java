package logic;

import java.text.DecimalFormat;

import exceptions.ArmEjDefineretException;
import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.TvaerkraftEjDefineretException;
import exceptions.VinkelEjDefineretException;

public class BoejningsMomentMedFTImpl implements BoejningsMomentMedFT {
	Tvaerkraft ftNewton;
	Arm arm;
	Laengde l2;
	String mellemregning = "";
	
	@Override
	public void angivTvaerkraft(Tvaerkraft ftNewton) throws TvaerkraftEjDefineretException {
		if (ftNewton != null) {
			this.ftNewton = ftNewton;
		} else {
			throw new TvaerkraftEjDefineretException();
		}
	}
	
	/*@Override
	public void angivLaengde(Laengde L2) throws LaengdeEjDefineretException {
		if (L2 != null) {
			this.l2 = L2;
		} else {
			throw new LaengdeEjDefineretException();
		}
	}
	*/
	@Override
	public void beregnBoejningsMoment() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, ArmEjDefineretException, TvaerkraftEjDefineretException {
		if(ftNewton == null)
			throw new TvaerkraftEjDefineretException();
			
		if(arm == null)
			throw new ArmEjDefineretException();
		
		DecimalFormat formatter = new DecimalFormat("#0.00000");
		double boejningsMoment = ftNewton.getNewton() * arm.getArm();
		
		String ftNewtonText = formatter.format(ftNewton.getNewton());
		String armText = formatter.format(arm.getArm());
		String boejningsMomentText = formatter.format(boejningsMoment);
				
		mellemregning = "ftNewton * arm  = MB\n" + ftNewtonText + " / " + armText + " = " + boejningsMomentText;
	}
	@Override
	public double getBoejningsMoment() throws TvaerkraftEjDefineretException, ArmEjDefineretException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
		if (ftNewton == null) {
			throw new TvaerkraftEjDefineretException();
		}
		if (arm == null) {
			throw new ArmEjDefineretException();
		}

		return ftNewton.getNewton() * arm.getArm();
	}
	@Override
	public String getBoejningsMomentMellemRegning() {
		return mellemregning;
	}

	@Override
	public void angivArm(Arm arm) throws ArmEjDefineretException {
		// TODO Auto-generated method stub
		
	}
	
}
