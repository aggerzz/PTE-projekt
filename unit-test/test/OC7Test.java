package test;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.ArealEjDefineretException;
import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.NegativArealException;
import exceptions.NormalkraftEjDefineretException;
import exceptions.VinkelEjDefineretException;
import exceptions.erUnderFejlgraenseException;
import logic.Areal;
import logic.ArealImpl;
import logic.Dimensionerendekraft;
import logic.DimensionerendekraftImpl;
import logic.ForskydningsSpaendning;
import logic.ForskydningsSpaendningImpl;
import logic.Normalkraft;
import logic.NormalkraftImpl;
import logic.Tvaerkraft;
import logic.TvaerkraftImpl;
import logic.Vinkel;
import logic.VinkelImpl;

public class OC7Test {

	@Test
	public void testberegnForskydningsspaendning() throws NegativArealException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, erUnderFejlgraenseException {
		
		Tvaerkraft ft = new TvaerkraftImpl();
		Areal a = new ArealImpl();
		ForskydningsSpaendning tau = new ForskydningsSpaendningImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		Vinkel vinkel = new VinkelImpl();
		
		vinkel.setGrader(55);
		vinkel.setMaaltTilLodret(true);		
		ft.setFtNewton(500);				
		ft.angivDimensionerendekraft(fdim);
		ft.angivVinkel(vinkel);	
		a.setMm2(50);
		
		assertEquals(8.1916, tau.beregnForskydningsspaendning(), 0.001);
	}
	@Test(expected=ArealEjDefineretException.class)
	public void tauArealEjDefineretException() throws ArealEjDefineretException, erUnderFejlgraenseException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException{
		Tvaerkraft ft = new TvaerkraftImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		Vinkel vinkel = new VinkelImpl();
		
		vinkel.setGrader(55);
		vinkel.setMaaltTilLodret(true);		
		ft.setFtNewton(500);				
		ft.angivDimensionerendekraft(fdim);
		ft.angivVinkel(vinkel);	
		
		fail("ArealEjDefineretException ej kastet");		
	}
	
	@Test(expected=NormalkraftEjDefineretException.class)
	public void tauNewtonEjDefineretException() throws NormalkraftEjDefineretException, erUnderFejlgraenseException, NegativArealException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException{
		Tvaerkraft ft = new TvaerkraftImpl();
		Areal a = new ArealImpl();
		ForskydningsSpaendning tau = new ForskydningsSpaendningImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		Vinkel vinkel = new VinkelImpl();
		
		vinkel.setGrader(55);
		vinkel.setMaaltTilLodret(true);						
		ft.angivDimensionerendekraft(fdim);
		ft.angivVinkel(vinkel);	
		a.setMm2(50);
		
		fail("NewtonEjDefineretException ej kastet");
	}	

}
