package logic;

import exceptions.FlydeSpaendingEjDefineretException;
import exceptions.HalvProfilhoejdeEjDefineretException;
import exceptions.InertimomentEjDefineretException;
import exceptions.LaengdeEjDefineretException;
import exceptions.ReferenceSpaendingEjDefineretException;

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
	public void beregnSikkerhedsFaktor() throws ReferenceSpaendingEjDefineretException, FlydeSpaendingEjDefineretException, InertimomentEjDefineretException, HalvProfilhoejdeEjDefineretException, LaengdeEjDefineretException {
		sikkerhedsFaktor = sigmaTill.getFlydeSpaending()/sigmaRef.getSigmaRef();
		sikkerhedsFaktorMellemRegning = "SF = sigmaTill / sigmaRef \n"
				+ getSikkerhedsFaktor() + " = " + sigmaTill.getFlydeSpaending() + " / " + sigmaRef.getSigmaRef() ;
		
	}
	public String getSikkerhedsFaktorMellemRegning(){
		return sikkerhedsFaktorMellemRegning;
	}
	public double getSikkerhedsFaktor() throws FlydeSpaendingEjDefineretException, ReferenceSpaendingEjDefineretException, InertimomentEjDefineretException, HalvProfilhoejdeEjDefineretException, LaengdeEjDefineretException{
		if(sigmaTill == null)
			throw new FlydeSpaendingEjDefineretException();
		if(sigmaRef == null)
			throw new ReferenceSpaendingEjDefineretException();
		return sigmaTill.getFlydeSpaending()/sigmaRef.getSigmaRef();
	}

}
