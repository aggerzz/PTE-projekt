package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.ErOverFejlGraenseException;
import exceptions.NegativKgException;
import exceptions.VinkelEjDefineretException;
import exceptions.erUnderFejlgraenseException;
import logic.Dimensionerendekraft;
import logic.DimensionerendekraftImpl;
import logic.Enhed;
import logic.Normalkraft;
import logic.NormalkraftImpl;
import logic.PTECalculatorController;
import logic.PTECalculatorControllerImpl;
import logic.Tvaerkraft;
import logic.TvaerkraftImpl;
import logic.Vinkel;
import logic.VinkelImpl;

public class OC3Test {
	

	
	@Test(expected=erUnderFejlgraenseException.class)
	public void testNegativVinkelGrader() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, erUnderFejlgraenseException, ErOverFejlGraenseException, NegativKgException{
		Normalkraft fn = new NormalkraftImpl();
		Vinkel vinkel = new VinkelImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		boolean godNewton = false;
		vinkel.setGrader(-1);
		vinkel.setMaaltTilLodret(false);
		fdim.setVaegt(100, Enhed.KG);;
		double newton = fn.getNewton();
		System.out.println(newton);
		if(0<=newton){
			godNewton = true;
		}else{
			godNewton = false;
		}
		
		assertTrue(godNewton);
//		assertTrue(vinkel.erUnderFejlgraense);
		fail("underFejlGr�nse ej lavet");
		
	}
	
	@Test
	public void testBeregningAfNormalkraftKorrekt() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, erUnderFejlgraenseException, ErOverFejlGraenseException, NegativKgException{
		Normalkraft fn = new NormalkraftImpl();
		Vinkel vinkel = new VinkelImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		
		vinkel.setGrader(1);
		vinkel.setMaaltTilLodret(false);
		fdim.setVaegt(100, Enhed.KG);
		fn.angivDimensionerendekraft(fdim);
		fn.angivVinkel(vinkel);
		assertEquals(17.131, fn.getNewton(), 0.001);
		
	}


	
	@Test (expected = ErOverFejlGraenseException.class)
	public void testVinkelOverMaxgraense() throws erUnderFejlgraenseException, ErOverFejlGraenseException{
		Vinkel vinkel = new VinkelImpl();
		
		vinkel.setGrader(181);
		vinkel.setMaaltTilLodret(false);
		
		
		fail("ErOverFejlGraenseException ej lavet");
	}
	@Test
	public void testMaaltTilLodretkorrekt() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, erUnderFejlgraenseException, ErOverFejlGraenseException, NegativKgException{
		Normalkraft fn = new NormalkraftImpl();
		Vinkel vinkel = new VinkelImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		
		vinkel.setGrader(1);
		vinkel.setMaaltTilLodret(true);
		fdim.setVaegt(100, Enhed.KG);
		fn.angivDimensionerendekraft(fdim);
		fn.angivVinkel(vinkel);
		double newton =fn.getNewton();
		
		assertEquals(981.45, newton, 0.1);
	}
	
	@Test
	public void test45GraderSammenligningTilTvaerkraft() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, erUnderFejlgraenseException, ErOverFejlGraenseException, NegativKgException{
		Normalkraft fn = new NormalkraftImpl();
		Tvaerkraft ft = new TvaerkraftImpl();
		Vinkel vinkel = new VinkelImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		
		vinkel.setGrader(45);
		vinkel.setMaaltTilLodret(false);
		fdim.setVaegt(100, Enhed.KG);
		fn.angivDimensionerendekraft(fdim);
		fn.angivVinkel(vinkel);
		ft.angivDimensionerendekraft(fdim);
		ft.angivVinkel(vinkel);
		assertEquals(ft.getNewton() , fn.getNewton(), 0.001);
		
	}
	@Test (expected=erUnderFejlgraenseException.class)
	public void testvaegtSatTil0Kg() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, erUnderFejlgraenseException, ErOverFejlGraenseException, NegativKgException{
		PTECalculatorController calc = new PTECalculatorControllerImpl();
		
		calc.angivVaegt(0, Enhed.KG);
		
		fail("vægtUnderNormalgrænse ej lavet");
	}
	
	
}
