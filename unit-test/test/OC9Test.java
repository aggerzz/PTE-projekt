package test;

import static org.junit.Assert.fail;

import org.junit.Test;

import logic.Referencespaending;
import logic.ReferencespaendingImpl;

public class OC9Test {

	@Test(expected = ReferencespaendingEjDefineretException.class)
	public void Referencespaendingtest() throws ReferencespaendingEjDefineretException {
		Referencespaending ref = new ReferencespaendingImpl();
		Flydespaending fly = new FlydespaendingImpl();
		Sikkerhedsfaktor sk = new SikkerhedsfaktorImpl();

		fly.setNmm2(0.675);

		fail("ReferencespaendingEjDefineretException ej kastet");
	}

	@Test(expected = FlydespaendingEjDefineretException.class)
	public void Flydespaendingtest() throws FlydespaendingEjDefineretException {
		Referencespaending ref = new ReferencespaendingImpl();
		Flydespaending fly = new FlydespaendingImpl();
		Sikkerhedsfaktor sk = new SikkerhedsfaktorImpl();

		ref.setNmm2(40);

		fail("FlydespaendingEjDefineretException ej kastet");
	}

	@Test
	public void Sikkerhedsfaktortest()
			throws ReferencespaendingEjDefineretException, FlydespaendingEjDefineretException {
		Referencespaending ref = new ReferencespaendingImpl();
		Flydespaending fly = new FlydespaendingImpl();
		Sikkerhedsfaktor sk = new SikkerhedsfaktorImpl();

		fly.setNmm2(0.675);
		ref.setNmm2(40);

		assertEquals(2.001, sk.getvaerdi(), 0.001);

	}

	@Test
	public void SikkerhedsfaktorMedMellemregningtest()
			throws ReferencespaendingEjDefineretException, FlydespaendingEjDefineretException {
		Referencespaending ref = new ReferencespaendingImpl();
		Flydespaending fly = new FlydespaendingImpl();
		Sikkerhedsfaktor sk = new SikkerhedsfaktorImpl();

		fly.setNmm2(0.675);
		ref.setNmm2(40);

		assertEquals(2.001, sk.getvaerdi(), 0.001);
		assertEquals("sf = fly / ref " + "\n" + "0.675/40 = 2.001", sk.getMellemregning());

	}
}
