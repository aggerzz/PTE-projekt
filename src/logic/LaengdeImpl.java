package logic;

public class LaengdeImpl implements Laengde {
	double l2;
	@Override
	public void angivLaengde(double l2) {
		this.l2=l2;
	}

	@Override
	public double getLaengde() {
		return l2;
	}

}
