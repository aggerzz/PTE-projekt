package logic;

import java.text.DecimalFormat;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.VinkelEjDefineretException;

public class NormalkraftImpl implements Normalkraft {
	
	private Vinkel vinkel = new VinkelImpl();
	private Dimensionerendekraft fdim = new DimensionerendekraftImpl();
	public String mellemRegning;
	private double fnNewton;
	
	DecimalFormat formatter = new DecimalFormat("#0.00000");
	
	@Override
	public void angivDimensionerendekraft(Dimensionerendekraft fdim) throws DimensionerendeKraftEjDefineretException {
		if(fdim!=null) 
			this.fdim = fdim;
		else
			throw new DimensionerendeKraftEjDefineretException();

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
		
		if (erMaaltTilLodret) {
			fnNewton = cos * fdimNewton;
			String fnText = formatter.format(fnNewton);
			String fdimText = formatter.format(fdimNewton);
			//mellemRegning = "cos(vinkel)\t	 *\t	FDim\t	=\t	Fn" + "\n" + "cos( "  + vinkel.getGrader()+")\t		 *\t	"+fdimNewton +"\t	=\t	"+ fnNewton + "\n";
			mellemRegning = "cos(vinkel) * FDim = Fn" + "\n" + "cos(" + vinkel.getGrader()+") * "+fdimText +" = "+ fnText + "\n";
		} else {
			fnNewton = sin * fdimNewton;
			String fnText = formatter.format(fnNewton);
			String fdimText = formatter.format(fdimNewton);
			mellemRegning = "sin(vinkel) * FDim = Fn" + "\n" + "sin(" + vinkel.getGrader()+") * "+fdimText +" = "+ fnText + "\n";
		}
		
		return fnNewton;
	}
	
	public void setFnNewton(double fnNewton){
		this.fnNewton = fnNewton;
	}

	@Override //TODO Det ser ud til metoden er f�rdig (SA)
	public String getMellemregning() {
		return mellemRegning;
	}

}
