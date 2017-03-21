package logic;

import exceptions.ArealEjDefineretException;
import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.FlydeSpaendingEjDefineretException;
import exceptions.NegativKgException;
import exceptions.ForskydningsspaendingEjDefineretException;
import exceptions.NegativArealException;
import exceptions.NormalkraftEjDefineretException;
import exceptions.ReferenceSpaendingEjDefineretException;
import exceptions.NormalspaendingEjDefineretException;
import exceptions.TvaerkraftEjDefineretException;
import exceptions.VinkelEjDefineretException;
import exceptions.erUnderFejlgraenseException;

public interface PTECalculatorController {

	public void beregnNormalkraft() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException;

	public double getNormalkraft() throws NormalkraftEjDefineretException, DimensionerendeKraftEjDefineretException,
			VinkelEjDefineretException;

	String getNormalkraftMellemregning() throws NormalkraftEjDefineretException,
			DimensionerendeKraftEjDefineretException, VinkelEjDefineretException;

	public void angivVaegt(double vaerdi, Enhed enhed) throws DimensionerendeKraftEjDefineretException;

	public void notifyObservers();

	public double getVinkel() throws VinkelEjDefineretException;

	public void angivVinkel(double vinkel, boolean maaltTilLodret)
			throws erUnderFejlgraenseException, DimensionerendeKraftEjDefineretException;

	public void beregnTvaerkraft() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException;

	public String getTvaerkraftMellemregning()
			throws TvaerkraftEjDefineretException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException;

	public double getTvaerkraft()
			throws TvaerkraftEjDefineretException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException;

	public void tilmeldObserver(PTEObserver observer);

	public double getDimensionerendekraft() throws DimensionerendeKraftEjDefineretException;

	public String getDimensionerendekraftMellemregning() throws DimensionerendeKraftEjDefineretException;

	public void beregnForskydningsspaendning()
			throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException,
			ForskydningsspaendingEjDefineretException, ArealEjDefineretException, TvaerkraftEjDefineretException;

	public void beregnNormalspaending() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, NormalspaendingEjDefineretException, NormalkraftEjDefineretException, ArealEjDefineretException;

	public void setFtNewton(double ftNewton)
			throws TvaerkraftEjDefineretException, DimensionerendeKraftEjDefineretException;

	public void setFnNewton(double fnNewton) throws DimensionerendeKraftEjDefineretException;
	
	public void beregnSikkerhedsFaktor() throws ReferenceSpaendingEjDefineretException, FlydeSpaendingEjDefineretException;

	public void angivAreal(double mm2) throws NegativArealException;

	public double getAreal() throws ArealEjDefineretException;

	public String getForskydningsspaendingMellemregning() throws ForskydningsspaendingEjDefineretException;

	public double getForskydningsspaending()
			throws ForskydningsspaendingEjDefineretException, ArealEjDefineretException, TvaerkraftEjDefineretException,
			DimensionerendeKraftEjDefineretException, VinkelEjDefineretException;

	public void setForskydningsspaending(double nMm2);

	public boolean erVaegtNormal() throws NegativKgException;

	void setNormalspaending(double sigmaNmm2);

	double getNormalspaending() throws NormalspaendingEjDefineretException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException;

	String getNormalspaendingMellemregning() throws NormalspaendingEjDefineretException;

}
