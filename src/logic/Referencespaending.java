package logic;

import exceptions.ForskydningsspaendingEjDefineretException;
import exceptions.HalvProfilhoejdeEjDefineretException;
import exceptions.InertimomentEjDefineretException;
import exceptions.LaengdeEjDefineretException;
import exceptions.NormalspaendingEjDefineretException;
import exceptions.angivBoejningsspaendingEjDefineretException;

public interface Referencespaending {
	
	public double getSigmaRef() throws InertimomentEjDefineretException, HalvProfilhoejdeEjDefineretException, LaengdeEjDefineretException;
	
	public String GetMellemRegning();
	
	public void angivNormalspaending(Normalspaending sigmaN) throws NormalspaendingEjDefineretException;
	
	public void angivBoejningsspaending(Boejningsspaending sigmaB) throws angivBoejningsspaendingEjDefineretException;
	
	public void angivForskydsningsspaending(ForskydningsSpaendning tau) throws ForskydningsspaendingEjDefineretException;
	
	public void setSigmaRefNmm2(double sigmaRefNmm2);

}

