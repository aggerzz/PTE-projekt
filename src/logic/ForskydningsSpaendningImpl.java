package logic;

import exceptions.ArealEjDefineretException;
import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.ForskydningsspaendingEjDefineretException;
import exceptions.VinkelEjDefineretException;

public class ForskydningsSpaendningImpl implements ForskydningsSpaendning {
	private Areal a;
	private Tvaerkraft ft;
	private String mellemregning;
	private double tau;

	private void setMellemregning(String mellemregning) {
		this.mellemregning = mellemregning;
	}

	public String getMellemregning() {
		return mellemregning;
	}

	public void angivTvaerkraft(Tvaerkraft ft) throws ForskydningsspaendingEjDefineretException {
		if (ft != null) {
			this.ft = ft;
		}
	}

	public void angivAreal(Areal a) throws ArealEjDefineretException {

		if (a == null) {
			throw new ArealEjDefineretException();
		}
		this.a = a;
	}

	public double getNmm2() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException,
			ForskydningsspaendingEjDefineretException, ArealEjDefineretException {
		if (ft == null || a == null) {
			throw new ForskydningsspaendingEjDefineretException();
		}

		double ftNewton = ft.getNewton();
		double mm2 = a.getMm2();
		double tau = ftNewton / mm2;
		// setMellemregning("Tau = Ft / A " + "\n" + tau + ftNewton + "/" + mm2
		// + "\n");
		setMellemregning("Ft\t	 /\tA\t=\tTau" + "\n" + ftNewton + "\t	/\t	" + mm2 + "\t	 =\t " + tau + "\n ");
		return tau;
	}

	public void setNmm2(double nMm2) {
		this.tau = nMm2;
	}
}
