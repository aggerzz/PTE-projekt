package logic;

import exceptions.ArealEjDefineretException;
import exceptions.BoejningsspaendingEjDefineretException;
import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.ForskydningsspaendingEjDefineretException;
import exceptions.NormalspaendingEjDefineretException;
import exceptions.TvaerkraftEjDefineretException;
import exceptions.VinkelEjDefineretException;
import exceptions.angivBoejningsspaendingEjDefineretException;

public class ReferencespaendingImpl implements Referencespaending {

	private double sigmaRef = Double.NaN;
//	private orveregraense = Double.NaN, nedergraense = Double.NaN;
	private String sigmaRefMellemRegning;
	Normalspaending sigmaN = new NormalspaendingImpl();
	Boejningsspaending sigmaB = new BoejningsspaendingImpl();
	ForskydningsSpaendning tau = new ForskydningsSpaendningImpl();
	
	@Override
	public double getSigmaRef() {
//		Den måde OC11 ville have vi skulle gøre det på:
		
//		if(sigmaN.getSigmaNmm2() != 0 && sigmaB.getSigmaBmm2() != 0){
//			sigmaRef = (Math.sqrt((Math.pow((sigmaN.getSigmaNmm2() + sigmaB.getSigmaBmm2()), 2))) + 3 * Math.pow(tau.getNmm2(), 2));
//		} else {
//			sigmaRef = (3 * Math.pow(tau.getNmm2(), 2));
//		}
		
//		Det her gør det samme, men fylder 1 linje kode...
		try {
		sigmaRef = (Math.sqrt((Math.pow((sigmaN.getSigmaNmm2() + sigmaB.getBoejningsspaending()), 2)) + 3 * Math.pow(tau.getNmm2(), 2)));
		sigmaRefMellemRegning = "√((SigmaN + SigmaB)² + 3 * Tau²) = SigmaRef\n"
		+ "√((" + sigmaN.getSigmaNmm2() + "+" + sigmaB.getBoejningsspaending() + ")² + 3 * " + tau.getNmm2() + "²) = " + sigmaRef;
		} catch (DimensionerendeKraftEjDefineretException | VinkelEjDefineretException
				| NormalspaendingEjDefineretException | BoejningsspaendingEjDefineretException
				| ForskydningsspaendingEjDefineretException | ArealEjDefineretException
				| TvaerkraftEjDefineretException e) {
			e.printStackTrace();
		}
		return sigmaRef;

	}


	@Override
	public String GetMellemRegning() {
		return sigmaRefMellemRegning;
		}

	@Override
	public void angivNormalspaending(Normalspaending sigmaN) throws NormalspaendingEjDefineretException {
		this.sigmaN = sigmaN;
	}

	@Override
	public void angivBoejningsspaending(Boejningsspaending sigmaB) throws angivBoejningsspaendingEjDefineretException {
		this.sigmaB = sigmaB;
	}

	@Override
	public void angivForskydsningsspaending(ForskydningsSpaendning tau)	throws ForskydningsspaendingEjDefineretException {
		this.tau = tau;
	}


	@Override
	public void setSigmaRefNmm2(double sigmaRefNmm2) {
		this.sigmaRef = sigmaRefNmm2;
	}
	
	
}
