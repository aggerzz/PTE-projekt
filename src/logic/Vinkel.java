package logic;

import exceptions.ErOverFejlGraenseException;
import exceptions.VinkelEjDefineretException;
import exceptions.erUnderFejlgraenseException;

public interface Vinkel {
	public double getGrader() throws VinkelEjDefineretException;

	public void setGrader(double grader) throws erUnderFejlgraenseException, ErOverFejlGraenseException;

	public boolean getMaaltTilLodret();

	public void setMaaltTilLodret(boolean erMaaltTilLodret);

}
