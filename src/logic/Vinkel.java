package logic;

import exceptions.ErOverFejlGraenseException;
import exceptions.erUnderFejlgraenseException;

public interface Vinkel {
	public double getGrader();

	public void setGrader(double grader) throws erUnderFejlgraenseException, ErOverFejlGraenseException;

	public boolean getMaaltTilLodret();

	public void setMaaltTilLodret(boolean erMaaltTilLodret);

}
