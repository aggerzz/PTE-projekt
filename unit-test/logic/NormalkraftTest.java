package logic;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.ErOverFejlGraenseException;
import exceptions.VinkelEjDefineretException;
import exceptions.erUnderFejlgraenseException;



public class NormalkraftTest {


	private class VinkelMockMedNormalVinkelMaaltTilLodret implements Vinkel {

		@Override
		public double getGrader() {
			return 1;
		}

		@Override
		public void setGrader(double grader) throws erUnderFejlgraenseException, ErOverFejlGraenseException {

		}

		@Override
		public boolean getMaaltTilLodret() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public void setMaaltTilLodret(boolean erMaaltTilLodret) {
			// TODO Auto-generated method stub

		}

	}

	private class VinkelMockMedNormalVinkelMaaltTilVandret implements Vinkel {

		@Override
		public double getGrader() {
			return 1;
		}

		@Override
		public boolean getMaaltTilLodret() {
			return false;
		}

		@Override public void setMaaltTilLodret(boolean erMaaltTilLodret) {}
		@Override public void setGrader(double grader) throws erUnderFejlgraenseException, ErOverFejlGraenseException {}

	}

	private class DimensionerendekraftMock implements Dimensionerendekraft {

		@Override
		public double getNewton() {
			return 100*9.816;
		}

//		@Override public void setKg(double kg) {}

		@Override
		public double getKg() {
			return 0;
		}

		@Override public void setMellemRegning(String mellemRegning) {}

		@Override
		public String getMellemRegning() {
			return null;
		}

		@Override
		public double setNewton(double newton) {
			return 0;
		}

		@Override public void setVaegt(double vaegt, Enhed enhed) {}

		@Override
		public boolean erVaegtNormal() {
			return false;
		}

	}

	@Test
	public void testNormalVinkelMaaltTilVandretOgPositivDimensionerendeKraft() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
		//set-up
		Normalkraft fn = new NormalkraftImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftMock();
		fn.angivDimensionerendekraft(fdim);
		Vinkel vinkel = new VinkelMockMedNormalVinkelMaaltTilVandret();
		fn.angivVinkel(vinkel);
		
		//execution
		double normaltkrafINewton = fn.getNewton();
		
		//assert
		assertEquals(17.131, normaltkrafINewton ,0.001);
	}
	@Test
	public void testNormalVinkelMaaltTilLodretOgPositivDimensionerendeKraft() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
	
		Normalkraft fn = new NormalkraftImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftMock();
		fn.angivDimensionerendekraft(fdim);
		Vinkel vinkel = new VinkelMockMedNormalVinkelMaaltTilLodret();
		fn.angivVinkel(vinkel);
		
		//execution
		double normaltkraftINewton = fn.getNewton();
		//assert
		assertEquals(981.45, normaltkraftINewton, 0.001);
	}
	@Test ( expected = VinkelEjDefineretException.class)
	public void testNullVinkelOgPositivDimensionerendeKraft() throws DimensionerendeKraftEjDefineretException, erUnderFejlgraenseException, VinkelEjDefineretException{
		Normalkraft fn = new NormalkraftImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftMock();
		fn.angivDimensionerendekraft(fdim);
		fn.getNewton();

		fail("VinkelEjDefineretException");
		
		
}
	@Test ( expected = DimensionerendeKraftEjDefineretException.class)
	public void testNormalVinkelOgDimensionerendeKraftErNull() throws DimensionerendeKraftEjDefineretException, erUnderFejlgraenseException, VinkelEjDefineretException{
		Normalkraft fn = new NormalkraftImpl();
		Vinkel vinkel = new VinkelMockMedNormalVinkelMaaltTilLodret();
		fn.angivVinkel(vinkel);
		fn.getNewton();
		fail("DimensionerendeKraftEjDefineretException");
		
		
}

}