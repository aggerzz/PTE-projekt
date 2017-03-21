package logic;

public class SikkerhedsFaktorImpl implements SikkerhedsFaktor {
	Referencespaending sigmaRef;
	FlydeSpaending sigmaTill;
	double sikkerhedsFaktor;
	String sikkerhedsFaktorMellemRegning;
	
	public void angivReferencespaending(Referencespaending sigmaRef){
		this.sigmaRef = sigmaRef;
	}
	public void angivFlydeSpaending(FlydeSpaending sigmaTill){
		this.sigmaTill = sigmaTill;
	}
	public void beregnSikkerhedsFaktor(){
		sikkerhedsFaktor = sigmaTill.getFlydeSpaending()/sigmaRef.getSigmaRef();
		sikkerhedsFaktorMellemRegning = "SF = sigmaTill / sigmaRef \n"
				+ getSikkerhedsFaktor() + " = " + sigmaTill.getFlydeSpaending() + " / " + sigmaRef.getSigmaRef() ;
		
	}
	public String getSikkerhedsFaktorMellemRegning(){
		return sikkerhedsFaktorMellemRegning;
	}
	public double getSikkerhedsFaktor(){
		return sigmaTill.getFlydeSpaending()/sigmaRef.getSigmaRef();
	}

}
