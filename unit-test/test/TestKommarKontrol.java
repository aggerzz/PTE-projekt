package test;

import static org.junit.Assert.*;

import org.junit.Test;

import presentation.KommaKontrol;

public class TestKommarKontrol {

	@Test
	public void testKommaKontrol(){
		KommaKontrol kontrol = new KommaKontrol();
		
		assertEquals("1.001",kontrol.kontrol("1,001"));
		assertEquals("1.001",kontrol.kontrol("1,,,,,,,,,,,,001"));
		
		
	}

}
