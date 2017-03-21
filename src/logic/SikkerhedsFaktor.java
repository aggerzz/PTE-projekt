package logic;

import exceptions.FlydeSpaendingEjDefineretException;
import exceptions.ReferenceSpaendingEjDefineretException;
import exceptions.SikkerhedsFaktorEjDefineretException;

public interface SikkerhedsFaktor {
	public void angivReferencespaending(Referencespaending sigmaRef) throws ReferenceSpaendingEjDefineretException;
	public void angivFlydeSpaending(FlydeSpaending sigmaTill) throws FlydeSpaendingEjDefineretException;
	public void beregnSikkerhedsFaktor() throws FlydeSpaendingEjDefineretException, ReferenceSpaendingEjDefineretException;
	public String getSikkerhedsFaktorMellemRegning() throws ReferenceSpaendingEjDefineretException, FlydeSpaendingEjDefineretException;
	public double getSikkerhedsFaktor() throws SikkerhedsFaktorEjDefineretException;
}
