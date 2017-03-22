package test;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.NegativArealException;
import exceptions.erUnderFejlgraenseException;
import logic.Enhed;
import presentation.FrontPage;
import presentation.FrontPageMediator;

public class TestKommaereImpl implements TestKommaere {
	FrontPageMediator fpm = FrontPage.frontPageMediator;
	
	FrontPage fp = new FrontPage();
	
	@Test
	public void testLodretVinkel() {
		
		fpm.getWeightValueTextField().setText("100");
		fpm.getHorizontalAngleText().setText("1,001"); //vi er kommet til at bytte rundt på Horizontal og Vertical, Horizontal er nu lodret.
		
		try {
			fpm.getObserver().getPteCalc().angivVaegt(Double.parseDouble(fpm.getWeightValueTextField().getText()), Enhed.KG);
		} catch (NumberFormatException | DimensionerendeKraftEjDefineretException e1) {
		}
		try{
			fpm.getObserver().getPteCalc().angivVinkel(Double.parseDouble(fpm.getHorizontalAngleText().getText()), true);
		}
		catch(DimensionerendeKraftEjDefineretException|erUnderFejlgraenseException e){
		}
		assertEquals("981,450",fpm.getFnTextField().getText() );
		assertEquals("17,148",fpm.getFtTextField().getText() );
		
		fail("lodret vinkel fuckede op");
	}

	@Test
	public void testVandretVinkel() {
		fpm.getVerticalAngleText().setText("1,001");
		fpm.getWeightValueTextField().setText("100");
		
		try{
			fpm.getObserver().getPteCalc().angivVaegt(Double.parseDouble(fpm.getWeightValueTextField().getText()), Enhed.KG);
		}
		catch(DimensionerendeKraftEjDefineretException e){
		}
		try{
			fpm.getObserver().getPteCalc().angivVinkel(Double.parseDouble(fpm.getVerticalAngleText().getText()), false);
		}
		catch(DimensionerendeKraftEjDefineretException|erUnderFejlgraenseException e){
		}
		assertEquals("17,148",fpm.getFnTextField().getText() );
		assertEquals("981,450", fpm.getFtTextField().getText());
		fail("vandret vinkel fuckede op");
	}

	@Test
	public void testVaegt() {
		fpm.getWeightValueTextField().setText("1,001");
		
		try{
			fpm.getObserver().getPteCalc().angivVaegt(Double.parseDouble(fpm.getWeightValueTextField().getText()), Enhed.KG);
		}
		catch(DimensionerendeKraftEjDefineretException e){
			e.printStackTrace();
		}
		assertEquals("9,826", fpm.getFdimTextField().getText());
		fail("vaegten fuckede op");
	}

	@Test
	public void testArealInput() {
		fpm.getVerticalAngleText().setText("30");
		fpm.getWeightValueTextField().setText("100");
		fpm.getArealText().setText("1,001");
		
		try{
			fpm.getObserver().getPteCalc().angivVaegt(Double.parseDouble(fpm.getWeightValueTextField().getText()), Enhed.KG);
		}
		catch(DimensionerendeKraftEjDefineretException e){
		}
		try{
			fpm.getObserver().getPteCalc().angivVinkel(Double.parseDouble(fpm.getVerticalAngleText().getText()), false);
		}
		catch(DimensionerendeKraftEjDefineretException|erUnderFejlgraenseException e){
		}
		try{
			fpm.getObserver().getPteCalc().angivAreal(Double.parseDouble(fpm.getArealText().getText()));
		}
		catch(NegativArealException e){
		}
		
		assertEquals("849,241", fpm.getTauTextField().getText());
		assertEquals("490,310", fpm.getSigmaNTextField().getText());
		
		fail("test areal input fuckede op");

	}

	@Test
	public void testLaengdeInput() {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testDetDerEInput() {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testFlydeSpaending() {
		// TODO Auto-generated method stub
		
	}

}
