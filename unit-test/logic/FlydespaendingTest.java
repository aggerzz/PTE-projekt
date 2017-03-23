package logic;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.FlydeSpaendingEjDefineretException;

public class FlydespaendingTest {
	
	@Test
	public void testFlydespaendingForPositiv() throws FlydeSpaendingEjDefineretException {
		FlydeSpaending f = new FlydeSpaendingImpl();
		
		f.angivFlydeSpaending(355);
		
		assertEquals(355, f.getFlydeSpaending(), 0.001);
		
		
		
	}

	@Test (expected = FlydeSpaendingEjDefineretException.class)
	public void testFlydespaendingForNegativ() throws FlydeSpaendingEjDefineretException {
		FlydeSpaending f = new FlydeSpaendingImpl();
		
		f.angivFlydeSpaending(0);
		
		fail("FlydeSpaendingEjDefineretException ej kastet");
	}
	
	@Test
	public void testFlydespaending()  {
		FlydeSpaending f = new FlydeSpaendingImpl();
		
		assertEquals(Double.NaN, f.getFlydeSpaending(), 0.001);
		
		
	}
	

}
