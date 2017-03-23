package logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.junit.Test;

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
import logic.Areal;
import logic.ArealImpl;
import logic.BoejningsMoment;
import logic.BoejningsMomentImpl;
import logic.Boejningsspaending;
import logic.BoejningsspaendingImpl;
import logic.Dimensionerendekraft;
import logic.DimensionerendekraftImpl;
import logic.Enhed;
import logic.FlydeSpaending;
import logic.FlydeSpaendingImpl;
import logic.ForskydningsSpaendning;
import logic.ForskydningsSpaendningImpl;
import logic.HalvProfilhoejde;
import logic.HalvProfilhoejdeImpl;
import logic.Inertimoment;
import logic.InertimomentImpl;
import logic.Laengde;
import logic.LaengdeImpl;
import logic.Normalkraft;
import logic.NormalkraftImpl;
import logic.Normalspaending;
import logic.NormalspaendingImpl;
import logic.PTECalculatorController;
import logic.PTECalculatorControllerImpl;
import logic.PTEObserver;
import logic.Referencespaending;
import logic.ReferencespaendingImpl;
import logic.SikkerhedsFaktor;
import logic.Tvaerkraft;
import logic.TvaerkraftImpl;
import logic.Vinkel;
import logic.VinkelImpl;

public class PTECalcControllerTest {
	PTECalculatorController pte = new PTECalculatorControllerImpl();

