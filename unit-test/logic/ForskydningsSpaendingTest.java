package logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import exceptions.ArealEjDefineretException;
import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.ForskydningsspaendingEjDefineretException;
import exceptions.NegativArealException;
import exceptions.TvaerkraftEjDefineretException;
import exceptions.VinkelEjDefineretException;

public class ForskydningsSpaendingTest {

	@Test(expected = ArealEjDefineretException.class)
	public void ArealEjDefineretExceptionTest()
			throws ForskydningsspaendingEjDefineretException, NegativArealException, ArealEjDefineretException,
			DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, TvaerkraftEjDefineretException {
		ForskydningsSpaendning tau = new ForskydningsSpaendningImpl();
		Areal a = new ArealImpl();
		a = null;
		tau.angivAreal(a);

		fail("ArealEjDefineretException kastet");

	}

	@Test(expected = NegativArealException.class)
	public void NegativArealExceptionTest()
			throws ForskydningsspaendingEjDefineretException, NegativArealException, ArealEjDefineretException,
			DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, TvaerkraftEjDefineretException {
		ForskydningsSpaendning tau = new ForskydningsSpaendningImpl();
		TvaerkraftMock3 ft = new TvaerkraftMock3();
		Areal mm2 = new ArealImpl();

		mm2.setMm2(-1);

		tau.angivTvaerkraft(ft);
		tau.angivAreal(mm2);

		fail("NegativArealException kastet");
	}

	@Test(expected = NegativArealException.class)
	public void NegativArealExceptionTest2()
			throws ForskydningsspaendingEjDefineretException, NegativArealException, ArealEjDefineretException,
			DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, TvaerkraftEjDefineretException {
		ForskydningsSpaendning tau = new ForskydningsSpaendningImpl();
		TvaerkraftMock4 ft = new TvaerkraftMock4();
		Areal mm2 = new ArealImpl();

		mm2.setMm2(0);

		tau.angivTvaerkraft(ft);
		tau.angivAreal(mm2);

		fail("NegativArealException kastet");
	}

	public void ForskydningsspaendingKorrekteResultatTest2()
			throws ForskydningsspaendingEjDefineretException, NegativArealException, ArealEjDefineretException,
			DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, TvaerkraftEjDefineretException {
		ForskydningsSpaendning tau = new ForskydningsSpaendningImpl();
		TvaerkraftMock5 ft = new TvaerkraftMock5();
		Areal mm2 = new ArealImpl();

		mm2.setMm2(1);
		ft.getNewton();

		tau.angivTvaerkraft(ft);
		tau.angivAreal(mm2);

		assertEquals(0.0, tau.getNmm2(), 0.001);
	}

	private class TvaerkraftMock3 implements Tvaerkraft {

		@Override
		public String getMellemregning() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void angivDimensionerendekraft(Dimensionerendekraft fdim)
				throws DimensionerendeKraftEjDefineretException {
			// TODO Auto-generated method stub

		}

		@Override
		public void angivVinkel(Vinkel vinkel) throws VinkelEjDefineretException {
			// TODO Auto-generated method stub

		}

		@Override
		public double getNewton() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
			// TODO Auto-generated method stub
			return 1;
		}

		@Override
		public void setFtNewton(double ftNewton) {
			// TODO Auto-generated method stub

		}

	}

	private class TvaerkraftMock4 implements Tvaerkraft {

		@Override
		public String getMellemregning() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void angivDimensionerendekraft(Dimensionerendekraft fdim)
				throws DimensionerendeKraftEjDefineretException {
			// TODO Auto-generated method stub

		}

		@Override
		public void angivVinkel(Vinkel vinkel) throws VinkelEjDefineretException {
			// TODO Auto-generated method stub

		}

		@Override
		public double getNewton() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
			// TODO Auto-generated method stub
			return 1;
		}

		@Override
		public void setFtNewton(double ftNewton) {
			// TODO Auto-generated method stub

		}

	}

	private class TvaerkraftMock5 implements Tvaerkraft {

		@Override
		public String getMellemregning() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void angivDimensionerendekraft(Dimensionerendekraft fdim)
				throws DimensionerendeKraftEjDefineretException {
			// TODO Auto-generated method stub

		}

		@Override
		public void angivVinkel(Vinkel vinkel) throws VinkelEjDefineretException {
			// TODO Auto-generated method stub

		}

		@Override
		public double getNewton() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void setFtNewton(double ftNewton) {
			// TODO Auto-generated method stub

		}

	}

}
