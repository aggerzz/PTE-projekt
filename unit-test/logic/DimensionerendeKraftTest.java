package logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.NegativKgException;

public class DimensionerendeKraftTest {

	@Test
	public void testDimensionerendeKraftForPositiv() throws DimensionerendeKraftEjDefineretException, NegativKgException {
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		
		fdim.setNewton(9.816);
		fdim.setVaegt(495, Enhed.KG );
		

		
		double fdimINewton = fdim.getNewton();
		assertEquals(4858.92, fdimINewton , 0.001);
	}
	@Test (expected = DimensionerendeKraftEjDefineretException.class)
	public void TestDimensionerendeKraftForNegativ() throws DimensionerendeKraftEjDefineretException, NegativKgException {
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		
		fdim.setNewton(9.816);
		fdim.setVaegt(0, Enhed.KG );
		
		fail("DimensionerendeKraftEjDefineretException ej kastet");
		
		
		
		
	}
	
	@Test
	public void testDimensionerendeKraft() {
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		
		assertEquals(Double.NaN, fdim.getNewton(), 0.001);

	}

}
