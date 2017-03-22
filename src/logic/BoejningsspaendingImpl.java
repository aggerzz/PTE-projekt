package logic;

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
			this.e = e;

		else
			throw new HalvProfilhoejdeEjDefineretException();

	}

	@Override
	public void beregnBoejningsspaending() throws BoejningsMomentEjDefineretException, InertimomentEjDefineretException,
			HalvProfilhoejdeEjDefineretException {
		double boejningsSpaending = boejning.getBoejningsMoment() * e.getHalvProfilhoejde() / i.getInertimoment();
		boejningsSpaendingMellemregning = "Mb * e / l" + "\n" + boejningsSpaending + " = "
				+ boejning.getBoejningsMoment() + "*" + e.getHalvProfilhoejde() + "/" + i.getInertimoment();

	}

	@Override
	public double getBoejningsspaending() throws BoejningsspaendingEjDefineretException {
		double bm;
		double inertiMoment;
		double halvProfilHoejde;
		try {
			bm = boejning.getBoejningsMoment();
			inertiMoment = i.getInertimoment();
			halvProfilHoejde = e.getHalvProfilhoejde();
			return bm * halvProfilHoejde / inertiMoment;
		} catch (LaengdeEjDefineretException | DimensionerendeKraftEjDefineretException e1) {
			e1.printStackTrace();
		}
		return Double.NaN;
	}

	@Override
	public String getBoejningsspaendingMellemregning() throws BoejningsspaendingEjDefineretException {
		return boejningsSpaendingMellemregning;
	}

}