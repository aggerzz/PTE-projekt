package test;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.FlydeSpaendingEjDefineretException;
import exceptions.ForskydningsspaendingEjDefineretException;
import exceptions.NormalspaendingEjDefineretException;
import exceptions.ReferenceSpaendingEjDefineretException;
import exceptions.SikkerhedsFaktorEjDefineretException;
import exceptions.angivBoejningsspaendingEjDefineretException;
import logic.Boejningsspaending;
import logic.FlydeSpaending;
import logic.FlydeSpaendingImpl;
import logic.ForskydningsSpaendning;
import logic.Normalspaending;
import logic.PTECalculatorController;
import logic.PTECalculatorControllerImpl;
import logic.Referencespaending;
import logic.ReferencespaendingImpl;
import logic.SikkerhedsFaktor;
import logic.SikkerhedsFaktorImpl;

public class OC9Test {

	@Test(expected = ReferenceSpaendingEjDefineretException.class)
	public void Referencespaendingtest() throws ReferenceSpaendingEjDefineretException, FlydeSpaendingEjDefineretException {
		PTECalculatorController calc = new PTECalculatorControllerImpl();
		
		calc.getSigmaRef();
		Referencespaending ref = new ReferencespaendingImpl();

		
		fail("ReferencespaendingEjDefineretException ej kastet");
	}

	@Test(expected = FlydeSpaendingEjDefineretException.class)
	public void FlydespaendingNullText() throws FlydeSpaendingEjDefineretException {
		PTECalculatorController calc = new PTECalculatorControllerImpl();
				
				calc.getFlydeSpaending();


		fail("FlydespaendingEjDefineretException ej kastet");
	}

	@Test
	public void Sikkerhedsfaktortest() throws ReferenceSpaendingEjDefineretException, FlydeSpaendingEjDefineretException, SikkerhedsFaktorEjDefineretException {
		ReferencespaendingMock ref = new ReferencespaendingMock();
		FlydeSpaending fly = new FlydeSpaendingImpl();
		SikkerhedsFaktor sk = new SikkerhedsFaktorImpl();

		fly.angivFlydeSpaending(355);
		ref.getSigmaRef();
		sk.angivFlydeSpaending(fly);
		sk.angivReferencespaending(ref);
		double sf = sk.getSikkerhedsFaktor();

		assertEquals(2.683302, sf, 0.001);

	}


	
	
	
	
	
	
	
	private class ReferencespaendingMock implements Referencespaending{

		@Override
		public double getSigmaRef() {
			// TODO Auto-generated method stub
			return 132.2997;
		}

		@Override
		public String GetMellemRegning() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void angivNormalspaending(Normalspaending sigmaN) throws NormalspaendingEjDefineretException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void angivBoejningsspaending(Boejningsspaending sigmaB)
				throws angivBoejningsspaendingEjDefineretException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void angivForskydsningsspaending(ForskydningsSpaendning tau)
				throws ForskydningsspaendingEjDefineretException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setSigmaRefNmm2(double sigmaRefNmm2) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
