package logic;

import java.text.DecimalFormat;

import exceptions.BoejningsMomentEjDefineretException;
import exceptions.BoejningsspaendingEjDefineretException;
import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.HalvProfilhoejdeEjDefineretException;
import exceptions.InertimomentEjDefineretException;
import exceptions.LaengdeEjDefineretException;

public class BoejningsspaendingImpl implements Boejningsspaending {
	BoejningsMoment boejning;
	Inertimoment i;
	HalvProfilhoejde e;
	String boejningsSpaendingMellemregning;

	@Override
	public void angivBoejningsmoment(BoejningsMoment boejning) throws BoejningsMomentEjDefineretException {
		if (boejning != null)
			this.boejning = boejning;

		else
			throw new BoejningsMomentEjDefineretException();
	}

	@Override
	public void angivInertimoment(Inertimoment i) throws InertimomentEjDefineretException {
		if (i != null)
			this.i = i;

		else
			throw new InertimomentEjDefineretException();

	}

	@Override
	public void angivHalvProfilhoejde(HalvProfilhoejde e) throws HalvProfilhoejdeEjDefineretException {
		if (e == null)
			throw new HalvProfilhoejdeEjDefineretException();
		else
			this.e = e;
	}

//	@Override
//	public void beregnBoejningsspaending() throws BoejningsMomentEjDefineretException, InertimomentEjDefineretException,
//			HalvProfilhoejdeEjDefineretException {
//		try{
//		double boejningsSpaending = boejning.getBoejningsMoment() * e.getHalvProfilhoejde() / i.getInertimoment();
//		boejningsSpaendingMellemregning = "sigmaB = mb * e / I" + "\n" + boejningsSpaending + " = "
//				+ boejning.getBoejningsMoment() + " * " + e.getHalvProfilhoejde() + " / " + i.getInertimoment();
//		}
//		catch(DimensionerendeKraftEjDefineretException | LaengdeEjDefineretException e1){
//			e1.printStackTrace();
//		}
//	}

	@Override
	public double getBoejningsspaending() throws BoejningsspaendingEjDefineretException, LaengdeEjDefineretException, DimensionerendeKraftEjDefineretException {
		if(boejning == null || i == null || e ==null){
			throw new BoejningsspaendingEjDefineretException();
		}
		DecimalFormat formatter = new DecimalFormat("#0.00000");
		double mb = boejning.getBoejningsMoment();
		double inertiMoment = i.getInertimoment();
		double halvProfilHoejde = e.getHalvProfilhoejde();
		double boejningsspaending = mb * halvProfilHoejde / inertiMoment;
			
			String mbText = formatter.format(mb);
			String iText = formatter.format(inertiMoment);
			String eText = formatter.format(halvProfilHoejde);
			String sigmaBText = formatter.format(boejningsspaending);
	
			boejningsSpaendingMellemregning = "MB * e / I = sigmaB" + "\n" + 
					 mbText + " * " + eText + " / " + iText + " = " + sigmaBText + "\n";
			
			return boejningsspaending;

		}

	@Override
	public String getBoejningsspaendingMellemregning() throws BoejningsspaendingEjDefineretException {
		return boejningsSpaendingMellemregning;
	}
	

}