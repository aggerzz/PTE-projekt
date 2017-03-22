package logic;

import java.io.IOException;

import com.itextpdf.text.DocumentException;

import exceptions.ArealEjDefineretException;
import exceptions.BoejningsMomentEjDefineretException;
import exceptions.BoejningsspaendingEjDefineretException;
import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.ErOverFejlGraenseException;
import exceptions.FlydeSpaendingEjDefineretException;
import exceptions.ForskydningsspaendingEjDefineretException;
import exceptions.HalvProfilhoejdeEjDefineretException;
import exceptions.InertimomentEjDefineretException;
import exceptions.LaengdeEjDefineretException;
import exceptions.NegativArealException;
import exceptions.NegativKgException;
import exceptions.NormalkraftEjDefineretException;
import exceptions.NormalspaendingEjDefineretException;
import exceptions.ReferenceSpaendingEjDefineretException;
import exceptions.SikkerhedsFaktorEjDefineretException;
import exceptions.TvaerkraftEjDefineretException;
import exceptions.VinkelEjDefineretException;
import exceptions.angivBoejningsspaendingEjDefineretException;
import exceptions.erUnderFejlgraenseException;

public class PTECalculatorControllerImpl implements PTECalculatorController {

	private Dimensionerendekraft fdim;
	private Tvaerkraft ft;
	private Vinkel vinkel;
	private Normalkraft fn;
	private ForskydningsSpaendning tau;
	private PTEObserver observer;
	private Normalspaending sigmaN;
	private FlydeSpaending sigmaTill;
	private Referencespaending sigmaRef;
	private Areal a;
	private SikkerhedsFaktor sf;
	private Laengde l2;
	private BoejningsMoment boejning;
	private Inertimoment i;
	private HalvProfilhoejde e;
	private Boejningsspaending sigmaB;
	
