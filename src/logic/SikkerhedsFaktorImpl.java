package logic;

public class SikkerhedsFaktorImpl implements SikkerhedsFaktor {
	ReferenceSpaending sigmaRef;
	FlydeSpaending sigmaTill;
	double sikkerhedsFaktor;
	String sikkerhedsFaktorMellemRegning;
	SikkerhedsFaktor SF;
	
	public void angivReferenceSpaending(ReferenceSpaending sigmaRef){
		this.sigmaRef = sigmaRef;
	}
	public void angivFlydeSpaending(FlydeSpaending sigmaTill){
		this.sigmaTill = sigmaTill;
	}
	public void beregnSikkerhedsFaktor(){
		SF = sigmaTill/sigmaRef;
		sikkerhedsFaktorMellemRegning = "SF = sigmaTill / sigmaRef \n"
				+ SF + " = " + sigmaTill.getFlydeSpaending() + " / " + sigmaRef.getSigmaRef() ;
		
	}
	public String getSikkerhedsFaktorMellemRegning(){
		return sikkerhedsFaktorMellemRegning;
	}
	public double getSikkerhedsFaktor(){
		return sigmaTill/sigmaRef;
	}
	
}
