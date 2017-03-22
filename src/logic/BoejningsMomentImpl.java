package logic;

public class BoejningsMomentImpl implements BoejningsMoment {
	Dimensionerendekraft fdim;
	Laengde l2 ;
	String mellemRegning = "";
	@Override
	public void angivDimensionerendeKraft(Dimensionerendekraft fdim) {
		this.fdim=fdim;
	}

	@Override
	public void angivLaengde(Laengde l2) {
		this.l2 = l2;
	}

	@Override
	public void beregnBoejningsMoment() {
		double boejningsMoment = fdim.getNewton()/l2.getLaengde();
		mellemRegning = "Bm = Fdim / l \n"
				+ boejningsMoment + " = " + fdim.getNewton() + " / " + l2.getLaengde();
	}

	@Override
	public double getBoejningsMoment() {
		return fdim.getNewton()/l2.getLaengde();
	}
	

}