	@Test
	public void test() {
		try {
			testArealMock();
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException
				| InstantiationException | NegativArealException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			testBoejningsMomentMock();
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException
				| DimensionerendeKraftEjDefineretException | LaengdeEjDefineretException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			testBoejningsSpaending();
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException
				| HalvProfilhoejdeEjDefineretException | BoejningsMomentEjDefineretException
				| InertimomentEjDefineretException | BoejningsspaendingEjDefineretException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			testDimensionerendeKraftMock();
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException
				| NegativKgException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			testFlydeSpaendingMock();
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException
				| FlydeSpaendingEjDefineretException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			testForskydningsSpaendingMock();
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException
				| ArealEjDefineretException | ForskydningsspaendingEjDefineretException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			testHalfProfilHoejde();
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException
				| NegativHalvProfilhoejdeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			testInertiMoment();
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException
				| NegativInertimomentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			testLaengdeMock();
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			testNormalKraft();
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException
				| DimensionerendeKraftEjDefineretException | VinkelEjDefineretException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			testNormalSpaending();
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException
				| NegativArealException | NormalkraftEjDefineretException | DimensionerendeKraftEjDefineretException
				| VinkelEjDefineretException | NormalspaendingEjDefineretException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			testPTEOBserverMock();
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			testReferenceSpaendingMock();
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException
				| ForskydningsspaendingEjDefineretException | angivBoejningsspaendingEjDefineretException
				| NormalspaendingEjDefineretException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			testSikkerhedsFaktorMock();
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException
				| FlydeSpaendingEjDefineretException | ReferenceSpaendingEjDefineretException
				| SikkerhedsFaktorEjDefineretException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			testTvaerKraftMock();
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException
				| DimensionerendeKraftEjDefineretException | VinkelEjDefineretException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			testVinkelMock();
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException
				| erUnderFejlgraenseException | ErOverFejlGraenseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testArealMock() throws NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException, NegativArealException, InstantiationException {
		ArealMock a = new ArealMock();

		Field f = pte.getClass().getDeclaredField("a");
		f.setAccessible(true);
		System.out.println(f);
		f.set(pte, a);

		pte.angivAreal(2.0);

		assertEquals(2.0, a.angivetAreal, 0.001);
		assertEquals(10, a.getMm2(), 0.001);
	}
	@Test
	public void testBoejningsMomentMock() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, DimensionerendeKraftEjDefineretException, LaengdeEjDefineretException{
		BoejningsMomentMock b = new BoejningsMomentMock();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		Laengde l2 = new LaengdeImpl();
		
		Field f1 = pte.getClass().getDeclaredField("boejning");
		
		f1.setAccessible(true);
		
		f1.set(pte, b);
		
		b.angivDimensionerendeKraft(fdim);
		b.angivLaengde(l2);
		
		assertEquals(l2,b.angivetLaengde);
		assertEquals(fdim,b.angivetDimensionerendeKraft);
		
		assertEquals(10.0,b.getBoejningsMoment(),0.001);
		assertEquals("dette er boejningsMomentets mellemregning",b.getBoejningsMomentMellemRegning());
		
	}

	private class ArealMock implements Areal {
		public double angivetAreal = Double.NaN;

		@Override
		public double getMm2() {
			return 10;
		}

		@Override
		public void setMm2(double mm2) throws NegativArealException {
			angivetAreal = mm2;
		}
	}

	private class BoejningsMomentMock implements BoejningsMoment {
		private Dimensionerendekraft angivetDimensionerendeKraft = null;
		private Laengde angivetLaengde = null;

		@Override
		public void angivDimensionerendeKraft(Dimensionerendekraft fdim)
				throws DimensionerendeKraftEjDefineretException {
			angivetDimensionerendeKraft = fdim;
		}

		@Override
		public void angivLaengde(Laengde L2) throws LaengdeEjDefineretException {
			angivetLaengde = L2;
		}

		@Override
		public void beregnBoejningsMoment() {
		}

		@Override
		public double getBoejningsMoment()
				throws LaengdeEjDefineretException, DimensionerendeKraftEjDefineretException {
			return 10;
		}

		@Override
		public String getBoejningsMomentMellemRegning() {
			return "dette er boejningsMomentets mellemregning";
		}

	}

	private class BoejningsSpaendingMock implements Boejningsspaending {
		private Inertimoment angivetInertiMoment = null;
		private HalvProfilhoejde angivetHalvProfilHoejde = null;
		private BoejningsMoment angivetBoejningsMoment = null;

		@Override
		public void angivBoejningsmoment(BoejningsMoment boejning) throws BoejningsMomentEjDefineretException {
			angivetBoejningsMoment = boejning;
		}

		@Override
		public void angivInertimoment(Inertimoment i) throws InertimomentEjDefineretException {
			angivetInertiMoment = i;

		}

		@Override
		public void angivHalvProfilhoejde(HalvProfilhoejde e) throws HalvProfilhoejdeEjDefineretException {
			angivetHalvProfilHoejde = e;

		}

		@Override
		public void beregnBoejningsspaending() throws BoejningsMomentEjDefineretException,
				InertimomentEjDefineretException, HalvProfilhoejdeEjDefineretException {
			
		}

		@Override
		public double getBoejningsspaending() throws BoejningsspaendingEjDefineretException {
			return 10;
		}

		@Override
		public String getBoejningsspaendingMellemregning() throws BoejningsspaendingEjDefineretException {
			return "boejningsSpaendingMellemregning";
		}

	}
	@Test
	public void testBoejningsSpaending() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, HalvProfilhoejdeEjDefineretException, BoejningsMomentEjDefineretException, InertimomentEjDefineretException, BoejningsspaendingEjDefineretException{
		BoejningsSpaendingMock b = new BoejningsSpaendingMock();
		BoejningsMoment boejning = new BoejningsMomentImpl();
		HalvProfilhoejde e = new HalvProfilhoejdeImpl();
		Inertimoment i = new InertimomentImpl();
		
		Field f1 = pte.getClass().getDeclaredField("sigmaB");
		f1.setAccessible(true);
		f1.set(pte, b);
		
		b.angivBoejningsmoment(boejning);
		b.angivHalvProfilhoejde(e);
		b.angivInertimoment(i);
		
		assertEquals(boejning,b.angivetBoejningsMoment);
		assertEquals(e,b.angivetHalvProfilHoejde);
		assertEquals(i,b.angivetInertiMoment);
		assertEquals("boejningsSpaendingMellemregning", b.getBoejningsspaendingMellemregning());
		assertEquals(10.0,b.getBoejningsspaending(),0.001);
	}

	private class DimensionerendeKraftMock implements Dimensionerendekraft {
		private String angivetMellemRegning = "";
		private double angivetVaegt = Double.NaN;
		private Enhed angivetEnhed = null;
		@Override
		public double getNewton() {
			return 50;
		}

		@Override
		public double getKg() {
			return 10;
		}

		@Override
		public void setMellemRegning(String mellemRegning) {
			angivetMellemRegning = mellemRegning;
		}

		@Override
		public String getMellemRegning() {
			return angivetMellemRegning;
		}

		@Override
		public double setNewton(double newton) {
			return 20;
		}

		@Override
		public void setVaegt(double vaegt, Enhed enhed) throws NegativKgException {
			angivetVaegt = vaegt;
			angivetEnhed = enhed;
		}

		@Override
		public boolean erVaegtNormal() {
			return false;
		}
	}
	@Test
	public void testDimensionerendeKraftMock() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NegativKgException{
		DimensionerendeKraftMock fdim = new DimensionerendeKraftMock();
		
		Field f = pte.getClass().getDeclaredField("fdim");
		
		f.setAccessible(true);
		f.set(pte, fdim);
		
		fdim.setVaegt(10, Enhed.KG);
		assertEquals(10,fdim.angivetVaegt,0.001);
		assertEquals(Enhed.KG,fdim.angivetEnhed);
		
		fdim.setMellemRegning("mellemRegning for dimensionerendeKraft");
		assertEquals("mellemRegning for dimensionerendeKraft",fdim.angivetMellemRegning);
		assertEquals(false,fdim.erVaegtNormal());
		assertEquals(50,fdim.getNewton(),0.001);
		assertEquals(10,fdim.getKg(),0.001);
		
	}
	 private class FlydeSpaendingMock implements FlydeSpaending{
		private double angivetFlydeSpaending = Double.NaN;
		@Override
		public void angivFlydeSpaending(double value) throws FlydeSpaendingEjDefineretException {
			angivetFlydeSpaending = value;
		}

		@Override
		public double getFlydeSpaending() {
			return 10;
		}

		@Override
		public boolean erFlydeSpaendingNormal() {
			return false;
		}
	 }
	 @Test
	 public void testFlydeSpaendingMock() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, FlydeSpaendingEjDefineretException{
		 FlydeSpaendingMock sigmaTill = new FlydeSpaendingMock();
		 
		 Field f = pte.getClass().getDeclaredField("sigmaTill");
		 f.setAccessible(true);
		 f.set(pte, sigmaTill);
		 
		 sigmaTill.angivFlydeSpaending(100);
		 assertEquals(100,sigmaTill.angivetFlydeSpaending,0.001);
		 assertEquals(10,sigmaTill.getFlydeSpaending(),0.001);
		 assertEquals(false,sigmaTill.erFlydeSpaendingNormal());
		 
	 }
	  private class ForskydningsSpaendingMock implements ForskydningsSpaendning{
		private Tvaerkraft angivetTvaerKraft = null;
		private Areal angivetAreal = null;
		private double angivetNmm2 = Double.NaN;
		@Override
		public String getMellemregning() {
			return "mellemregning";
		}

		@Override
		public void angivTvaerkraft(Tvaerkraft ft) throws ForskydningsspaendingEjDefineretException {
			angivetTvaerKraft = ft;
		}

		@Override
		public void angivAreal(Areal a) throws ArealEjDefineretException {
			angivetAreal = a;
		}

		@Override
		public double getNmm2() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException,
				ForskydningsspaendingEjDefineretException, ArealEjDefineretException, TvaerkraftEjDefineretException {
			return 10;
		}

		@Override
		public void setNmm2(double nMm2) {
			angivetNmm2=nMm2;
		}
	 }
	  @Test
	  public void testForskydningsSpaendingMock() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ArealEjDefineretException, ForskydningsspaendingEjDefineretException{
		  ForskydningsSpaendingMock tau = new ForskydningsSpaendingMock();
		  Areal a = new ArealImpl();
		  Tvaerkraft ft = new TvaerkraftImpl();
		  Field f = pte.getClass().getDeclaredField("tau");
		  f.setAccessible(true);
		  f.set(pte, tau);
		  tau.angivAreal(a);
		  tau.angivTvaerkraft(ft);
		  tau.setNmm2(10);
		  
		  assertEquals(a,tau.angivetAreal);
		  assertEquals(ft,tau.angivetTvaerKraft);
		  assertEquals(10,tau.angivetNmm2,0.001);
		  assertEquals("mellemregning",tau.getMellemregning());
		  
	  }
	 private class HalvProfilHoejdeMock implements HalvProfilhoejde{
		private double angivetMm = Double.NaN;
		@Override
		public double getHalvProfilhoejde() {
			return 5;
		}

		@Override
		public void setMm(double mm) throws NegativHalvProfilhoejdeException {
			angivetMm=mm;
		}
	 }
	 @Test
	 public void testHalfProfilHoejde() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NegativHalvProfilhoejdeException{
		 HalvProfilHoejdeMock e = new HalvProfilHoejdeMock();
		 Field f = pte.getClass().getDeclaredField("e");
		 f.setAccessible(true);
		 f.set(pte, e);
		 e.setMm(10);
		 assertEquals(10,e.angivetMm,0.001);
		 assertEquals(5,e.getHalvProfilhoejde(),0.001);
	 }
	 private class InertiMomentMock implements Inertimoment{
		 private double angivetMm4 = Double.NaN;
		@Override
		public double getInertimoment() {
			return 5;
		}

		@Override
		public void setMm4(double mm4) throws NegativInertimomentException {
			angivetMm4 = mm4;
		}
	 }
	 @Test
	 public void testInertiMoment() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NegativInertimomentException{
		 InertiMomentMock i = new InertiMomentMock();
		 Field f = pte.getClass().getDeclaredField("i");
		 f.setAccessible(true);
		 f.set(pte, i);
		 i.setMm4(2);
		 assertEquals(2, i.angivetMm4,0.001);
		 assertEquals(5,i.getInertimoment(),0.001);
	 }
	 private class LaengdeMock implements Laengde{
		 private double angivetLaengde = Double.NaN;
		@Override
		public void angivLaengde(double l2) {
			angivetLaengde = l2;
		}

		@Override
		public double getLaengde() {
			return 4;
		}
	 }
	 @Test
	 public void testLaengdeMock() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		 LaengdeMock l2 = new LaengdeMock();
		 Field f = pte.getClass().getDeclaredField("l2");
		 f.setAccessible(true);
		 f.set(pte, l2);
		 l2.angivLaengde(5);
		 assertEquals(5,l2.angivetLaengde,0.001);
		 assertEquals(4,l2.getLaengde(),0.001);
	 }
	 private class NormalKraftMock implements Normalkraft{
		private Dimensionerendekraft angivetDimensionerendeKraft = null;
		private Vinkel angivetVinkel = null;
		private double angivetFnNewton = Double.NaN;
		 
		@Override
		public void angivDimensionerendekraft(Dimensionerendekraft fdim)
				throws DimensionerendeKraftEjDefineretException {
			angivetDimensionerendeKraft = fdim;
		}

		@Override
		public void angivVinkel(Vinkel vinkel) throws VinkelEjDefineretException {
			angivetVinkel = vinkel;
		}

		@Override
		public double getNewton() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
			return 5;
		}

		@Override
		public String getMellemregning() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
			return "mellemregning";
		}

