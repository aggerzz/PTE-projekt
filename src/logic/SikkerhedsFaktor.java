package logic;

public interface SikkerhedsFaktor {
	public void angivReferencespaending(Referencespaending sigmaRef);
	public void angivFlydeSpaending(FlydeSpaending sigmaTill);
	public void beregnSikkerhedsFaktor();
	public double getSikkerhedsFaktor();
}
