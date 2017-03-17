package logic;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.VinkelEjDefineretException;

public class NormalkraftImpl implements Normalkraft {
	
	private Vinkel vinkel = new VinkelImpl();
	private Dimensionerendekraft fdim = new DimensionerendekraftImpl();
	public String mellemRegning;
	private double fnNewton;
	
	@Override
	public void angivDimensionerendekraft(Dimensionerendekraft fdim) throws DimensionerendeKraftEjDefineretException {
		if(fdim==null) 
			throw new DimensionerendeKraftEjDefineretException();
		this.fdim = fdim;
	}
	@Override
	public void angivVinkel(Vinkel vinkel) throws VinkelEjDefineretException {
		if(vinkel==null) 
			throw new VinkelEjDefineretException();
		this.vinkel = vinkel;
	}

	public double getNewton() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
		double grader = vinkel.getGrader();
		boolean erMaaltTilLodret = vinkel.getMaaltTilLodret();
		double fdimNewton = fdim.getNewton();
		double fnNewton = 0;
		double sin = Math.sin(Math.toRadians(grader));
		double cos = Math.cos(Math.toRadians(grader));
		
		if (erMaaltTilLodret==false) {
			fnNewton = sin * fdimNewton;
			mellemRegning = "Fn = sin("+vinkel.getGrader()+") * "+fdimNewton;
		} else {
			fnNewton = cos * fdimNewton;
			mellemRegning = "Fn = cos("+vinkel.getGrader()+") * "+fdimNewton;
		}
		
		return fnNewton;
	}
	
	public void setFnNewton(double fnNewton){
		this.fnNewton = fnNewton;
	}

	@Override //TO DO
	public String getMellemregning() {
		return mellemRegning;
	}

}
