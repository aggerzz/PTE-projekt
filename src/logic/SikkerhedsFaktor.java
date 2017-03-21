package logic;

public interface SikkerhedsFaktor {
	public void angivReferenceSpaending(ReferenceSpaending sigmaRef);
	public void angivFlydeSpaending(FlydeSpaending sigmaTill);
	public void beregnSikkerhedsFaktor();
	public double getSikkerhedsFaktor();
}
