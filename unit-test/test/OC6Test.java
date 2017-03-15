package test;
import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.NegativArealException;
import logic.Areal;
import logic.ArealImpl;

public class OC6Test {

	@Test (expected = NegativArealException.class)
	public void test0ArealGiverNegativ() throws NegativArealException {
		Areal a = new ArealImpl();

		a.setMm2(0);

		fail("NegativArealException ej kastet");
		
		
	}
	
	@Test
	public void test1AngivAreal() {
		
		Areal a = new ArealImpl(); 
		
		a.setMm2(0.001);
		assertEquals(0.001, a.getMm2() , 0.001); 
		
	}
	

}
