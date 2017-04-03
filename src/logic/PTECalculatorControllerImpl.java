package logic;

import java.io.IOException;

import com.itextpdf.text.DocumentException;

import exceptions.ArealEjDefineretException;
import exceptions.ArmEjDefineretException;
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

public class PTECalculatorControllerImpl implements PTECalculatorController {

	private PTEObserver observer;

	private Dimensionerendekraft fdim;
	private Tvaerkraft ft;
	private Vinkel vinkel;
	private Normalkraft fn;
	private ForskydningsSpaendning tau;
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
	private Arm arm;
	private BoejningsMomentMedFT boejningFt;

	public void exportToPdf() {
		try {
			new PdfExporter().exportToPdf();
		} catch (DocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public double getBoejningsMoment() throws BoejningsMomentEjDefineretException, LaengdeEjDefineretException,
			DimensionerendeKraftEjDefineretException {
		if (boejning == null) {
			throw new BoejningsMomentEjDefineretException();
		}

		return boejning.getBoejningsMoment();

	}

	@Override
	public void beregnSikkerhedsFaktor()
			throws ReferenceSpaendingEjDefineretException, FlydeSpaendingEjDefineretException {
		if (sf == null)
			sf = new SikkerhedsFaktorImpl();
		if (sigmaTill == null) {
			throw new FlydeSpaendingEjDefineretException();
		}
		if (sigmaRef == null) {
			throw new ReferenceSpaendingEjDefineretException();
		}

		sf.angivFlydeSpaending(sigmaTill);
		sf.angivReferencespaending(sigmaRef);
		notifyObservers();

	}

	@Override
	public void beregnBoejningsMoment() throws DimensionerendeKraftEjDefineretException, LaengdeEjDefineretException {
		if (fdim == null) {
			throw new DimensionerendeKraftEjDefineretException();
		}
		if (l2 == null) {
			throw new LaengdeEjDefineretException();
		}
		if (boejning == null)
			boejning = new BoejningsMomentImpl();

		boejning.angivDimensionerendeKraft(fdim);

		boejning.angivLaengde(l2);

		boejning.beregnBoejningsMoment();

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

		if (fn == null)
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
	public void angivVaegt(double vaegt, Enhed enhed) throws NegativKgException {

		if (fdim == null)
			fdim = new DimensionerendekraftImpl();
		if (vaegt == Double.NaN)
			fdim = null;

		fdim.setVaegt(vaegt, enhed);

		notifyObservers();
	}

	@Override
	public double getAreal() throws ArealEjDefineretException {
		if (a == null) {
			throw new ArealEjDefineretException();
		}
		return a.getMm2();
	}

	@Override
	public void angivAreal(double mm2) throws NegativArealException {
		if (this.a == null) {
			this.a = new ArealImpl();
		}
		if (mm2 == Double.NaN)
			a = null;
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
	public void angivVinkel(double vinkel, boolean MaaltTilLodret)
			throws erUnderFejlgraenseException, DimensionerendeKraftEjDefineretException {
		if (this.vinkel == null) {
			this.vinkel = new VinkelImpl();
		}
		if (vinkel == Double.NaN)
			this.vinkel = null;
		try {
			this.vinkel.setGrader(vinkel);
		} catch (ErOverFejlGraenseException e) {
			e.printStackTrace();
		}
		this.vinkel.setMaaltTilLodret(MaaltTilLodret);

		// try {
		// beregnTvaerkraft();
		// } catch (DimensionerendeKraftEjDefineretException |
		// VinkelEjDefineretException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// try {
		// beregnNormalkraft();
		// } catch (DimensionerendeKraftEjDefineretException |
		// VinkelEjDefineretException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		notifyObservers();
	}

	@Override
	public void tilmeldObserver(PTEObserver observer) {
		this.observer = observer;

	}

	@Override
	public double getDimensionerendekraft() throws DimensionerendeKraftEjDefineretException {
		if (fdim == null)
			throw new DimensionerendeKraftEjDefineretException();
		return fdim.getNewton();
	}

	@Override
	public String getDimensionerendekraftMellemregning() throws DimensionerendeKraftEjDefineretException {
		if (fdim == null)
			throw new DimensionerendeKraftEjDefineretException();
		return fdim.getMellemRegning();
	}

	@Override
	public void setFtNewton(double ftNewton)
			throws TvaerkraftEjDefineretException, DimensionerendeKraftEjDefineretException {
		if (ft == null)
			ft = new TvaerkraftImpl();

		ft.setFtNewton(ftNewton);

		notifyObservers();
	}

	// @Override
	// public void setFnNewton(double fnNewton) throws
	// DimensionerendeKraftEjDefineretException {
	// if (fn == null)
	// fn = new NormalkraftImpl();
	// fn.setFnNewton(fnNewton);
	//
	// notifyObservers();
	// }

	@Override
	public boolean erVaegtNormal() throws DimensionerendeKraftEjDefineretException {
		if (fdim == null)
			throw new DimensionerendeKraftEjDefineretException();
		return fdim.erVaegtNormal();

	}

	@Override
	public void beregnForskydningsspaendning()
			throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException,
			ForskydningsspaendingEjDefineretException, ArealEjDefineretException, TvaerkraftEjDefineretException {

		if (ft == null) {
			throw new TvaerkraftEjDefineretException();
		}

		if (a == null) {
			throw new ArealEjDefineretException();
		}
		if (tau == null)
			tau = new ForskydningsSpaendningImpl();
		tau.angivTvaerkraft(ft);
		tau.angivAreal(a);

		notifyObservers();
	}

	@Override
	public double getForskydningsspaending()
			throws ForskydningsspaendingEjDefineretException, ArealEjDefineretException,
			DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, TvaerkraftEjDefineretException {

		if (tau == null) {
			throw new ForskydningsspaendingEjDefineretException();

		}
		double tauMm2 = tau.getNmm2();

		return tauMm2;
	}

	@Override
	public String getForskydningsspaendingMellemregning() throws ForskydningsspaendingEjDefineretException {

		if (tau == null) {
			throw new ForskydningsspaendingEjDefineretException();

		}

		String forskydningsspaendingMellemregning = tau.getMellemregning();

		return forskydningsspaendingMellemregning;

	}

	// @Override
	// public void setForskydningsspaending(double nMm2) {
	//
	// tau = new ForskydningsSpaendningImpl();
	// tau.setNmm2(nMm2);
	//
	// notifyObservers();
	// }

	@Override
	public void beregnNormalspaending() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException,
			NormalspaendingEjDefineretException, NormalkraftEjDefineretException, ArealEjDefineretException {
		if (fn == null) {
			throw new NormalkraftEjDefineretException();
		}
		if (a == null) {
			throw new ArealEjDefineretException();
		}
		if (sigmaN == null)
			sigmaN = new NormalspaendingImpl();
		sigmaN.angivNormalkraft(fn);
		try {
			sigmaN.angivAreal(a);
		} catch (NegativArealException e) {
			e.printStackTrace();
		}

		notifyObservers();
	}

	// @Override
	// public void setNormalspaending(double sigmaNmm2) {
	// sigmaN = new NormalspaendingImpl();
	// sigmaN.setSigmaNmm2(sigmaNmm2);
	//
	// notifyObservers();
	// }

	@Override
	public double getNormalspaending() throws NormalspaendingEjDefineretException,
			DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, ArealEjDefineretException {

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
			BoejningsspaendingEjDefineretException, ForskydningsspaendingEjDefineretException, BoejningsspaendingEjDefineretException {
		if (sigmaN == null) {
			throw new NormalspaendingEjDefineretException();
		}
		if (sigmaB == null) {// TODO sigmaB ikke implamenteret (SA)
			throw new BoejningsspaendingEjDefineretException();
		}
		if (tau == null) {
			throw new ForskydningsspaendingEjDefineretException();
		}

		if (sigmaRef == null)
			sigmaRef = new ReferencespaendingImpl();

		sigmaRef.angivBoejningsspaending(sigmaB);

		sigmaRef.angivForskydsningsspaending(tau);

		sigmaRef.angivNormalspaending(sigmaN);

		notifyObservers();
	}

	@Override
	public double getSigmaRef() throws ReferenceSpaendingEjDefineretException, InertimomentEjDefineretException,
			HalvProfilhoejdeEjDefineretException, LaengdeEjDefineretException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, NormalspaendingEjDefineretException, ArealEjDefineretException, BoejningsspaendingEjDefineretException, ForskydningsspaendingEjDefineretException, TvaerkraftEjDefineretException {
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

		String referenceSpaendingMellemregning = sigmaRef.getSigmaRefMellemregning();

		return referenceSpaendingMellemregning;

	}

	// @Override
	// public void setReferenceSpaending(double sigmaRefNmm2) {
	// sigmaRef = new ReferencespaendingImpl();
	// sigmaRef.setSigmaRefNmm2(sigmaRefNmm2);
	//
	// notifyObservers();
	// }

	@Override
	public double getSikkerhedsfaktor() throws SikkerhedsFaktorEjDefineretException, FlydeSpaendingEjDefineretException,
			ReferenceSpaendingEjDefineretException, InertimomentEjDefineretException,
			HalvProfilhoejdeEjDefineretException, LaengdeEjDefineretException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, NormalspaendingEjDefineretException, ArealEjDefineretException, BoejningsspaendingEjDefineretException, ForskydningsspaendingEjDefineretException, TvaerkraftEjDefineretException {

		if (sf == null)
			throw new SikkerhedsFaktorEjDefineretException();
		double sfvaerdi = sf.getSikkerhedsFaktor();
		return sfvaerdi;
	}

	@Override
	public String getSikkerhedsfaktorMellemregning() throws SikkerhedsFaktorEjDefineretException,
			ReferenceSpaendingEjDefineretException, FlydeSpaendingEjDefineretException {
		if (sf == null)
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

		if (sigmaB == null)
			sigmaB = new BoejningsspaendingImpl();
		sigmaB.angivBoejningsmoment(boejning);
		sigmaB.angivInertimoment(i);
		sigmaB.angivHalvProfilhoejde(e);

		notifyObservers();

	}

	@Override
	public double getBoejningsspaending() throws BoejningsspaendingEjDefineretException, LaengdeEjDefineretException,
			DimensionerendeKraftEjDefineretException, HalvProfilhoejdeEjDefineretException,
			InertimomentEjDefineretException {

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

	@Override
	public void angivLaengde(double l2) throws LaengdeEjDefineretException {
		if (this.l2 == null) {
			this.l2 = new LaengdeImpl();
		}
		this.l2.angivLaengde(l2);

		notifyObservers();

	}

	@Override
	public double getFlydeSpaending() throws FlydeSpaendingEjDefineretException {
		if (sigmaTill == null) {
			throw new FlydeSpaendingEjDefineretException();
		}

		return sigmaTill.getFlydeSpaending();
	}

	@Override
	public String getBoejningsMomentMellemRegning() throws BoejningsMomentEjDefineretException {
		if (boejning == null) {
			throw new BoejningsMomentEjDefineretException();

		}

		String BoejningsMomentMellemRegning = boejning.getBoejningsMomentMellemRegning();
		return BoejningsMomentMellemRegning;
	}

	@Override
	public double getLaengde() throws LaengdeEjDefineretException {
		if (l2 == null)
			throw new LaengdeEjDefineretException();

		return l2.getLaengde();
	}

	@Override
	public void angivIntertimoment(double i) throws InertimomentEjDefineretException, NegativInertimomentException {
		if (this.i == null) {
			this.i = new InertimomentImpl();
		}
		if (i == Double.NaN)
			this.i = null;
		this.i.setMm4(i);

		notifyObservers();
	}

	@Override
	public double getInertimoment() throws InertimomentEjDefineretException {
		if (i == null)
			throw new InertimomentEjDefineretException();
		return i.getInertimoment();
	}

	@Override
	public void angivFlydespaending(double flyde) throws FlydeSpaendingEjDefineretException {
		if (sigmaTill == null)
			sigmaTill = new FlydeSpaendingImpl();
		if (flyde == Double.NaN)
			sigmaTill = null;

		this.sigmaTill.angivFlydeSpaending(flyde);

		notifyObservers();
	}

	@Override
	public void angivHalvProfilhoejde(double e)
			throws HalvProfilhoejdeEjDefineretException, NegativHalvProfilhoejdeException {
		if (this.e == null)
			this.e = new HalvProfilhoejdeImpl();
		if (e == Double.NaN)
			this.e = null;

		this.e.setMm(e);

		notifyObservers();
	}

	@Override
	public double getHalvProfilhoejde() throws HalvProfilhoejdeEjDefineretException {
		if (e == null)
			throw new HalvProfilhoejdeEjDefineretException();

		return e.getHalvProfilhoejde();
	}

	@Override
	public void sletAlt() {
		fdim = null;
		ft = null;
		vinkel = null;
		fn = null;
		tau = null;
		sigmaN = null;
		sigmaTill = null;
		sigmaRef = null;
		a = null;
		sf = null;
		l2 = null;
		boejning = null;
		i = null;
		e = null;
		sigmaB = null;

		notifyObservers();

	}

	@Override
	public void beregnBoejningsMomentMedFt() throws TvaerkraftEjDefineretException, ArmEjDefineretException,
			DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
		if (ft == null) {
			throw new TvaerkraftEjDefineretException();
		}
		if (arm == null) {
			throw new ArmEjDefineretException();
		}
		if (boejningFt == null)
			boejningFt = new BoejningsMomentMedFTImpl();
		boejningFt.angivTvaerkraft(ft);
		boejningFt.angivArm(arm);
		boejningFt.beregnBoejningsMoment();
		notifyObservers();

	}

	@Override
	public double getBoejningsMomentMedFt() throws BoejningsMomentEjDefineretException, LaengdeEjDefineretException,
			DimensionerendeKraftEjDefineretException, TvaerkraftEjDefineretException, ArmEjDefineretException,
			VinkelEjDefineretException {
		if (boejningFt == null) {
			throw new BoejningsMomentEjDefineretException();
		}
		return boejningFt.getBoejningsMoment();
	}

	@Override
	public String getBoejningsMomentMedFtMellemregning() throws BoejningsMomentEjDefineretException {
		if (boejningFt == null) {
			throw new BoejningsMomentEjDefineretException();
		}
		String BoejningsMomentMellemRegning = boejningFt.getBoejningsMomentMellemRegning();
		return BoejningsMomentMellemRegning;
	}

	@Override
	public void angivArm(double arm) throws ArmEjDefineretException {
		if (this.arm == null) {
			this.arm = new ArmImpl();
		}

		this.arm.angivArm(arm);
		notifyObservers();
	}

	@Override
	public double getArm() throws ArmEjDefineretException {
		if (arm == null)
			throw new ArmEjDefineretException();

		return arm.getArm();
	}
}