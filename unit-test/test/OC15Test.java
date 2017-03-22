package test;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.BoejningsMomentEjDefineretException;
import exceptions.BoejningsspaendingEjDefineretException;
import exceptions.HalvProfilhoejdeEjDefineretException;
import exceptions.InertimomentEjDefineretException;
import exceptions.NegativHalvProfilhoejdeException;
import exceptions.NegativInertimomentException;
import logic.BoejningsMoment;
import logic.Boejningsspaending;
import logic.BoejningsspaendingImpl;
import logic.Dimensionerendekraft;
import logic.HalvProfilhoejde;
import logic.HalvProfilhoejdeImpl;
import logic.Inertimoment;
import logic.InertimomentImpl;
import logic.Laengde;

public class OC15Test {

	private class BoejningsMomentMock implements BoejningsMoment {

		@Override
		public void angivDimensionerendeKraft(Dimensionerendekraft fdim) { // TODO Auto-generated method stub
		}
		@Override
		public void angivLaengde(Laengde L2) {	// TODO Auto-generated method stub
		}
		@Override
		public void beregnBoejningsMoment() { // TODO Auto-generated method stub
		}
		@Override
		public double getBoejningsMoment() {
				return 0.5;
		
		}

	}

	@Test
	public void testberegnSigmaB() throws BoejningsMomentEjDefineretException, InertimomentEjDefineretException, HalvProfilhoejdeEjDefineretException, BoejningsspaendingEjDefineretException, NegativInertimomentException, NegativHalvProfilhoejdeException {

		Boejningsspaending sigmaB = new BoejningsspaendingImpl();
		BoejningsMomentMock mb = new BoejningsMomentMock();
		Inertimoment i = new InertimomentImpl();
		HalvProfilhoejde e = new HalvProfilhoejdeImpl();

		i.setMm4(10);
		e.setMm(20);
		
		sigmaB.angivBoejningsmoment(mb);
		sigmaB.angivInertimoment(i);
		sigmaB.angivHalvProfilhoejde(e);
		

		assertEquals(1, sigmaB.getBoejningsspaending(), 0.001);
		assertEquals("sigmaB = mb*e/i" + "\n" + " 1 = 0.5*20/10", sigmaB.getBoejningsspaendingMellemregning());

	}

	@Test (expected = BoejningsMomentEjDefineretException.class)
	public void BoejningsMomentEjDefineretExceptiontest() throws BoejningsMomentEjDefineretException, NegativInertimomentException, NegativHalvProfilhoejdeException, InertimomentEjDefineretException, HalvProfilhoejdeEjDefineretException, BoejningsspaendingEjDefineretException {
		Boejningsspaending sigmaB = new BoejningsspaendingImpl();
		Inertimoment i = new InertimomentImpl();
		HalvProfilhoejde e = new HalvProfilhoejdeImpl();

		i.setMm4(40);
		e.setMm(15);
		
		sigmaB.angivInertimoment(i);
		sigmaB.angivHalvProfilhoejde(e);
		
		sigmaB.getBoejningsspaending();
		fail("BoejningsMomentEjDefineretException ej kastet");

	}

	@Test (expected = InertimomentEjDefineretException.class)
	public void InertimomentEjDefineretExceptiontest() throws InertimomentEjDefineretException, NegativHalvProfilhoejdeException, BoejningsMomentEjDefineretException, HalvProfilhoejdeEjDefineretException {
		Boejningsspaending sigmaB = new BoejningsspaendingImpl();
		BoejningsMomentMock mb = new BoejningsMomentMock();
		HalvProfilhoejde e = new HalvProfilhoejdeImpl();
		
		mb.getBoejningsMoment();
		e.setMm(20);
		
		sigmaB.angivBoejningsmoment(mb);
		sigmaB.angivHalvProfilhoejde(e);
		
		sigmaB.angivInertimoment(null);
		fail("InertimomentEjDefineretException ej kastet");
		
	}	
	
	@Test (expected = HalvProfilhoejdeEjDefineretException.class)
	public void HalvProfilhoejdeEjDefineretExceptiontest() throws HalvProfilhoejdeEjDefineretException, NegativInertimomentException, InertimomentEjDefineretException, BoejningsMomentEjDefineretException {
		Boejningsspaending sigmaB = new BoejningsspaendingImpl();
		BoejningsMomentMock mb = new BoejningsMomentMock();
		Inertimoment i = new InertimomentImpl();
		
		mb.getBoejningsMoment();
		i.setMm4(40);
	
		sigmaB.angivInertimoment(i);
		sigmaB.angivBoejningsmoment(mb);
		
		sigmaB.angivHalvProfilhoejde(null);
		fail("HalvProfilhoejdeEjDefineretException ej kastet");
	}

}
