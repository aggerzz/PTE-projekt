package logic;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.ArealEjDefineretException;
import exceptions.BoejningsMomentEjDefineretException;
import exceptions.BoejningsspaendingEjDefineretException;
import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.ForskydningsspaendingEjDefineretException;
import exceptions.HalvProfilhoejdeEjDefineretException;
import exceptions.InertimomentEjDefineretException;
import exceptions.LaengdeEjDefineretException;
import exceptions.NegativArealException;
import exceptions.NormalkraftEjDefineretException;
import exceptions.NormalspaendingEjDefineretException;
import exceptions.ReferenceSpaendingEjDefineretException;
import exceptions.TvaerkraftEjDefineretException;
import exceptions.VinkelEjDefineretException;
import exceptions.angivBoejningsspaendingEjDefineretException;

public class ReferencespaendingTest {

	private class ForskydningsSpaendingMock2 implements ForskydningsSpaendning {

		@Override
		public String getMellemregning() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void angivTvaerkraft(Tvaerkraft ft)
				throws ForskydningsspaendingEjDefineretException {
			// TODO Auto-generated method stub

		}

		@Override
		public void angivAreal(Areal a) throws ArealEjDefineretException {
			// TODO Auto-generated method stub

		}

		@Override
		public double getNmm2()
				throws DimensionerendeKraftEjDefineretException,
				VinkelEjDefineretException,
				ForskydningsspaendingEjDefineretException,
				ArealEjDefineretException, TvaerkraftEjDefineretException {
			// TODO Auto-generated method stub
			return 1.4;
		}

		@Override
		public void setNmm2(double nMm2) {
			// TODO Auto-generated method stub

		}

	}

	private class NormalspaendingMock2 implements Normalspaending {

		@Override
		public double getSigmaNmm2()
				throws DimensionerendeKraftEjDefineretException,
				VinkelEjDefineretException,
				NormalspaendingEjDefineretException, ArealEjDefineretException {
			// TODO Auto-generated method stub
			return 1.17;
		}

		@Override
		public void setSigmaNmm2(double nMm2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void setMellemregning(String mellemregning) {
			// TODO Auto-generated method stub

		}

		@Override
		public String getMellemregning() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void angivNormalkraft(Normalkraft fn)
				throws NormalkraftEjDefineretException {
			// TODO Auto-generated method stub

		}

		@Override
		public void angivAreal(Areal a) throws NegativArealException,
				ArealEjDefineretException {
			// TODO Auto-generated method stub

		}

	}

	private class BoejningsspaendingMock2 implements Boejningsspaending {

		@Override
		public void angivBoejningsmoment(BoejningsMoment boejning)
				throws BoejningsMomentEjDefineretException {
			// TODO Auto-generated method stub

		}

		@Override
		public void angivInertimoment(Inertimoment i)
				throws InertimomentEjDefineretException {
			// TODO Auto-generated method stub

		}

		@Override
		public void angivHalvProfilhoejde(HalvProfilhoejde e)
				throws HalvProfilhoejdeEjDefineretException {
			// TODO Auto-generated method stub

		}

		@Override
		public double getBoejningsspaending()
				throws BoejningsspaendingEjDefineretException,
				LaengdeEjDefineretException,
				DimensionerendeKraftEjDefineretException,
				HalvProfilhoejdeEjDefineretException,
				InertimomentEjDefineretException {
			// TODO Auto-generated method stub
			return 61.8;
		}

		@Override
		public String getBoejningsspaendingMellemregning()
				throws BoejningsspaendingEjDefineretException {
			// TODO Auto-generated method stub
			return null;
		}

	}

	@Test
	public void testReferencespaendingForPositivBoejningsspaendingOgPositivNormalspaendingOgPositivTau2() throws angivBoejningsspaendingEjDefineretException, NormalspaendingEjDefineretException, ForskydningsspaendingEjDefineretException, BoejningsspaendingEjDefineretException, InertimomentEjDefineretException, HalvProfilhoejdeEjDefineretException, LaengdeEjDefineretException, ReferenceSpaendingEjDefineretException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, ArealEjDefineretException, TvaerkraftEjDefineretException {
		
		Referencespaending sigmaRef = new ReferencespaendingImpl();
		Boejningsspaending sigmaB = new BoejningsspaendingMock2();
		Normalspaending sigmaN = new NormalspaendingMock2();
		ForskydningsSpaendning tau = new ForskydningsSpaendingMock2();
		
		sigmaRef.angivBoejningsspaending(sigmaB);
		sigmaRef.angivNormalspaending(sigmaN);
		sigmaRef.angivForskydsningsspaending(tau);
		
		double sigmaRefINmm2 = sigmaRef.getSigmaRef();
		
		assertEquals(63, sigmaRefINmm2, 0.001);
	}
	
	@Test
	public void testReferencespaendingForPositivBoejningsspaendingOgPositivNormalspaendingOgPositivTau() throws angivBoejningsspaendingEjDefineretException, NormalspaendingEjDefineretException, ForskydningsspaendingEjDefineretException, BoejningsspaendingEjDefineretException, InertimomentEjDefineretException, HalvProfilhoejdeEjDefineretException, LaengdeEjDefineretException, ReferenceSpaendingEjDefineretException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, ArealEjDefineretException, TvaerkraftEjDefineretException {
		
		Referencespaending sigmaRef = new ReferencespaendingImpl();
		Boejningsspaending sigmaB = new BoejningsspaendingMock();
		Normalspaending sigmaN = new NormalspaendingMock();
		ForskydningsSpaendning tau = new ForskydningsSpaendingMock();
		
		sigmaRef.angivBoejningsspaending(sigmaB);
		sigmaRef.angivNormalspaending(sigmaN);
		sigmaRef.angivForskydsningsspaending(tau);
		
		double sigmaRefINmm2 = sigmaRef.getSigmaRef();
		
		assertEquals(90.852, sigmaRefINmm2, 0.001);
	}
	
