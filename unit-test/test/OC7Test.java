package test;

import static org.junit.Assert.*;

import org.junit.Test;
import exceptions.ArealEjDefineretException;
import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.ForskydningsspaendingEjDefineretException;
import exceptions.NegativArealException;
import exceptions.TvaerkraftEjDefineretException;
import exceptions.VinkelEjDefineretException;
import exceptions.erUnderFejlgraenseException;
import logic.Areal;
import logic.ArealImpl;
import logic.Dimensionerendekraft;
import logic.DimensionerendekraftImpl;
import logic.ForskydningsSpaendning;
import logic.ForskydningsSpaendningImpl;
import logic.Tvaerkraft;
import logic.TvaerkraftImpl;
import logic.Vinkel;
import logic.VinkelImpl;

public class OC7Test {

	@Test
	public void testberegnForskydningsspaendning() throws NegativArealException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, erUnderFejlgraenseException, ForskydningsspaendingEjDefineretException, ArealEjDefineretException, TvaerkraftEjDefineretException {
		
		TvaerkraftMock ft = new TvaerkraftMock();
		Areal a = new ArealImpl();
		ForskydningsSpaendning tau = new ForskydningsSpaendningImpl();
		
		ft.getNewton();				
		a.setMm2(1700);
		
		tau.angivAreal(a);
		tau.angivTvaerkraft(ft);
		
		assertEquals(2.842531, tau.getNmm2(), 0.001);
	}
	
	@Test(expected=ForskydningsspaendingEjDefineretException.class)
	public void tauArealEjDefineretException() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, ForskydningsspaendingEjDefineretException, ArealEjDefineretException, TvaerkraftEjDefineretException {
		ForskydningsSpaendning tau = new ForskydningsSpaendningImpl();
		Tvaerkraft ft = new TvaerkraftImpl();
	
		ft.setFtNewton(500);
		tau.angivTvaerkraft(ft);
		tau.getNmm2();
		
		fail("ForskydningsspaendingEjDefineretException ej kastet");		
	}
	
	@Test(expected=ForskydningsspaendingEjDefineretException.class)
	public void tauNewtonEjDefineretException() throws NegativArealException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, ForskydningsspaendingEjDefineretException, ArealEjDefineretException, TvaerkraftEjDefineretException {
		Areal a = new ArealImpl();
		ForskydningsSpaendning tau = new ForskydningsSpaendningImpl();
		
		a.setMm2(50);		
		tau.angivAreal(a);
		tau.getNmm2();		
		
		fail("ForskydningsspaendingEjDefineretException ej kastet");
	}	
	
	
	
	
	
	
	
	private class TvaerkraftMock implements Tvaerkraft{

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
			return 4832.302;
		}

		@Override
		public void setFtNewton(double ftNewton) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
