package logic;

import exceptions.ArealEjDefineretException;
import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.NegativKgException;
import exceptions.ForskydningsspaendingEjDefineretException;
import exceptions.NegativArealException;
import exceptions.NormalkraftEjDefineretException;
import exceptions.TvaerkraftEjDefineretException;
import exceptions.VinkelEjDefineretException;
import exceptions.erUnderFejlgraenseException;

public class PTECalculatorControllerImpl implements PTECalculatorController {

	private Dimensionerendekraft fdim;
	private Tvaerkraft ft;
	private Vinkel vinkel;
	private Normalkraft fn;
	private ForskydningsSpaendning tau;
	private PTEObserver observer;
	private Normalspaending sigmaN;
	private Areal a;

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
	public void angivVaegt(double kg) throws DimensionerendeKraftEjDefineretException {
		fdim = new DimensionerendekraftImpl();

		fdim.setKg(kg);

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
	public double beregnNormalspaending() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException{
		return sigmaN.beregnNormalspaending();
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
		
		this.vinkel.setGrader(vinkel);
		this.vinkel.setMaaltTilLodret(MaaltTilLodret);
		
		try {
			beregnTvaerkraft();
		} catch (DimensionerendeKraftEjDefineretException | VinkelEjDefineretException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			beregnNormalkraft();
		} catch (DimensionerendeKraftEjDefineretException | VinkelEjDefineretException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		System.out.println("Opret tau");
		tau = new ForskydningsSpaendningImpl();				
		tau.angivTvaerkraft(ft);
		tau.angivAreal(a);
		
		notifyObservers();			
	}
	
	
	@Override
	public double getForskydningsspaending() throws ForskydningsspaendingEjDefineretException, ArealEjDefineretException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, TvaerkraftEjDefineretException {
//		System.out.println("getForskydningsspaending()");
		if (tau == null) {
			System.out.println("getForskydningsspaending()");
			throw new ForskydningsspaendingEjDefineretException();

		}
		System.out.println(tau.getNmm2());
		double tauMm2 = tau.getNmm2();
		System.out.println("Tau = " + tauMm2);

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
	
	
}
