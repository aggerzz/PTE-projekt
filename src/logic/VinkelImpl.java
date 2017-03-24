package logic;

import exceptions.ErOverFejlGraenseException;
import exceptions.VinkelEjDefineretException;
import exceptions.erUnderFejlgraenseException;

public class VinkelImpl implements Vinkel {

	private double grader;
	private boolean erMaaltTilLodret;
	private double graderMaaltTilLodret;
	private double graderMaaltTilVandret;
	private String mellemregning;

	@Override
	public double getGrader() throws VinkelEjDefineretException {
		if (Double.isNaN(grader))
			throw new VinkelEjDefineretException();
		return grader;
//		if (getMaaltTilLodret()) {
//			graderMaaltTilLodret = grader;
//			graderMaaltTilVandret = 90 - grader;
//
//			return graderMaaltTilLodret;
//		} else {
//			graderMaaltTilVandret = grader;
//			graderMaaltTilLodret = 90 - grader;
//
//			return graderMaaltTilVandret;
//		}
	}

	@Override
	public boolean getMaaltTilLodret() {
		return erMaaltTilLodret;
	}
	@Override
	public void setMaaltTilLodret(boolean erMaaltTilLodret) {
		this.erMaaltTilLodret = erMaaltTilLodret;
	}

	@Override
	public void setGrader(double grader)throws erUnderFejlgraenseException, ErOverFejlGraenseException{
		if (grader<0 )
			throw new erUnderFejlgraenseException();
//		else if (0<this.grader && this.grader>90) 
		else this.grader = grader;
			
		if(grader>90)
			throw new ErOverFejlGraenseException();
		else this.grader = grader;
	}
}
