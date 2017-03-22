package logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
import exceptions.NegativHalvProfilhoejdeException;
import logic.HalvProfilhoejde;
import logic.HalvProfilhoejdeImpl;

public class HalvProfilhoejdeTest {

	@Test(expected = NegativHalvProfilhoejdeException.class)
	public void testHalvProfilHoejdeNaN() throws NegativHalvProfilhoejdeException {
		HalvProfilhoejde halvProfilHoejde = new HalvProfilhoejdeImpl();

		halvProfilHoejde.setMm(Double.NaN);

		fail("NegativHalvProfilhoejdeException Ej Lavet");
	}

	@Test(expected = NegativHalvProfilhoejdeException.class)
	public void testHalvProfilHoejdeNegativ() throws NegativHalvProfilhoejdeException {
		HalvProfilhoejde halvProfilHoejde = new HalvProfilhoejdeImpl();

		halvProfilHoejde.setMm(-10);

		fail("NegativHalvProfilhoejdeException Ej Lavet");
	}

	@Test
	public void testHalvProfilHoejdeKorrekt() throws NegativHalvProfilhoejdeException {
		HalvProfilhoejde halvProfilHoejde = new HalvProfilhoejdeImpl();

		halvProfilHoejde.setMm(20.45);

		assertEquals(20.45, halvProfilHoejde.getHalvProfilhoejde(), 0.01);
	}
	
	@Test
	public void testHalvProfilHoejdeGetErNaN() throws NegativHalvProfilhoejdeException {
		HalvProfilhoejde halvProfilHoejde = new HalvProfilhoejdeImpl();
//		System.out.println(halvProfilHoejde.getHalvProfilhoejde());
		assertEquals(Double.NaN, halvProfilHoejde.getHalvProfilhoejde(), 0.001);
	}
}
