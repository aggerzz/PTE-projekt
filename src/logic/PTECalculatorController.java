package logic;

public interface PTECalculatorController {

	public void beregnNormalkraft() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException;

	public double getNormalkraft() throws NormalkraftEjDefineretException, DimensionerendeKraftEjDefineretException,
			VinkelEjDefineretException;

	String getNormalkraftBeregninger() throws NormalkraftEjDefineretException, DimensionerendeKraftEjDefineretException,
			VinkelEjDefineretException;
	
	public void angivVaegt(double Kg) throws DimensionerendeKraftEjDefineretException;
	
	public void notifyObservers();

}
