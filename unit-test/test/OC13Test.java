package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.LaengdeEjDefineretException;
import exceptions.erUnderFejlgraenseException;
import logic.BoejningsMoment;
import logic.BoejningsMomentImpl;
import logic.Dimensionerendekraft;
import logic.DimensionerendekraftImpl;
import logic.Enhed;
import logic.Laengde;
import logic.LaengdeImpl;
import logic.PTECalculatorController;
import logic.PTECalculatorControllerImpl;

public class OC13Test {

	@Test
	public void testkorrektudregningAfBoejningsMoment()	throws DimensionerendeKraftEjDefineretException, erUnderFejlgraenseException {
		PTECalculatorController calc = new PTECalculatorControllerImpl();
		
		calc.
		
		
		Laengde l2 = new LaengdeImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		BoejningsMoment mb = new BoejningsMomentImpl();

		l2.angivLaengde(20);
		fdim.setVaegt(60, Enhed.NEWTON);
		mb.angivDimensionerendeKraft(fdim);
		mb.angivLaengde(l2);
		mb.beregnBoejningsMoment();
		double mbtal = mb.getBoejningsMoment();
		assertEquals(1200, mbtal, 0.001);
		
	}

	@Test(expected = DimensionerendeKraftEjDefineretException.class)
	public void testDimensionerendeKraftNull() throws DimensionerendeKraftEjDefineretException, erUnderFejlgraenseException {
		PTECalculatorController calc = new PTECalculatorControllerImpl();
		
		calc.getDimensionerendekraft();
		
		fail("DimensionerendeKraftEjDefineretException ej indtruffet");
	}

	@Test (expected = LaengdeEjDefineretException.class)
	public void testLaengdeNulltest() throws DimensionerendeKraftEjDefineretException, erUnderFejlgraenseException, LaengdeEjDefineretException {
		PTECalculatorController calc = new PTECalculatorControllerImpl();

		calc.angivVaegt(10, Enhed.KG);
		calc.beregnBoejningsMoment();
		
		fail("LaengdeEjDefineretException ej indtruffet");
	}

}
