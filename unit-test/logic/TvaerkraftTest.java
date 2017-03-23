package logic;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.ErOverFejlGraenseException;
import exceptions.NegativKgException;
import exceptions.TvaerkraftEjDefineretException;
import exceptions.VinkelEjDefineretException;
import exceptions.erUnderFejlgraenseException;


public class TvaerkraftTest {

	private class VinkelMock implements Vinkel {

		@Override
		public double getGrader() {
			// TODO Auto-generated method stub
			return 84;
		}

		@Override
		public void setGrader(double grader) throws erUnderFejlgraenseException, ErOverFejlGraenseException {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean getMaaltTilLodret() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void setMaaltTilLodret(boolean erMaaltTilLodret) {
			// TODO Auto-generated method stub

		}

	}

	private class DimensionerendekraftMock implements Dimensionerendekraft {

		@Override
		public double getNewton() {
			// TODO Auto-generated method stub
			return 4858.92;
		}

		@Override
		public double getKg() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void setMellemRegning(String mellemRegning) {
			// TODO Auto-generated method stub

		}

		@Override
		public String getMellemRegning() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public double setNewton(double newton) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void setVaegt(double vaegt, Enhed enhed) throws NegativKgException {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean erVaegtNormal() {
			// TODO Auto-generated method stub
			return false;
		}

	}

	@Test
	public void testTvaerkraftForPositivDimensionerendekraftOgPositivVinkel()
			throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException,
			TvaerkraftEjDefineretException {
		Tvaerkraft ft = new TvaerkraftImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftMock();
		Vinkel grader = new VinkelMock();
		
		ft.angivDimensionerendekraft(fdim);
		ft.angivVinkel(grader);
		
		
		double ftINewton = ft.getNewton();
		assertEquals(4832.302, ftINewton , 0.001);
		
	}
	@Test (expected = DimensionerendeKraftEjDefineretException.class)
	public void testTvaerkraftForDimensionerendekraftEjDefineret() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, TvaerkraftEjDefineretException{
		Tvaerkraft ft = new TvaerkraftImpl();
		Vinkel grader = new VinkelMock();
		
		ft.angivVinkel(grader);
		ft.getNewton();
		fail("DimensionerendeKraftEjDefineretException ej kastet"); 
	}
	@Test (expected = VinkelEjDefineretException.class)
	public void testTvaerkraftForVinkelEjDefineret() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, TvaerkraftEjDefineretException{
		Tvaerkraft ft = new TvaerkraftImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftMock();
		
		ft.angivDimensionerendekraft(fdim);
		ft.getNewton();
		fail("VinkelEjDefineretException ej kastet"); 
		
		
	}

}
