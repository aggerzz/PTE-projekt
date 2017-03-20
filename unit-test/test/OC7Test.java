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
		
		Tvaerkraft ft = new TvaerkraftImpl();
		Areal a = new ArealImpl();
		ForskydningsSpaendning tau = new ForskydningsSpaendningImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		Vinkel vinkel = new VinkelImpl();
		
//		vinkel.setGrader(55);
//		vinkel.setMaaltTilLodret(true);		
		ft.setFtNewton(500);				
//		ft.angivDimensionerendekraft(fdim);
//		ft.angivVinkel(vinkel);	
		tau.angivTvaerkraft(ft);
		tau.angivAreal(a);
		a.setMm2(50);
				
		assertEquals(8.1916, tau.getNmm2(), 0.001);
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

}
