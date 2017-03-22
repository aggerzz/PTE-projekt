package logic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.ErOverFejlGraenseException;
import exceptions.NegativArealException;
import exceptions.NegativKgException;
import exceptions.NormalkraftEjDefineretException;
import exceptions.NormalspaendingEjDefineretException;
import exceptions.VinkelEjDefineretException;
import exceptions.erUnderFejlgraenseException;
import logic.Areal;
import logic.ArealImpl;
import logic.Dimensionerendekraft;
import logic.DimensionerendekraftImpl;
import logic.Enhed;
import logic.Normalkraft;
import logic.NormalkraftImpl;
import logic.Normalspaending;
import logic.NormalspaendingImpl;
import logic.Vinkel;
import logic.VinkelImpl;

public class BeregnSigmaN {
	Normalspaending sigmaN;
	Areal a;
	Normalkraft fn;
	Vinkel vinkel;
	Dimensionerendekraft fdim;

	@Test
	public void testSigmaN() throws NegativKgException {
		sigmaN = new NormalspaendingImpl();
		a = new ArealImpl();
		fn = new NormalkraftImpl();
		vinkel = new VinkelImpl();
		fdim = new DimensionerendekraftImpl();

		setVaerdier(a, 100, vinkel, 44, false, fdim, 100, fn);
		testMellemRegning(a, fn, sigmaN);
		testExceptions(a, fn, sigmaN);
	}

	public void setVaerdier(Areal a, double Mm2, Vinkel vinkel, double grader, boolean maaltTilLodret,
			Dimensionerendekraft fdim, double kg, Normalkraft fn) throws NegativKgException {
		try {
			a.setMm2(Mm2);
		} catch (NegativArealException e1) {
			e1.printStackTrace();
		}
			try {
				vinkel.setGrader(grader);
			} catch (erUnderFejlgraenseException | ErOverFejlGraenseException e1) {
				e1.printStackTrace();
			}
		
		vinkel.setMaaltTilLodret(maaltTilLodret);
		try {
			fn.angivVinkel(vinkel);
		} catch (VinkelEjDefineretException e) {
			e.printStackTrace();
		}
		fdim.setVaegt(kg, Enhed.KG);
		try {
			fn.angivDimensionerendekraft(fdim);
		} catch (DimensionerendeKraftEjDefineretException e) {
			e.printStackTrace();
		}
	}

	public void testMellemRegning(Areal a, Normalkraft fn, Normalspaending sigmaN) {
		double fnNewton;
		double aMm2;
		try {
			sigmaN.angivAreal(a);
		} catch (NegativArealException e1) {
			e1.printStackTrace();
		}
		try {
			sigmaN.angivNormalkraft(fn);
		} catch (NormalkraftEjDefineretException e1) {
			e1.printStackTrace();
		}

		try {
			sigmaN.getSigmaNmm2();
			fnNewton = fn.getNewton();
			aMm2 = a.getMm2();
			assertEquals("Fn\t	 /\t	A " + "\t	=\t	SigmaN" + "\n" + fnNewton + "\t	/\t	" + aMm2 + "\t	=\t	"
					+ sigmaN.getSigmaNmm2() + "\n", sigmaN.getMellemregning());

		} catch (DimensionerendeKraftEjDefineretException | VinkelEjDefineretException
				| NormalspaendingEjDefineretException e) {
			e.printStackTrace();
		}

	}

	public void testExceptions(Areal a, Normalkraft fn, Normalspaending sigmaN) {
		try {
			testNegativArealException();
		} catch (NegativArealException e) {
		}
		try {
			testNormalKraftEjDefineretException();
		} catch (NormalkraftEjDefineretException e) {
		}
	}

	@Test(expected = NullPointerException.class)
	public void testNormalKraftEjDefineretException() throws NormalkraftEjDefineretException {
		sigmaN.angivNormalkraft(new NormalkraftImpl());
	}

	@Test(expected = NegativArealException.class)
	public void testNegativArealException() throws NegativArealException {
		a = new ArealImpl();
		a.setMm2(-1);

	}
}