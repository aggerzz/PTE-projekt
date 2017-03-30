package logic;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.LaengdeEjDefineretException;
import exceptions.NegativKgException;
import logic.BoejningsMoment;
import logic.BoejningsMomentImpl;
import logic.Dimensionerendekraft;
import logic.Enhed;
import logic.Laengde;




public class BoejningsmomentTest {
	
	
	private class DimensionerendekraftMock2 implements Dimensionerendekraft {

		@Override
		public double getNewton() {
			return 3083.6964;
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
		public void setVaegt(double vaegt, Enhed enhed)
				throws NegativKgException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean erVaegtNormal() {
			// TODO Auto-generated method stub
			return false;
		}

	}
	private class LaengdeMock2 implements Laengde {

		@Override
		public void angivLaengde(double l2) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public double getLaengde() throws LaengdeEjDefineretException {
			return 1034.16;
		}

	}

	@Test
	public void testMBMellemregning() throws LaengdeEjDefineretException, DimensionerendeKraftEjDefineretException {
		BoejningsMoment mb = new BoejningsMomentImpl();
		LaengdeMock2 l2 = new LaengdeMock2();
		DimensionerendekraftMock2 fdim = new DimensionerendekraftMock2(); 
		
		
		
		mb.angivLaengde(l2);
		mb.angivDimensionerendeKraft(fdim);
		mb.beregnBoejningsMoment();
		
		
		double bmINmm =  mb.getBoejningsMoment();
		assertEquals(3189035.469, bmINmm , 0.001);
		String mellemregning = "Fdim * l  = MB" + "\n"+ "3083,69640 * 1034,16000 = 3189035,46902" + "\n";
		assertEquals(mellemregning , mb.getBoejningsMomentMellemRegning());
	}
	
	
	
	
	
	
	

	private class LaengdeMock implements Laengde {

		@Override
		public void angivLaengde(double l2) {
		}

		@Override
		public double getLaengde() {
			// TODO Auto-generated method stub
			return 1400;
		}

	}
	private class DimensionerendekraftMock implements Dimensionerendekraft {

		@Override
		public double getNewton() {

			return 4858.92;
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
		LaengdeMock l2 = new LaengdeMock();
		DimensionerendekraftMock fdim = new DimensionerendekraftMock(); 
		
		
		
		bm.angivLaengde(l2);
		bm.angivDimensionerendeKraft(fdim);
		
		
		double bmINmm =  bm.getBoejningsMoment();
		assertEquals(6802488, bmINmm , 0.001);
		
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
