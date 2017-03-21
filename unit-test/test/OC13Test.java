package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.erUnderFejlgraenseException;
import logic.Dimensionerendekraft;
import logic.DimensionerendekraftImpl;
import logic.Enhed;

public class OC13Test {

	@Test // (expected=det kører
	public void testkorrektudregning() throws DimensionerendeKraftEjDefineretException, erUnderFejlgraenseException {
		Laengde2 l2 = new Laengde2Impl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		Boejningsmoment mb = new BoejningsmomentImpl(); // TODO talpas med logic
														// (CM)

		l2.setMm(20);
		fdim.setVaegt(60, Enhed.NEWTON);
		mb.angivDimensionerendekraft(fdim);
		mb.angivLaengde2(l2);

		assertEquals(1200, mb.getNewton(), 0.001);
	}

	@Test(expected = DimensionerendeKraftEjDefineretException.class)
	public void testkorrektudregning2() throws DimensionerendeKraftEjDefineretException, erUnderFejlgraenseException {
		Laengde2 lTV = new Laengde2Impl();
		Boejningsmoment mb = new BoejningsmomentImpl(); // TODO talpas med logic
														// (CM)
		lTV.setMm(10);
		mb.angivLength(lTV);

		mb.getNewton();
		fail();
	}

	@Test(expected = Laengde2EjDefineretException.class)
	public void testkorrektudregning3() throws DimensionerendeKraftEjDefineretException, erUnderFejlgraenseException {
		Boejningsmoment mb = new BoejningsmomentImpl(); // TODO talpas med logic
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		// (CM)
		fdim.setVaegt(60, Enhed.NEWTON);
		mb.angivDimensionerendekraft(fdim);
		mb.getNewton();
		fail();
	}

}