		@Override
		public void setFnNewton(double fnNewton) {
			angivetFnNewton = fnNewton;
		}
	 }
	 @Test
	 public void testNormalKraft() throws NoSuchFieldException, SecurityException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, IllegalArgumentException, IllegalAccessException{
		 Vinkel vinkel = new VinkelImpl();
		 Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		 NormalKraftMock fn = new NormalKraftMock();
		 Field f = pte.getClass().getDeclaredField("fn");
		 f.setAccessible(true);
		 f.set(pte, fn);
		 
		 fn.angivVinkel(vinkel);
		 fn.angivDimensionerendekraft(fdim);
		 fn.setFnNewton(10);
		 
		 assertEquals(vinkel,fn.angivetVinkel);
		 assertEquals(fdim,fn.angivetDimensionerendeKraft);
		 assertEquals(10,fn.angivetFnNewton,0.001);
		 assertEquals("mellemregning",fn.getMellemregning());
		 assertEquals(5,fn.getNewton(),0.001);
	 }
	 private class NormalSpaendingMock implements Normalspaending{
		 private double angivetSigmaNmm2 = Double.NaN;
		 private String angivetMellemregning = "";
		 private Normalkraft angivetNormalKraft = null;
		 private Areal angivetAreal = null;
		@Override
		public double getSigmaNmm2() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException,
				NormalspaendingEjDefineretException {
			return 5;
		}

		@Override
		public void setSigmaNmm2(double nMm2) {
			angivetSigmaNmm2 = nMm2;
		}

		@Override
		public void setMellemregning(String mellemregning) {
			angivetMellemregning = mellemregning;
		}

		@Override
		public String getMellemregning() {
			return "mellemregning";
		}

		@Override
		public void angivNormalkraft(Normalkraft fn) throws NormalkraftEjDefineretException {
			angivetNormalKraft = fn;
		}

		@Override
		public void angivAreal(Areal a) throws NegativArealException {
			angivetAreal = a;
		}
	 }
	 @Test
	 public void testNormalSpaending() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NegativArealException, NormalkraftEjDefineretException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, NormalspaendingEjDefineretException{
		 Areal a = new ArealImpl();
		 Normalkraft fn = new NormalkraftImpl();
		 String mellemregning = "detter er en test";
		 double nMm2 = Double.NaN;
		 NormalSpaendingMock sigmaN = new NormalSpaendingMock();
		 Field f = pte.getClass().getDeclaredField("sigmaN");
		 f.setAccessible(true);
		 f.set(pte, sigmaN);
		 sigmaN.angivAreal(a);
		 sigmaN.angivNormalkraft(fn);
		 sigmaN.setMellemregning(mellemregning);
		 sigmaN.setSigmaNmm2(nMm2);
		 
		 assertEquals(a,sigmaN.angivetAreal);
		 assertEquals(fn,sigmaN.angivetNormalKraft);
		 assertEquals(mellemregning,sigmaN.angivetMellemregning);
		 assertEquals(nMm2,sigmaN.angivetSigmaNmm2,0.001);
		 assertEquals(5,sigmaN.getSigmaNmm2(),0.001);
		 assertEquals("mellemregning",sigmaN.getMellemregning());
	 }
	 private class PTEObserverMock implements PTEObserver{
		private boolean updateDone = false;
		@Override
		public void update() {
			updateDone = true;
		}
	 }
	 @Test
	 public void testPTEOBserverMock() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		 PTEObserverMock pteObs = new PTEObserverMock();
		 Field f = pte.getClass().getDeclaredField("observer");
		 f.setAccessible(true);
		 f.set(pte, pteObs);
		 pteObs.update();
		 assertTrue(pteObs.updateDone);
	 }
	 private class ReferenceSpaendingMock implements Referencespaending{
		Normalspaending angivetNormalSpaending = null;
		Boejningsspaending angivetBoejningsSpaending = null;
		ForskydningsSpaendning angivetForskydningsSpaending = null;
		private double angivetSigmaRefNmm2 = Double.NaN; 
		@Override
		public double getSigmaRef() {
			return 5;
		}

		@Override
		public String GetMellemRegning() {
			return "mellemregning";
		}

		@Override
		public void angivNormalspaending(Normalspaending sigmaN) throws NormalspaendingEjDefineretException {
			angivetNormalSpaending = sigmaN;
		}

		@Override
		public void angivBoejningsspaending(Boejningsspaending sigmaB)
				throws angivBoejningsspaendingEjDefineretException {
			angivetBoejningsSpaending = sigmaB;
		}

		@Override
		public void angivForskydsningsspaending(ForskydningsSpaendning tau)
				throws ForskydningsspaendingEjDefineretException {
			angivetForskydningsSpaending = tau;
		}

		@Override
		public void setSigmaRefNmm2(double sigmaRefNmm2) {
			angivetSigmaRefNmm2 = sigmaRefNmm2;
		}
	 }
	 @Test
	 public void testReferenceSpaendingMock() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ForskydningsspaendingEjDefineretException, angivBoejningsspaendingEjDefineretException, NormalspaendingEjDefineretException{
		 Boejningsspaending sigmaB = new BoejningsspaendingImpl();
		 ForskydningsSpaendning tau = new ForskydningsSpaendningImpl();
		 Normalspaending sigmaN = new NormalspaendingImpl();
		 
		 ReferenceSpaendingMock sigmaRef = new ReferenceSpaendingMock();
		 Field f = pte.getClass().getDeclaredField("sigmaRef");
		 f.setAccessible(true);
		 f.set(pte, sigmaRef);
		 sigmaRef.angivBoejningsspaending(sigmaB);
		 sigmaRef.angivForskydsningsspaending(tau);
		 sigmaRef.angivNormalspaending(sigmaN);
		 sigmaRef.setSigmaRefNmm2(10);
		 
		 assertEquals(sigmaB,sigmaRef.angivetBoejningsSpaending);
		 assertEquals(tau,sigmaRef.angivetForskydningsSpaending);
		 assertEquals(sigmaN,sigmaRef.angivetNormalSpaending);
		 assertEquals(10,sigmaRef.angivetSigmaRefNmm2,0.001);
		 assertEquals("mellemregning",sigmaRef.GetMellemRegning());
		 assertEquals(5,sigmaRef.getSigmaRef(),0.001);
		 
	 }
	 private class SikkerhedsFaktorMock implements SikkerhedsFaktor{
		 Referencespaending angivetReferenceSpaending = null;
		 FlydeSpaending angivetFlydeSpaending = null;
		 
		@Override
		public void angivReferencespaending(Referencespaending sigmaRef) throws ReferenceSpaendingEjDefineretException {
			angivetReferenceSpaending = sigmaRef;
		}

		@Override
		public void angivFlydeSpaending(FlydeSpaending sigmaTill) throws FlydeSpaendingEjDefineretException {
			angivetFlydeSpaending = sigmaTill;
		}

		@Override
		public void beregnSikkerhedsFaktor()
				throws FlydeSpaendingEjDefineretException, ReferenceSpaendingEjDefineretException {
			
		}

		@Override
		public String getSikkerhedsFaktorMellemRegning()
				throws ReferenceSpaendingEjDefineretException, FlydeSpaendingEjDefineretException {
			return "mellemregning";
		}

		@Override
		public double getSikkerhedsFaktor() throws SikkerhedsFaktorEjDefineretException {
			return 5;
		}
	 }
	 @Test
	 public void testSikkerhedsFaktorMock() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, FlydeSpaendingEjDefineretException, ReferenceSpaendingEjDefineretException, SikkerhedsFaktorEjDefineretException{
		 SikkerhedsFaktorMock sf = new SikkerhedsFaktorMock();
		 FlydeSpaending sigmaTill = new FlydeSpaendingImpl();
		 Referencespaending sigmaRef = new ReferencespaendingImpl();
		 Field f = pte.getClass().getDeclaredField("sf");
		 f.setAccessible(true);
		 f.set(pte, sf);
		 sf.angivFlydeSpaending(sigmaTill);
		 sf.angivReferencespaending(sigmaRef);
		 
		 assertEquals(sigmaTill,sf.angivetFlydeSpaending);
		 assertEquals(sigmaRef,sf.angivetReferenceSpaending);
		 assertEquals(5,sf.getSikkerhedsFaktor(),0.001);
		 assertEquals("mellemregning",sf.getSikkerhedsFaktorMellemRegning());
		
	 }
	 private class TvaerKraftMock implements Tvaerkraft{
		 Dimensionerendekraft angivetDimensionerendeKraft = null;
		 Vinkel angivetVinkel = null;
		 double angivetFtNewton = Double.NaN;
		@Override
		public String getMellemregning() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
			return "mellemregning";
		}

		@Override
		public void angivDimensionerendekraft(Dimensionerendekraft fdim)
				throws DimensionerendeKraftEjDefineretException {
			angivetDimensionerendeKraft = fdim;
		}

		@Override
		public void angivVinkel(Vinkel vinkel) throws VinkelEjDefineretException {
			angivetVinkel = vinkel;
		}

		@Override
		public double getNewton() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
			return 5;
		}

		@Override
		public void setFtNewton(double ftNewton) {
			angivetFtNewton = ftNewton;
		}
	 }
	 @Test
	 public void testTvaerKraftMock() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException{
		 TvaerKraftMock ft = new TvaerKraftMock();
		 Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		 Vinkel vinkel = new VinkelImpl();
		 Field f = pte.getClass().getDeclaredField("ft");
		 f.setAccessible(true);
		 f.set(pte, ft);
		 ft.angivDimensionerendekraft(fdim);
		 ft.angivVinkel(vinkel);
		 ft.setFtNewton(4);
		 assertEquals(fdim,ft.angivetDimensionerendeKraft);
		 assertEquals(vinkel,ft.angivetVinkel);
		 assertEquals(4,ft.angivetFtNewton,0.001);
		 assertEquals(5,ft.getNewton(),0.001);
	 }
	 private class VinkelMock implements Vinkel{
		private double angivetGrader = Double.NaN;
		private boolean angivetMaaltTilLodret;
		@Override
		public double getGrader() {
			return 45;
		}

		@Override
		public void setGrader(double grader) throws erUnderFejlgraenseException, ErOverFejlGraenseException {
			angivetGrader = grader;
		}

		@Override
		public boolean getMaaltTilLodret() {
			return false;
		}

		@Override
		public void setMaaltTilLodret(boolean erMaaltTilLodret) {
			angivetMaaltTilLodret = erMaaltTilLodret;
		}
	
	 }
	 @Test
	 public void testVinkelMock() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, erUnderFejlgraenseException, ErOverFejlGraenseException{
		 VinkelMock vinkel = new VinkelMock();
		 
		 Field f = pte.getClass().getDeclaredField("vinkel");
		 f.setAccessible(true);
		 f.set(pte, vinkel);
		 vinkel.setGrader(40);
		 vinkel.setMaaltTilLodret(true);
		 
		 assertEquals(40,vinkel.angivetGrader,0.001);
		 assertEquals(true,vinkel.angivetMaaltTilLodret);
		 assertEquals(false,vinkel.getMaaltTilLodret());
	 }
}
