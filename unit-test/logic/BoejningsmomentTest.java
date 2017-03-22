package logic;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import org.junit.Test;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.LaengdeEjDefineretException;
import logic.BoejningsMoment;
import logic.BoejningsMomentImpl;
import logic.Dimensionerendekraft;
import logic.Enhed;
import logic.Laengde;




public class BoejningsmomentTest {

	private class LaengdeMock implements Laengde {

		@Override
		public void angivLaengde(double l2) {
		}

		@Override
		public double getLaengde() {
			// TODO Auto-generated method stub
			return 50;
		}

	}
	private class DimensionerendekraftMock implements Dimensionerendekraft {

		@Override
		public double getNewton() {

			return 50;
		}

		@Override
		public void setKg(double kg) {
		}

		@Override
		public double getKg() {
			return 0;
		}

		@Override
		public void setMellemRegning(String mellemRegning) {
		}

		@Override
		public String getMellemRegning() {
			return null;
		}

		@Override
		public double setNewton(double newton) {
			return 0;
		}

		@Override
		public void setVaegt(double vaegt, Enhed enhed) {
		}

		@Override
		public boolean erVaegtNormal() {
			return false;
		}

	}

	@Test
	public void testBoejningsmomentForPositivDimensionerendeKraftOgPositivLaengde() throws LaengdeEjDefineretException, DimensionerendeKraftEjDefineretException {
		BoejningsMoment bm = new BoejningsMomentImpl();
		Laengde l2 = new LaengdeMock();
		Dimensionerendekraft fdim = new DimensionerendekraftMock(); 
		
		
		
		bm.angivLaengde(l2);
		bm.angivDimensionerendeKraft(fdim);
		
		
		double bmINmm =  bm.getBoejningsMoment();
		assertEquals(5, bmINmm , 0.001);
		
	}
	@Test (expected = DimensionerendeKraftEjDefineretException.class)
	public void testBoejningsmomentForDimensionerendeKraftEjDefineret() throws DimensionerendeKraftEjDefineretException, LaengdeEjDefineretException{
		
		BoejningsMoment bm = new BoejningsMomentImpl();
		Laengde l2 = new LaengdeMock();
		
		
		
		bm.angivLaengde(l2);
		bm.getBoejningsMoment();
		fail("DimensionerendeKraftEjDefineretException ej kastet");
		
	}
	@Test (expected = LaengdeEjDefineretException.class)
	public void testBoejningsmomentForLaengdeEjDefineret() throws DimensionerendeKraftEjDefineretException, LaengdeEjDefineretException{
		BoejningsMoment bm = new BoejningsMomentImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftMock();
		
		
		
		bm.angivDimensionerendeKraft(fdim);
		
		bm.getBoejningsMoment();
		fail("LaengdeEjDefineretException ej kastet"); 
		
		
		
		
	}
	

}
