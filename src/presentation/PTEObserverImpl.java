package presentation;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.NormalkraftEjDefineretException;
import exceptions.TvaerkraftEjDefineretException;
import exceptions.VinkelEjDefineretException;
import javafx.scene.control.TextArea;
import logic.PTECalculatorController;
import logic.PTECalculatorControllerImpl;
import logic.PTEObserver;

public class PTEObserverImpl implements PTEObserver {
	FrontPageMediator frontPageMediator;
	PTECalculatorController pteCalc = new PTECalculatorControllerImpl();

	public PTEObserverImpl(FrontPageMediator fpm) {

		frontPageMediator = fpm;
		pteCalc.tilmeldObserver(this);
	}

	public void update() {
		if (frontPageMediator.getMellemRegninger() != null) {
			frontPageMediator.getMellemRegninger().clear();
		}

		frontPageMediator.getFdimTextField().setText(Double.toString(pteCalc.getDimensionerendekraft().getNewton()));
		try {
			frontPageMediator.getFtTextField().setText(Double.toString(pteCalc.getTvaerkraft()));
			frontPageMediator.getFnTextField().setText(Double.toString(pteCalc.getNormalkraft()));
		} catch (NormalkraftEjDefineretException e) {
			e.printStackTrace();
		} catch (DimensionerendeKraftEjDefineretException e) {
			e.printStackTrace();
		} catch (VinkelEjDefineretException e) {
			e.printStackTrace();
		} catch (TvaerkraftEjDefineretException e) {
			e.printStackTrace();
		}
		insaetMellemregninger();
	}


	private void insaetMellemregninger() {
		try {
			TextArea mellemregninger = frontPageMediator.getMellemRegninger();
			mellemregninger.appendText(pteCalc.getDimensionerendekraft().getMellemRegning() + "\n");
			mellemregninger.appendText(pteCalc.getTvaerkraftMellemregning() + "\n");
			mellemregninger.appendText(pteCalc.getNormalkraftMellemregning() + "\n");
		} catch (NormalkraftEjDefineretException e) {
			e.printStackTrace();
		} catch (DimensionerendeKraftEjDefineretException e) {
			e.printStackTrace();
		} catch (VinkelEjDefineretException e) {
			e.printStackTrace();
		} catch (TvaerkraftEjDefineretException e) {
			e.printStackTrace();
		}
	}

	public PTECalculatorController getPteCalc() {
		return pteCalc;
	}

}
