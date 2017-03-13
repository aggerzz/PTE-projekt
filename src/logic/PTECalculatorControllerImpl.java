package logic;

public class PTECalculatorControllerImpl implements PTECalculatorController {

	private Dimensionerendekraft fdim;
	private Vinkel vinkel;
	private Normalkraft fn;
	private PTEObserver observer;

	@Override
	public void beregnNormalkraft() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {

		if (fdim == null) {
			throw new DimensionerendeKraftEjDefineretException();
		}

		if (vinkel == null) {
			throw new VinkelEjDefineretException();
		}

		fn = new NormalkraftImpl();

		fn.angivDimensionerendekraft(fdim);

		fn.angivVinkel(vinkel);

		notifyObservers();

	}

	@Override
	public double getNormalkraft() throws NormalkraftEjDefineretException, DimensionerendeKraftEjDefineretException,
			VinkelEjDefineretException {

		if (fn == null) {
			throw new NormalkraftEjDefineretException();

		}

		double fnNewton = fn.getNewton();

		return fnNewton;

	}

	@Override
	public String getNormalkraftBeregninger() throws NormalkraftEjDefineretException,
			DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {

		if (fn == null) {
			throw new NormalkraftEjDefineretException();

		}

		String normalkraftBeregning = fn.getBeregning();

		return normalkraftBeregning;

	}
	@Override
	public void angivVaegt(double kg) throws DimensionerendeKraftEjDefineretException{
		fdim = new DimensionerendekraftImpl();
		
		fdim.setKg(kg);
		
		notifyObservers();
	}

	@Override
	public void notifyObservers() {

		if (observer != null) {
			observer.update();
		}

	}
	

	@Override
	public double getVinkel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void beregnTvaerkraft() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTvaerkraftMellemregning() throws NormalkraftEjDefineretException,
			DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getTvaerkraft() throws NormalkraftEjDefineretException, DimensionerendeKraftEjDefineretException,
			VinkelEjDefineretException {
		// TODO Auto-generated method stub
		return 0;
	}

}
