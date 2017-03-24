package logic;

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

public interface Referencespaending {
	
	public double getSigmaRef() throws InertimomentEjDefineretException, HalvProfilhoejdeEjDefineretException, LaengdeEjDefineretException, ReferenceSpaendingEjDefineretException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, NormalspaendingEjDefineretException, ArealEjDefineretException, BoejningsspaendingEjDefineretException, ForskydningsspaendingEjDefineretException, TvaerkraftEjDefineretException;
	
	public String getSigmaRefMellemregning();
	
	public void setSigmaRefMellemregning();
	
	public void angivNormalspaending(Normalspaending sigmaN) throws NormalspaendingEjDefineretException;
	
	public void angivBoejningsspaending(Boejningsspaending sigmaB) throws BoejningsspaendingEjDefineretException;
	
	public void angivForskydsningsspaending(ForskydningsSpaendning tau) throws ForskydningsspaendingEjDefineretException;
	
//	public void setSigmaRefNmm2(double sigmaRefNmm2);

}

