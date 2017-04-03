package logic;

import java.text.DecimalFormat;

import exceptions.ArealEjDefineretException;
import exceptions.BoejningsspaendingEjDefineretException;
import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.ForskydningsspaendingEjDefineretException;
import exceptions.HalvProfilhoejdeEjDefineretException;
import exceptions.InertimomentEjDefineretException;
import exceptions.LaengdeEjDefineretException;
import exceptions.NormalspaendingEjDefineretException;
import exceptions.ReferenceSpaendingEjDefineretException;
import exceptions.TvaerkraftEjDefineretException;
import exceptions.VinkelEjDefineretException;
import exceptions.angivBoejningsspaendingEjDefineretException;

public class ReferencespaendingImpl implements Referencespaending {

	private double sigmaRef;
	private String sigmaRefMellemRegning;
	Normalspaending sigmaN;
	Boejningsspaending sigmaB;
	ForskydningsSpaendning tau;
	
	@Override
	public double getSigmaRef() throws InertimomentEjDefineretException, HalvProfilhoejdeEjDefineretException, LaengdeEjDefineretException, ReferenceSpaendingEjDefineretException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, NormalspaendingEjDefineretException, ArealEjDefineretException, BoejningsspaendingEjDefineretException, ForskydningsspaendingEjDefineretException, TvaerkraftEjDefineretException {
		if(sigmaN == null || sigmaB == null || tau == null){
			throw new ReferenceSpaendingEjDefineretException();
		}
		
		DecimalFormat formatter = new DecimalFormat("#0.00000");
		
		double sigmaNDouble = sigmaN.getSigmaNmm2();
		double sigmaBDouble = sigmaB.getBoejningsspaending();
		double tauDouble = tau.getNmm2();
				
		sigmaRef = (Math.sqrt((Math.pow((sigmaN.getSigmaNmm2() + sigmaB.getBoejningsspaending()), 2)) + 3 * Math.pow(tau.getNmm2(), 2)));
		
		String sigmaNText = formatter.format(sigmaNDouble);
		String sigmaBText = formatter.format(sigmaBDouble);
		String tauText = formatter.format(tauDouble);
		String sigmaRefText = formatter.format(sigmaRef);
		
		sigmaRefMellemRegning = "√((SigmaN + SigmaB)² + 3 * Tau²) = SigmaRef\n"
		+ "√((" + sigmaNText + "+" + sigmaBText + ")² + 3 * " + tauText + "²) = " + sigmaRefText + "\n";
		
		return sigmaRef;

	}

	@Override
	public String getSigmaRefMellemregning() {
		return sigmaRefMellemRegning;
	}

	@Override
	public void setSigmaRefMellemregning() {
		this.sigmaRefMellemRegning =  sigmaRefMellemRegning;
	}

	@Override
	public void angivNormalspaending(Normalspaending sigmaN) throws NormalspaendingEjDefineretException {
		if(sigmaN != null)
			this.sigmaN = sigmaN;
		else
			throw new NormalspaendingEjDefineretException();
	}
	
	@Override
	public void angivBoejningsspaending(Boejningsspaending sigmaB) throws BoejningsspaendingEjDefineretException {
		if(sigmaB != null)
			this.sigmaB = sigmaB;
		else 
			throw new BoejningsspaendingEjDefineretException();
	}

	@Override
	public void angivForskydsningsspaending(ForskydningsSpaendning tau)	throws ForskydningsspaendingEjDefineretException {
		if(tau != null)
			this.tau = tau;
		else 
			throw new ForskydningsspaendingEjDefineretException();
	}

//	@Override
//	public void setSigmaRefNmm2(double sigmaRefNmm2) {
//		this.sigmaRef = sigmaRefNmm2;
//	}
//	
	
}