	@Test (expected = ReferenceSpaendingEjDefineretException.class)
	public void testBoejningsspaendingEjDefineretException() throws NormalspaendingEjDefineretException, ForskydningsspaendingEjDefineretException, InertimomentEjDefineretException, HalvProfilhoejdeEjDefineretException, LaengdeEjDefineretException, ReferenceSpaendingEjDefineretException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, ArealEjDefineretException, BoejningsspaendingEjDefineretException, TvaerkraftEjDefineretException {
		
		Referencespaending sigmaRef = new ReferencespaendingImpl();
		Normalspaending sigmaN = new NormalspaendingMock();
		ForskydningsSpaendning tau = new ForskydningsSpaendingMock();
		
		sigmaRef.angivNormalspaending(sigmaN);
		sigmaRef.angivForskydsningsspaending(tau);
		
		sigmaRef.getSigmaRef();
		
		fail("BoejningsspaendningEjDefineretException ej kastet");
		
	}
	
	@Test (expected = ReferenceSpaendingEjDefineretException.class)
	public void testNormalspaendingEjDefineretException() throws angivBoejningsspaendingEjDefineretException, ForskydningsspaendingEjDefineretException, BoejningsspaendingEjDefineretException, InertimomentEjDefineretException, HalvProfilhoejdeEjDefineretException, LaengdeEjDefineretException, ReferenceSpaendingEjDefineretException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, NormalspaendingEjDefineretException, ArealEjDefineretException, TvaerkraftEjDefineretException {
		
		Referencespaending sigmaRef = new ReferencespaendingImpl();
		Boejningsspaending sigmaB = new BoejningsspaendingMock();
		ForskydningsSpaendning tau = new ForskydningsSpaendingMock();
		
		sigmaRef.angivBoejningsspaending(sigmaB);
		sigmaRef.angivForskydsningsspaending(tau);
		
		sigmaRef.getSigmaRef();
		
		fail("NormalspaendingEjDefineretException ej kastet");
		
	}
	
	@Test (expected = ReferenceSpaendingEjDefineretException.class)
	public void testForskydningsspaendingEjDefineretException() throws angivBoejningsspaendingEjDefineretException, NormalspaendingEjDefineretException, BoejningsspaendingEjDefineretException, InertimomentEjDefineretException, HalvProfilhoejdeEjDefineretException, LaengdeEjDefineretException, ReferenceSpaendingEjDefineretException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, ArealEjDefineretException, ForskydningsspaendingEjDefineretException, TvaerkraftEjDefineretException {
	
	Referencespaending sigmaRef = new ReferencespaendingImpl();
	Boejningsspaending sigmaB = new BoejningsspaendingMock();
	Normalspaending sigmaN = new NormalspaendingMock();
	
	sigmaRef.angivBoejningsspaending(sigmaB);
	sigmaRef.angivNormalspaending(sigmaN);
	
	sigmaRef.getSigmaRef();
	
	fail("ForskydningsspaendingEjDefineretException ej kastet");
	
	}
	
	
	private class ForskydningsSpaendingMock implements ForskydningsSpaendning {

		@Override
		public String getMellemregning() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void angivTvaerkraft(Tvaerkraft ft) throws ForskydningsspaendingEjDefineretException {
			// TODO Auto-generated method stub

		}

		@Override
		public void angivAreal(Areal a) throws ArealEjDefineretException {
			// TODO Auto-generated method stub

		}

		@Override
		public double getNmm2() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException,
				ForskydningsspaendingEjDefineretException, ArealEjDefineretException, TvaerkraftEjDefineretException {
			// TODO Auto-generated method stub
			return 0.144239;
		}

		@Override
		public void setNmm2(double nMm2) {
			// TODO Auto-generated method stub

		}

	}

	private class NormalspaendingMock implements Normalspaending {

		@Override
		public double getSigmaNmm2() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException,
				NormalspaendingEjDefineretException {
			// TODO Auto-generated method stub
			return 0.91069;
		}

		@Override
		public void setSigmaNmm2(double nMm2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void setMellemregning(String mellemregning) {
			// TODO Auto-generated method stub

		}

		@Override
		public String getMellemregning() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void angivNormalkraft(Normalkraft fn) throws NormalkraftEjDefineretException {
			// TODO Auto-generated method stub

		}

		@Override
		public void angivAreal(Areal a) throws NegativArealException {
			// TODO Auto-generated method stub

		}

	}

	private class BoejningsspaendingMock implements Boejningsspaending {

		@Override
		public void angivBoejningsmoment(BoejningsMoment boejning) throws BoejningsMomentEjDefineretException {
			// TODO Auto-generated method stub

		}

		@Override
		public void angivInertimoment(Inertimoment i) throws InertimomentEjDefineretException {
			// TODO Auto-generated method stub

		}

		@Override
		public void angivHalvProfilhoejde(HalvProfilhoejde e) throws HalvProfilhoejdeEjDefineretException {
			// TODO Auto-generated method stub

		}

		@Override
		public double getBoejningsspaending() throws BoejningsspaendingEjDefineretException {
			// TODO Auto-generated method stub
			return 89.94158564;
		}

		@Override
		public String getBoejningsspaendingMellemregning() throws BoejningsspaendingEjDefineretException {
			// TODO Auto-generated method stub
			return null;
		}

	}

}
