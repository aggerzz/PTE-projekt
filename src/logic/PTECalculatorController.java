package logic;

import exceptions.ArealEjDefineretException;
import exceptions.BoejningsMomentEjDefineretException;
import exceptions.BoejningsspaendingEjDefineretException;
import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.FlydeSpaendingEjDefineretException;
import exceptions.ForskydningsspaendingEjDefineretException;
import exceptions.HalvProfilhoejdeEjDefineretException;
import exceptions.InertimomentEjDefineretException;
import exceptions.LaengdeEjDefineretException;
import exceptions.NegativArealException;
import exceptions.NegativHalvProfilhoejdeException;
import exceptions.NegativInertimomentException;
import exceptions.NegativKgException;
import exceptions.NormalkraftEjDefineretException;
import exceptions.NormalspaendingEjDefineretException;
import exceptions.ReferenceSpaendingEjDefineretException;
import exceptions.SikkerhedsFaktorEjDefineretException;
import exceptions.TvaerkraftEjDefineretException;
import exceptions.VinkelEjDefineretException;
import exceptions.angivBoejningsspaendingEjDefineretException;
import exceptions.erUnderFejlgraenseException;

public interface PTECalculatorController {

	public void beregnNormalkraft() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException;

	public double getNormalkraft() throws NormalkraftEjDefineretException, DimensionerendeKraftEjDefineretException,
			VinkelEjDefineretException;

	String getNormalkraftMellemregning() throws NormalkraftEjDefineretException,
			DimensionerendeKraftEjDefineretException, VinkelEjDefineretException;

	public void angivVaegt(double vaerdi, Enhed enhed) throws NegativKgException;

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

	public boolean erVaegtNormal() throws DimensionerendeKraftEjDefineretException;

	void setNormalspaending(double sigmaNmm2);

	double getNormalspaending() throws NormalspaendingEjDefineretException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException;

	String getNormalspaendingMellemregning() throws NormalspaendingEjDefineretException;
	
	public void beregnSigmaRef() throws NormalspaendingEjDefineretException, angivBoejningsspaendingEjDefineretException, ForskydningsspaendingEjDefineretException;
	public double getSigmaRef() throws ReferenceSpaendingEjDefineretException;
	public String ReferenceSpaendingGetMellemRegning() throws ReferenceSpaendingEjDefineretException;
	public void setReferenceSpaending(double sigmaRefNmm2);
	public void beregnBoejningsMoment() throws DimensionerendeKraftEjDefineretException, LaengdeEjDefineretException;
	public double getBoejningsMoment() throws BoejningsMomentEjDefineretException,DimensionerendeKraftEjDefineretException,LaengdeEjDefineretException;
	public void exportToPdf();
	
	public double getSikkerhedsfaktor()throws SikkerhedsFaktorEjDefineretException ;
	
	public String getSikkerhedsfaktorMellemregning() throws SikkerhedsFaktorEjDefineretException, ReferenceSpaendingEjDefineretException, FlydeSpaendingEjDefineretException;
	
	public void beregnBoejningsSpaending() throws BoejningsMomentEjDefineretException, BoejningsspaendingEjDefineretException, HalvProfilhoejdeEjDefineretException, InertimomentEjDefineretException;
	public double getBoejningsspaending() throws BoejningsspaendingEjDefineretException;
	public String getBoejningsspaendingMellemregning() throws BoejningsspaendingEjDefineretException;
	public void angivLaengde(double l2) throws LaengdeEjDefineretException;
	public double getLaengde() throws LaengdeEjDefineretException;
	public void angivFlydespaending(double flyde) throws FlydeSpaendingEjDefineretException;
	public double getFlydeSpaending() throws FlydeSpaendingEjDefineretException;
	public String getBoejningsMomentMellemRegning() throws BoejningsMomentEjDefineretException;
	public void angivIntertimoment(double i) throws InertimomentEjDefineretException, NegativInertimomentException;
	public double getInertimoment() throws InertimomentEjDefineretException;
	public void angivHalvProfilhoejde(double e) throws HalvProfilhoejdeEjDefineretException, NegativHalvProfilhoejdeException;
	public double getHalvProfilhoejde() throws HalvProfilhoejdeEjDefineretException;
}
