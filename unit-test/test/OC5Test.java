package test;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.ArealEjDefineretException;
import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.ErOverFejlGraenseException;
import exceptions.NegativArealException;
import exceptions.NormalkraftEjDefineretException;
import exceptions.NormalspaendingEjDefineretException;
import exceptions.VinkelEjDefineretException;
import exceptions.erUnderFejlgraenseException;
import logic.Areal;
import logic.ArealImpl;
import logic.Dimensionerendekraft;
import logic.Normalkraft;
import logic.NormalkraftImpl;
import logic.Normalspaending;
import logic.NormalspaendingImpl;
import logic.PTECalculatorController;
import logic.PTECalculatorControllerImpl;
import logic.Vinkel;
import logic.VinkelImpl;

public class OC5Test {
	
	@Test
	public void testBeregnSigmaNMedMellemregning() throws NegativArealException, DimensionerendeKraftEjDefineretException,
							VinkelEjDefineretException, NormalkraftEjDefineretException, NormalspaendingEjDefineretException {
		NormalkraftMock fn = new NormalkraftMock();
		Normalspaending sigmaN = new NormalspaendingImpl();
		Areal a = new ArealImpl();

		a.setMm2(1700);
		fn.getNewton();
		
		sigmaN.angivAreal(a);
		sigmaN.angivNormalkraft(fn);
		
		assertEquals(0.298762, sigmaN.getSigmaNmm2(), 0.001);
	}
	
	@Test(expected=ArealEjDefineretException.class)
	public void sigmaArealEjDefineretException() throws ArealEjDefineretException, erUnderFejlgraenseException{
		PTECalculatorController calc = new PTECalculatorControllerImpl();
		
		calc.getAreal();
		
		fail("ArealEjDefineretException ej kastet");		
	}
	
	@Test(expected=NormalkraftEjDefineretException.class)
	public void sigmaNewtonEjDefineretException() throws NormalkraftEjDefineretException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
		PTECalculatorController calc = new PTECalculatorControllerImpl();
		
		calc.getNormalkraft();
		
		fail("NormalkraftEjDefineretException ej kastet");
	}	
	
	
	
	
	
	
	
	
	private class NormalkraftMock implements Normalkraft{

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
			return 507.8954;
		}

		@Override
		public String getMellemregning() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setFnNewton(double fnNewton) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
