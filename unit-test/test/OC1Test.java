package test;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.NegativKgException;
import logic.Dimensionerendekraft;
import logic.DimensionerendekraftImpl;
import logic.Enhed;

public class OC1Test {

	@Test (expected = NegativKgException.class)
	public void test1AngivNegativKg() throws NegativKgException {
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		fdim.setVaegt(-1, Enhed.KG);
		
		fail("NegativKgException ej kastet");
		
	}
	@Test (expected = NegativKgException.class)
	public void test2Angiv0Kg() throws NegativKgException {
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		fdim.setVaegt(0, Enhed.KG);
		
		fail("NegativKgException ej kastet");
		
	}
	@Test
	public void test3Angiv1Kg() throws NegativKgException  {
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		fdim.setVaegt(1, Enhed.KG);
		
		double fdimINewton = fdim.getNewton();
		assertEquals(9.816, fdimINewton , 0.001);
		
	}
	@Test
	public void test4Angiv1Gram() throws NegativKgException  {
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		fdim.setVaegt(1, Enhed.GRAM);
		
		double fdimINewton = fdim.getNewton();
		assertEquals(0.009816, fdimINewton , 0.001);
		
	}
	@Test
	public void test5Angiv1Ton() throws NegativKgException  {
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		fdim.setVaegt(1, Enhed.TON);
		
		double fdimINewton = fdim.getNewton();
		assertEquals(9816, fdimINewton , 0.001);
	}
}
