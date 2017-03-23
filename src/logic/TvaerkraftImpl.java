package logic;

import java.text.DecimalFormat;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.VinkelEjDefineretException;

public class TvaerkraftImpl implements Tvaerkraft {
	private Vinkel vinkel = new VinkelImpl();
	private Dimensionerendekraft fdim = new DimensionerendekraftImpl();
	private String mellemregning = null;
	private double ftNewton = 0;
	
	DecimalFormat formatter = new DecimalFormat("#0.00000");
	
	@Override
	public String getMellemregning() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
		return mellemregning;
	}
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

	@Override
	public double getNewton() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
		double grader = vinkel.getGrader();
		boolean erMaaltTilLodret = vinkel.getMaaltTilLodret();
		double fdimNewton = fdim.getNewton();

		//double ftNewton = 0;
		double sinV = Math.sin(Math.toRadians(grader));
		double cosV = Math.cos(Math.toRadians(grader));
		if (erMaaltTilLodret==false) {
			ftNewton = cosV * fdimNewton;
			String newtonText = formatter.format(ftNewton);
			String fdimText = formatter.format(fdimNewton);
		//	mellemregning = "FT = cos(vinkel) * FDim" + "\n" + ftNewton + " = cos(" + grader + ") * " + fdimNewton + "\n"; 
		//	mellemregning = "FT\t	 =\t	 cos(vinkel)\t	 *	 FDim" + "\n" + ftNewton +"\t	"+" = cos(" + grader + ")\t	 * 	" + fdimNewton + "\n";
			//mellemregning = "cos(vinkel)\t	 *\t	FDim\t	=\t	FT	" + "\n" + "  cos(" + grader + ")\t	 *\t	" + fdimNewton + "\t	=\t" + ftNewton + "\n" ; 
			mellemregning = "cos(vinkel) * FDim = FT" + "\n" + "cos(" + grader + ") * " + fdimText + " = " + newtonText + "\n" ; 
		}
		
		else {
			ftNewton = sinV * fdimNewton;
			String newtonText = formatter.format(ftNewton);
			String fdimText = formatter.format(fdimNewton);
		//	mellemregning = "FT = sin(vinkel) * FDim" + "\n" + ftNewton + " = sin(" + grader + ") * " + fdimNewton + "\n";
			// mellemregning = "sin(vinkel) * FDim" +"= FT" + "\n" + ftNewton + " = sin(" + grader + ") * " + fdimNewton + "\n"; 
			mellemregning = "sin(vinkel) * FDim" +" = FT" + "\n" + newtonText + " = sin(" + grader + ") * " + fdimText + "\n"; 

		}
		
		return ftNewton;
	}
	public void setFtNewton(double ftNewton) {
		this.ftNewton = ftNewton;
	}

}
