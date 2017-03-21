package logic;

public class ReferenceSpaendingImpl implements ReferenceSpaending {
	Normalspaending sigmaN;
	BoejningsSpaending sigmaB;
	ForskydnignsSpaending tau;
	
	@Override
	public void angivNormalSpaending(NormalSpaending sigmaN) {
		this.sigmaN = sigmaN;
	}

	@Override
	public void angivBoejningsSpaending(BoejningsSpaending sigmaB) {
		this.sigmaB = sigmaB;
	}

	@Override
	public void angivForskydningsSpaending(ForskydningsSpaending tau) {
		this.tau = tau;
	}

	@Override
	public void beregnSigmaRef() {
		
	}

	@Override
	public double getSigmaRef() {
		// TODO Auto-generated method stub
		return 0;
	}

}
