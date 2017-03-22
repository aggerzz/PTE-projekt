package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import exceptions.BoejningsMomentEjDefineretException;
import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.LaengdeEjDefineretException;
import exceptions.NegativKgException;
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
	public void testkorrektudregningAfBoejningsMoment() throws DimensionerendeKraftEjDefineretException,
			erUnderFejlgraenseException, LaengdeEjDefineretException, BoejningsMomentEjDefineretException, NegativKgException {
		PTECalculatorController calc = new PTECalculatorControllerImpl();

		calc.angivLaengde(1400);
		calc.angivVaegt(495, Enhed.KG);
		calc.beregnBoejningsMoment();

		assertEquals(6802488, calc.getBoejningsMoment(), 0.001);

	}

	@Test(expected = DimensionerendeKraftEjDefineretException.class)
	public void testDimensionerendeKraftNull()
			throws DimensionerendeKraftEjDefineretException, erUnderFejlgraenseException {
		PTECalculatorController calc = new PTECalculatorControllerImpl();

		calc.getDimensionerendekraft();

		fail("DimensionerendeKraftEjDefineretException ej indtruffet");
	}

	@Test(expected = LaengdeEjDefineretException.class)
	public void testLaengdeNulltest()
			throws DimensionerendeKraftEjDefineretException, erUnderFejlgraenseException, LaengdeEjDefineretException, NegativKgException {
		PTECalculatorController calc = new PTECalculatorControllerImpl();

		calc.angivVaegt(10, Enhed.KG);
		calc.beregnBoejningsMoment();

		fail("LaengdeEjDefineretException ej indtruffet");
	}

}
