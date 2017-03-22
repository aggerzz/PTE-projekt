package logic;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.InertimomentEjDefineretException;
import exceptions.NegativInertimomentException;
import logic.Inertimoment;
import logic.InertimomentImpl;

public class InertimomentTest {

	@Test
	public void setInertimomenttest() throws InertimomentEjDefineretException, NegativInertimomentException  {
		
		Inertimoment i = new InertimomentImpl();
		
		i.setMm4(20);
		
		assertEquals(20, i.getInertimoment(), 0.001);
		
		
	}
	@Test 
	public void testInertimomentEjDefineret() {
		Inertimoment i = new InertimomentImpl(); 
		
		double nmm4 = i.getInertimoment();
		
		assertTrue(Double.isNaN(nmm4));
		
	}
	@Test (expected =NegativInertimomentException.class)
	public void testNegativInertimomentGiverException() throws NegativInertimomentException {
		Inertimoment i = new InertimomentImpl(); 
		i.setMm4(-5);
		
		fail("NegativInertimomentException ej kastet"); 
		
	}
	

}
