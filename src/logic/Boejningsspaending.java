package logic;

import exceptions.BoejningsMomentEjDefineretException;
import exceptions.BoejningsspaendingEjDefineretException;
import exceptions.HalvProfilhoejdeEjDefineretException;
import exceptions.InertimomentEjDefineretException;

public interface Boejningsspaending {

	public void angivBoejningsmoment(BoejningsMoment boejning) throws BoejningsMomentEjDefineretException;

	public void angivInertimoment(Inertimoment i) throws InertimomentEjDefineretException;

	public void angivHalvProfilhoejde(HalvProfilhoejde e) throws HalvProfilhoejdeEjDefineretException;

	public void beregnBoejningsspaending() throws BoejningsMomentEjDefineretException, InertimomentEjDefineretException,
			HalvProfilhoejdeEjDefineretException;

	public double getBoejningsspaending() throws BoejningsspaendingEjDefineretException, InertimomentEjDefineretException, HalvProfilhoejdeEjDefineretException;

	public String getBoejningsspaendingMellemregning() throws BoejningsspaendingEjDefineretException;

}
