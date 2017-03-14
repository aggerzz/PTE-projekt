package application;

import static org.junit.Assert.*;

import org.junit.Test;

public class UC2JunitTest {
	double g ; //g = grader
	boolean MTL; //MTL = MåltTilLodret
	
	
	
	@Test
	public void test() {
		System.out.println("Test af UC2");
		assertEquals(forventetResultat,beregnetResultat());
		
	}

}
