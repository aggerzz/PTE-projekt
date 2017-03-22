package test;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.HalvProfilhoejdeEjDefineretException;
import exceptions.NegativHalvProfilhoejdeException;
import logic.HalvProfilhoejde;
import logic.HalvProfilhoejdeImpl;

public class HalvProfilhoejdeTest {

	@Test
	public void setHalvProfilhoejdeTest()
			throws NegativHalvProfilhoejdeException, HalvProfilhoejdeEjDefineretException {

		HalvProfilhoejde e = new HalvProfilhoejdeImpl();

		e.setMm(10);

		assertEquals(10, e.getHalvProfilhoejde(), 0.001);
	}

	@Test
	public void HalvProfilhoejdeEjDefineret() {
		
		HalvProfilhoejde e = new HalvProfilhoejdeImpl();

		double mm = e.getHalvProfilhoejde();

		assertTrue(Double.isNaN(mm));
	}

	@Test(expected = NegativHalvProfilhoejdeException.class)
	public void NegativHalvProfilhoejdeGiverException() throws NegativHalvProfilhoejdeException {
		
		HalvProfilhoejde e = new HalvProfilhoejdeImpl();
		
		e.setMm(-2);

		fail("NegativHalvProfilhoejdeException ej kastet");

	}

}
