package logic;

import exceptions.BoejningsMomentEjDefineretException;
import exceptions.BoejningsspaendingEjDefineretException;
import exceptions.FDimEjDefineret;
import exceptions.HalvProfilhoejdeEjDefineretException;
import exceptions.InertimomentEjDefineretException;

public interface Boejningsspaending {

	public void angivBoejningsmoment(BoejningsMoment boejning) throws BoejningsMomentEjDefineretException;

	public void angivInertimoment(Inertimoment i) throws InertimomentEjDefineretException;

	public void angivHalvProfilhoejde(HalvProfilhoejde e) throws HalvProfilhoejdeEjDefineretException;

	public void beregnBoejningsspaending() throws BoejningsMomentEjDefineretException, InertimomentEjDefineretException,
			HalvProfilhoejdeEjDefineretException, FDimEjDefineret;

	public double getBoejningsspaending() throws BoejningsspaendingEjDefineretException, FDimEjDefineret;

	public String getBoejningsspaendingMellemregning() throws BoejningsspaendingEjDefineretException;

}