	public void exportToPdf(){
		try {
			new PdfExporter().exportToPdf();
		} catch (DocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public double getBoejningsMoment() throws BoejningsMomentEjDefineretException, LaengdeEjDefineretException, DimensionerendeKraftEjDefineretException{
		try {
			return boejning.getBoejningsMoment();
		} catch (LaengdeEjDefineretException e) {
			throw new LaengdeEjDefineretException();
		}catch(DimensionerendeKraftEjDefineretException e){
			throw new DimensionerendeKraftEjDefineretException();
		}
		
	}
	
	@Override
	public void beregnSikkerhedsFaktor() throws ReferenceSpaendingEjDefineretException, FlydeSpaendingEjDefineretException{
		sf = new SikkerhedsFaktorImpl();
		if(sigmaTill == null){
			throw new FlydeSpaendingEjDefineretException();
		}
		if(sigmaRef == null){
			throw new ReferenceSpaendingEjDefineretException();
		}
		
		sf.angivFlydeSpaending(sigmaTill);
		sf.angivReferencespaending(sigmaRef);
		notifyObservers();
		
	}
	@Override
	public void beregnBoejningsMoment() throws DimensionerendeKraftEjDefineretException, LaengdeEjDefineretException {
		if(fdim==null){
			throw new DimensionerendeKraftEjDefineretException();
		}
		if(l2 != null){
			l2 = new LaengdeImpl();
		}
		else{
			throw new LaengdeEjDefineretException();
		}
		boejning = new BoejningsMomentImpl();
		boejning.angivDimensionerendeKraft(fdim);
		boejning.angivLaengde(l2);
		
		notifyObservers();
	}

	@Override
	public void beregnNormalkraft() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {

		if (fdim == null) {
			throw new DimensionerendeKraftEjDefineretException();
		}

		if (vinkel == null) {
			throw new VinkelEjDefineretException();
		}

		fn = new NormalkraftImpl();

		fn.angivDimensionerendekraft(fdim);

		fn.angivVinkel(vinkel);

		notifyObservers();

	}

	@Override
	public double getNormalkraft() throws NormalkraftEjDefineretException, DimensionerendeKraftEjDefineretException,
			VinkelEjDefineretException {

		if (fn == null) {
			throw new NormalkraftEjDefineretException();
		}

		double fnNewton = fn.getNewton();

		return fnNewton;

	}

	@Override
	public String getNormalkraftMellemregning() throws NormalkraftEjDefineretException,
			DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {

		if (fn == null) {
			throw new NormalkraftEjDefineretException();

		}

		String normalkraftMellemregning = fn.getMellemregning();
		return normalkraftMellemregning;

	}	

	@Override
	public void angivVaegt(double vaegt, Enhed enhed) throws DimensionerendeKraftEjDefineretException, erUnderFejlgraenseException {
		fdim = new DimensionerendekraftImpl();

		fdim.setVaegt(vaegt,enhed);
		if(!fdim.erVaegtNormal())
			throw new erUnderFejlgraenseException();
		notifyObservers();
	}
	
	@Override
	public double getAreal() throws ArealEjDefineretException{
		if(a == null){
			throw new ArealEjDefineretException();
		}
		return a.getMm2();
	}
	
	@Override
	public void angivAreal(double mm2) throws NegativArealException {
		if (this.a == null) {
			this.a = new ArealImpl();
		}
		this.a.setMm2(mm2);

		notifyObservers();
	}		

	@Override
	public void notifyObservers() {

		if (observer != null) {
			observer.update();
		}

	}

	@Override
	public double getVinkel() throws VinkelEjDefineretException {
		if (vinkel == null)
			throw new VinkelEjDefineretException();
		return vinkel.getGrader();
	}

	@Override
	public void beregnTvaerkraft() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
		if (fdim == null) {
			throw new DimensionerendeKraftEjDefineretException();
		}

		if (vinkel == null) {
			throw new VinkelEjDefineretException();
		}

		ft = new TvaerkraftImpl();

		ft.angivDimensionerendekraft(fdim);

		ft.angivVinkel(vinkel);

		notifyObservers();

	}

	@Override
	public String getTvaerkraftMellemregning() throws TvaerkraftEjDefineretException,
			DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {

		if (ft == null) {
			throw new TvaerkraftEjDefineretException();

		}

		String tvaerkraftMellemregning = ft.getMellemregning();

		return tvaerkraftMellemregning;

	}

	@Override
	public double getTvaerkraft() throws TvaerkraftEjDefineretException, DimensionerendeKraftEjDefineretException,
			VinkelEjDefineretException {

		if (ft == null) {
			throw new TvaerkraftEjDefineretException();

		}

		double ftNewton = ft.getNewton();

		return ftNewton;
	}

	@Override
	public void angivVinkel(double vinkel, boolean MaaltTilLodret) throws erUnderFejlgraenseException, DimensionerendeKraftEjDefineretException {
		if(this.vinkel == null){
			this.vinkel = new VinkelImpl();
		}
		
		try {
			this.vinkel.setGrader(vinkel);
		} catch (ErOverFejlGraenseException e) {
			e.printStackTrace();
		}
		this.vinkel.setMaaltTilLodret(MaaltTilLodret);
		
//		try {
//			beregnTvaerkraft();
//		} catch (DimensionerendeKraftEjDefineretException | VinkelEjDefineretException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			beregnNormalkraft();
//		} catch (DimensionerendeKraftEjDefineretException | VinkelEjDefineretException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		notifyObservers();
	}

	@Override
	public void tilmeldObserver(PTEObserver observer) {
		this.observer = observer;
		
	}
	@Override
	public double getDimensionerendekraft() throws DimensionerendeKraftEjDefineretException {
		if(fdim == null)
			throw new DimensionerendeKraftEjDefineretException();
		return fdim.getNewton();
	}

	@Override
	public String getDimensionerendekraftMellemregning() throws DimensionerendeKraftEjDefineretException {
		if(fdim == null)
			throw new DimensionerendeKraftEjDefineretException();
		return fdim.getMellemRegning();
	}
	
	@Override
	public void setFtNewton(double ftNewton) throws TvaerkraftEjDefineretException, DimensionerendeKraftEjDefineretException{
		ft = new TvaerkraftImpl();

		ft.setFtNewton(ftNewton);

		notifyObservers();
	}
	
	@Override
	public void setFnNewton(double fnNewton) throws DimensionerendeKraftEjDefineretException {
		fn = new NormalkraftImpl();
		fn.setFnNewton(fnNewton);
		
		notifyObservers();
	}

	@Override
	public boolean erVaegtNormal() throws NegativKgException {
		fdim = new DimensionerendekraftImpl();
		
		return false;
	}
	
	@Override
	public void beregnForskydningsspaendning() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, ForskydningsspaendingEjDefineretException, ArealEjDefineretException, TvaerkraftEjDefineretException {
		
		if (ft == null) {
			throw new TvaerkraftEjDefineretException();
		}

		if (a == null) {
			throw new ArealEjDefineretException();
		}	
		tau = new ForskydningsSpaendningImpl();				
		tau.angivTvaerkraft(ft);
		tau.angivAreal(a);
		
		notifyObservers();			
	}
	
	
	@Override
	public double getForskydningsspaending() throws ForskydningsspaendingEjDefineretException, ArealEjDefineretException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, TvaerkraftEjDefineretException {

		if (tau == null) {			
			throw new ForskydningsspaendingEjDefineretException();

		}		
		double tauMm2 = tau.getNmm2();
		
		return tauMm2;		
	}
	
	@Override
	public String getForskydningsspaendingMellemregning() throws ForskydningsspaendingEjDefineretException  {

		if (tau == null) {
			throw new ForskydningsspaendingEjDefineretException();

		}

		String forskydningsspaendingMellemregning = tau.getMellemregning();

		return forskydningsspaendingMellemregning;

	}
	
	@Override
	public void setForskydningsspaending (double nMm2) {
		tau = new ForskydningsSpaendningImpl();
		tau.setNmm2(nMm2);
		
		notifyObservers();
	}
	
	@Override
	public void beregnNormalspaending() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, NormalspaendingEjDefineretException, NormalkraftEjDefineretException, ArealEjDefineretException  {
		if(fn == null){
			throw new NormalkraftEjDefineretException();
		}
		if(a == null){
			throw new ArealEjDefineretException();
		}
		sigmaN = new NormalspaendingImpl();
		sigmaN.angivNormalkraft(fn);
		try {
			sigmaN.angivAreal(a);
		} catch (NegativArealException e) {
			e.printStackTrace();
		}
		
		notifyObservers();		
	}
	
	@Override
	public void setNormalspaending(double sigmaNmm2){
		sigmaN = new NormalspaendingImpl();
		sigmaN.setSigmaNmm2(sigmaNmm2);
		
		notifyObservers();
	}
	
	@Override
	public double getNormalspaending() throws NormalspaendingEjDefineretException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {

		if (sigmaN == null) {			
			throw new NormalspaendingEjDefineretException();

		}		
		double sigmaNmm2 = sigmaN.getSigmaNmm2();
		
		return sigmaNmm2;		
	}
	
	@Override
	public String getNormalspaendingMellemregning() throws NormalspaendingEjDefineretException {

		if (sigmaN == null) {
			throw new NormalspaendingEjDefineretException();
		}

		String normalspaendingMellemregning = sigmaN.getMellemregning();
		return normalspaendingMellemregning;
	}


	@Override
	public void beregnSigmaRef() throws NormalspaendingEjDefineretException,
			angivBoejningsspaendingEjDefineretException, ForskydningsspaendingEjDefineretException {
		if (sigmaN == null) {
			throw new NormalspaendingEjDefineretException();
		}
		if (sigmaB == null) {//TODO sigmaB ikke implamenteret (SA)
			throw new angivBoejningsspaendingEjDefineretException();
		}
		if(tau == null){
			throw new ForskydningsspaendingEjDefineretException();
		}

		sigmaRef = new ReferencespaendingImpl();

		sigmaRef.angivBoejningsspaending(sigmaB);

		sigmaRef.angivForskydsningsspaending(tau);
		
		sigmaRef.angivNormalspaending(sigmaN);
		
		notifyObservers();
	}


	@Override
	public double getSigmaRef() throws ReferenceSpaendingEjDefineretException {
		if (sigmaRef == null) {
			throw new ReferenceSpaendingEjDefineretException();
		}

		double sigmaRefNmm2 = sigmaRef.getSigmaRef();

		return sigmaRefNmm2;

	}


	@Override
	public String ReferenceSpaendingGetMellemRegning() throws ReferenceSpaendingEjDefineretException {
		if (sigmaRef == null) {
			throw new ReferenceSpaendingEjDefineretException();

		}

		String referenceSpaendingMellemregning = sigmaRef.GetMellemRegning();

		return referenceSpaendingMellemregning;

	}
	@Override
	public void setReferenceSpaending(double sigmaRefNmm2){
		sigmaRef = new ReferencespaendingImpl();
		sigmaRef.setSigmaRefNmm2(sigmaRefNmm2);
		
		notifyObservers();
	}

	@Override
	public double getSikkerhedsfaktor() throws SikkerhedsFaktorEjDefineretException  {
		if(sf == null)
			throw new SikkerhedsFaktorEjDefineretException();
		double sfvaerdi = sf.getSikkerhedsFaktor();
		return sfvaerdi;
	}

	@Override
	public String getSikkerhedsfaktorMellemregning() throws SikkerhedsFaktorEjDefineretException, ReferenceSpaendingEjDefineretException, FlydeSpaendingEjDefineretException {
		if(sf == null)
			throw new SikkerhedsFaktorEjDefineretException();
		
		String sfMellemregning = sf.getSikkerhedsFaktorMellemRegning();
		return sfMellemregning;
	}
	
	@Override
	public void beregnBoejningsSpaending()
			throws BoejningsMomentEjDefineretException, BoejningsspaendingEjDefineretException,
			HalvProfilhoejdeEjDefineretException, InertimomentEjDefineretException {
		if (i == null) {
			throw new InertimomentEjDefineretException();
		}
		if (e == null) {
			throw new HalvProfilhoejdeEjDefineretException();
		}
		if (boejning == null) {
			throw new BoejningsMomentEjDefineretException();
		}

		sigmaB = new BoejningsspaendingImpl();
		sigmaB.angivBoejningsmoment(boejning);
		sigmaB.angivInertimoment(i);
		sigmaB.angivHalvProfilhoejde(e);

		notifyObservers();

	}

	@Override
	public double getBoejningsspaending() throws BoejningsspaendingEjDefineretException {
		if (sigmaB == null)
			throw new BoejningsspaendingEjDefineretException();
		
		double sigmaBNmm2 = sigmaB.getBoejningsspaending();
	
		
		return sigmaBNmm2;
	}

	@Override
	public String getBoejningsspaendingMellemregning() throws BoejningsspaendingEjDefineretException {
		if (sigmaB == null)
			throw new BoejningsspaendingEjDefineretException();
		
		String sigmaBMellemregning = sigmaB.getBoejningsspaendingMellemregning();
		return sigmaBMellemregning;
	}
	public void angivLaengde(Laengde l2) throws LaengdeEjDefineretException{
		
		if(l2!=null){
			this.l2=l2;
		}
		else{
			throw new LaengdeEjDefineretException();
		}
	}

}


		

