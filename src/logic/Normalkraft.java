package logic;

public interface Normalkraft {
 
	public void angivDimensionerendekraft(Dimensionerendekraft fdim) throws DimensionerendekraftEjDefineretException;
	
	public void angivVinkel(Vinkel vinkel) throws VinkelEjDefineretException;
	
	public void getNewton() throws NormalkraftEjDefineretException,DimensionerendekraftEjDefineretException, VinkelEjDefineretException;
}
