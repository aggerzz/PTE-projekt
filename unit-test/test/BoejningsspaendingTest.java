package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import exceptions.BoejningsMomentEjDefineretException;
import exceptions.BoejningsspaendingEjDefineretException;
import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.HalvProfilhoejdeEjDefineretException;
import exceptions.InertimomentEjDefineretException;
import exceptions.LaengdeEjDefineretException;
import exceptions.NegativHalvProfilhoejdeException;
import exceptions.NegativInertimomentException;
import logic.BoejningsMoment;
import logic.Boejningsspaending;
import logic.BoejningsspaendingImpl;
import logic.Dimensionerendekraft;
import logic.HalvProfilhoejde;
import logic.Inertimoment;
import logic.Laengde;



public class BoejningsspaendingTest {

	private class HalvProfilhoejdeMock implements HalvProfilhoejde {

		@Override
		public double getHalvProfilhoejde() {
			// TODO Auto-generated method stub
			return 20;
		}

		@Override
		public void setMm(double mm) throws NegativHalvProfilhoejdeException {
			// TODO Auto-generated method stub

		}

	}

	private class InertimomentMock implements Inertimoment {

		@Override
		public double getInertimoment() {
			// TODO Auto-generated method stub
			return 10;
		}

		@Override
		public void setMm4(double mm4) throws NegativInertimomentException {
			// TODO Auto-generated method stub

		}

	}

	private class BoejningsMomentMock implements BoejningsMoment {

		@Override
		public void angivDimensionerendeKraft(Dimensionerendekraft fdim)
				throws DimensionerendeKraftEjDefineretException {
			// TODO Auto-generated method stub

		}

		@Override
		public void angivLaengde(Laengde L2) throws LaengdeEjDefineretException {
			// TODO Auto-generated method stub

		}

		@Override
		public void beregnBoejningsMoment() {
			// TODO Auto-generated method stub

		}

		@Override
		public double getBoejningsMoment()
				throws LaengdeEjDefineretException, DimensionerendeKraftEjDefineretException {		
			return 0.5;
		}

		@Override
		public String getBoejningsMomentMellemRegning() {
			// TODO Auto-generated method stub
			return null;
		}

	}

	@Test
	public void testBoejningsspaendingForPositivBoejningsmomentOgPositivIntertimomentOgPositivHalvProfilhoejde() 
			throws BoejningsspaendingEjDefineretException, BoejningsMomentEjDefineretException, NegativHalvProfilhoejdeException, 
			NegativInertimomentException, InertimomentEjDefineretException, HalvProfilhoejdeEjDefineretException {
		
		Boejningsspaending sigmaB = new BoejningsspaendingImpl();
		BoejningsMoment bm = new BoejningsMomentMock();
		Inertimoment i = new InertimomentMock();
		HalvProfilhoejde e = new HalvProfilhoejdeMock();
		
		
		sigmaB.angivBoejningsmoment(bm);
		sigmaB.angivInertimoment(i);
		sigmaB.angivHalvProfilhoejde(e);	
		
		double bsINmm2 = sigmaB.getBoejningsspaending();
		assertEquals(1, bsINmm2, 0.001);
	}
	
	@Test (expected = BoejningsMomentEjDefineretException.class)
	public void BoejningsMomentEjDefineretExceptiontest() throws BoejningsMomentEjDefineretException, NegativInertimomentException, NegativHalvProfilhoejdeException, InertimomentEjDefineretException, HalvProfilhoejdeEjDefineretException, BoejningsspaendingEjDefineretException {
		Boejningsspaending sigmaB = new BoejningsspaendingImpl();
		Inertimoment i = new InertimomentMock();
		HalvProfilhoejde e = new HalvProfilhoejdeMock();

		sigmaB.angivInertimoment(i);
		sigmaB.angivHalvProfilhoejde(e);
		
		sigmaB.getBoejningsspaending();
		fail("BoejningsMomentEjDefineretException ej kastet");

	}

	@Test (expected = InertimomentEjDefineretException.class)
	public void InertimomentEjDefineretExceptiontest() throws InertimomentEjDefineretException, NegativHalvProfilhoejdeException, BoejningsMomentEjDefineretException, HalvProfilhoejdeEjDefineretException, BoejningsspaendingEjDefineretException {
		Boejningsspaending sigmaB = new BoejningsspaendingImpl();
		BoejningsMoment mb = new BoejningsMomentMock();
		HalvProfilhoejde e = new HalvProfilhoejdeMock();
				
		sigmaB.angivBoejningsmoment(mb);
		sigmaB.angivHalvProfilhoejde(e);	
		
		sigmaB.getBoejningsspaending();
		fail("InertimomentEjDefineretException ej kastet");
		
	}	
	
	@Test (expected = HalvProfilhoejdeEjDefineretException.class)
	public void HalvProfilhoejdeEjDefineretExceptiontest() throws HalvProfilhoejdeEjDefineretException, NegativInertimomentException, InertimomentEjDefineretException, BoejningsMomentEjDefineretException, BoejningsspaendingEjDefineretException {
		Boejningsspaending sigmaB = new BoejningsspaendingImpl();
		BoejningsMoment mb = new BoejningsMomentMock();
		Inertimoment i = new InertimomentMock();
		
		sigmaB.angivInertimoment(i);
		sigmaB.angivBoejningsmoment(mb);	

		sigmaB.getBoejningsspaending();
		fail("HalvProfilhoejdeEjDefineretException ej kastet");
	}

}
