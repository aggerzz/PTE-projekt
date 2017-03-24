package logic;

import exceptions.ArealEjDefineretException;
import exceptions.BoejningsspaendingEjDefineretException;
import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.FlydeSpaendingEjDefineretException;
import exceptions.ForskydningsspaendingEjDefineretException;
import exceptions.HalvProfilhoejdeEjDefineretException;
import exceptions.InertimomentEjDefineretException;
import exceptions.LaengdeEjDefineretException;
import exceptions.NormalspaendingEjDefineretException;
import exceptions.ReferenceSpaendingEjDefineretException;
import exceptions.TvaerkraftEjDefineretException;
import exceptions.VinkelEjDefineretException;

public class SikkerhedsFaktorImpl implements SikkerhedsFaktor {
	Referencespaending sigmaRef;
	FlydeSpaending sigmaTill;
	double sikkerhedsFaktor;
	String sikkerhedsFaktorMellemRegning;
	
	public void angivReferencespaending(Referencespaending sigmaRef) throws ReferenceSpaendingEjDefineretException {
		if(sigmaRef !=null)
			this.sigmaRef = sigmaRef;
		else
			throw new ReferenceSpaendingEjDefineretException();
	}
	
	public void angivFlydeSpaending(FlydeSpaending sigmaTill) throws FlydeSpaendingEjDefineretException{
		if(sigmaTill !=null)
			this.sigmaTill = sigmaTill;
		else
			throw new FlydeSpaendingEjDefineretException();
	}
	public void beregnSikkerhedsFaktor() throws ReferenceSpaendingEjDefineretException, FlydeSpaendingEjDefineretException, InertimomentEjDefineretException, HalvProfilhoejdeEjDefineretException, LaengdeEjDefineretException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, NormalspaendingEjDefineretException, ArealEjDefineretException, BoejningsspaendingEjDefineretException, ForskydningsspaendingEjDefineretException, TvaerkraftEjDefineretException {
		sikkerhedsFaktor = sigmaTill.getFlydeSpaending()/sigmaRef.getSigmaRef();
		sikkerhedsFaktorMellemRegning = "SF = sigmaTill / sigmaRef \n"
				+ getSikkerhedsFaktor() + " = " + sigmaTill.getFlydeSpaending() + " / " + sigmaRef.getSigmaRef() ;
		
	}
	public String getSikkerhedsFaktorMellemRegning(){
		return sikkerhedsFaktorMellemRegning;
	}
	public double getSikkerhedsFaktor() throws FlydeSpaendingEjDefineretException, ReferenceSpaendingEjDefineretException, InertimomentEjDefineretException, HalvProfilhoejdeEjDefineretException, LaengdeEjDefineretException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, NormalspaendingEjDefineretException, ArealEjDefineretException, BoejningsspaendingEjDefineretException, ForskydningsspaendingEjDefineretException, TvaerkraftEjDefineretException{
		if(sigmaTill == null)
			throw new FlydeSpaendingEjDefineretException();
		if(sigmaRef == null)
			throw new ReferenceSpaendingEjDefineretException();
		return sigmaTill.getFlydeSpaending()/sigmaRef.getSigmaRef();
	}

}
