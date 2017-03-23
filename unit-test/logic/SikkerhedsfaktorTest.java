package logic;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.FlydeSpaendingEjDefineretException;
import exceptions.ForskydningsspaendingEjDefineretException;
import exceptions.NormalspaendingEjDefineretException;
import exceptions.ReferenceSpaendingEjDefineretException;
import exceptions.SikkerhedsFaktorEjDefineretException;
import exceptions.angivBoejningsspaendingEjDefineretException;

public class SikkerhedsfaktorTest {

	private class FlydeSpaendingMock implements FlydeSpaending {

		@Override
		public void angivFlydeSpaending(double value) throws FlydeSpaendingEjDefineretException {
			// TODO Auto-generated method stub

		}

		@Override
		public double getFlydeSpaending() {
			// TODO Auto-generated method stub
			return 355;
		}

		@Override
		public boolean erFlydeSpaendingNormal() {
			// TODO Auto-generated method stub
			return false;
		}

	}

	private class ReferencespaendingMock implements Referencespaending {

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

	@Test
	public void testSikkerhedsfaktorForPositivReferencespaendingOgPositivFlydespaending()
			throws ReferenceSpaendingEjDefineretException, FlydeSpaendingEjDefineretException,
			SikkerhedsFaktorEjDefineretException {
		SikkerhedsFaktor sf = new SikkerhedsFaktorImpl();
		Referencespaending sigmaRef = new ReferencespaendingMock();
		FlydeSpaending sigmaTil = new FlydeSpaendingMock();

		sf.angivReferencespaending(sigmaRef);
		sf.angivFlydeSpaending(sigmaTil);

		double sfIVaerdi = sf.getSikkerhedsFaktor();
		assertEquals(2.6833, sfIVaerdi, 0.001);

	}

	@Test(expected = ReferenceSpaendingEjDefineretException.class)
	public void testSikkerhedsfaktorForReferenceSpaendingEjDefineret() throws ReferenceSpaendingEjDefineretException,
			FlydeSpaendingEjDefineretException, SikkerhedsFaktorEjDefineretException {
		SikkerhedsFaktor sf = new SikkerhedsFaktorImpl();
		FlydeSpaending sigmaTil = new FlydeSpaendingMock();

		sf.angivFlydeSpaending(sigmaTil);
		sf.getSikkerhedsFaktor();
		fail("ReferenceSpaendingEjDefineret ej kastet");

	}

	@Test(expected = FlydeSpaendingEjDefineretException.class)
	public void testSikkerhedsfaktorForFlydeSpaendingEjDefineret() throws ReferenceSpaendingEjDefineretException,
			FlydeSpaendingEjDefineretException, SikkerhedsFaktorEjDefineretException {
			
		SikkerhedsFaktor sf = new SikkerhedsFaktorImpl();
		Referencespaending sigmaRef = new ReferencespaendingMock();
		
		sf.angivReferencespaending(sigmaRef);
		sf.getSikkerhedsFaktor();
		fail("FlydeSpaendingEjDefineretException ej kastet"); 
		
	}

}
