package logic;

public interface Normalkraft {
 
	public void angivDimensionerendekraft(Dimensionerendekraft fdim) throws DimensionerendeKraftEjDefineretException;
	
	public void angivVinkel(Vinkel vinkel) throws VinkelEjDefineretException;
	
	public double getNewton() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException;

	public String getBeregning() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException;
}
