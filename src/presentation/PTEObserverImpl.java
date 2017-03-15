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
		frontPageMediator.getMellemRegninger().clear();
		try {
			double fDim = pteCalc.getDimensionerendekraft();
			String fDimText = Double.toString(fDim); //TODO formater til 3 decimaler
			frontPageMediator.getFdimTextField().setText(fDimText );
			String fDimMellemregning = pteCalc.getDimensionerendekraftMellemregning();
			frontPageMediator.getMellemRegninger().appendText(fDimMellemregning);
		} catch (DimensionerendeKraftEjDefineretException e1) {
			frontPageMediator.getFdimTextField().clear();
		}
		
		try {
			double tvaerkraft = pteCalc.getTvaerkraft();
			String tvaerkraftText = Double.toString(tvaerkraft);
			frontPageMediator.getFtTextField().setText(tvaerkraftText);
			String tvaerkraftMellemregning = pteCalc.getTvaerkraftMellemregning();
			frontPageMediator.getMellemRegninger().appendText(tvaerkraftMellemregning);
		} catch (TvaerkraftEjDefineretException | DimensionerendeKraftEjDefineretException
				| VinkelEjDefineretException e1) {
			frontPageMediator.getFtTextField().clear();
		}
		
		try {
			double normalkraft = pteCalc.getNormalkraft();
			String normalkraftText = Double.toString(normalkraft);
			frontPageMediator.getFnTextField().setText(normalkraftText);
			String normalkraftMellemregning = pteCalc.getNormalkraftMellemregning();
			frontPageMediator.getMellemRegninger().appendText(normalkraftMellemregning);
		} catch (NormalkraftEjDefineretException | DimensionerendeKraftEjDefineretException
				| VinkelEjDefineretException e1) {
			frontPageMediator.getFnTextField().clear();
		}
		}
		
		
		
//		
//		if (frontPageMediator.getMellemRegninger() != null) {
//			frontPageMediator.getMellemRegninger().clear();
//		}
//		if(frontPageMediator.getWeightValueTextField() != null ){
//		frontPageMediator.getFdimTextField().setText(Double.toString(pteCalc.getDimensionerendekraft()));
//		}
//		try {
//			if(frontPageMediator.getHorizontalAngleText() != null && frontPageMediator.getVerticalAngleText() != null && frontPageMediator.getFdimTextField() != null) {
//				frontPageMediator.getFtTextField().setText(Double.toString(pteCalc.getTvaerkraft()));
//				frontPageMediator.getFnTextField().setText(Double.toString(pteCalc.getNormalkraft()));
//
//			}
//		} catch (TvaerkraftEjDefineretException e) {
//			System.out.println("TvaerkraftEjDefineretException");
////			e.printStackTrace();
//		} catch (DimensionerendeKraftEjDefineretException e) {
//			System.out.println("DimensionerendeKraftEjDefineretException");
////			e.printStackTrace();
//		} catch (VinkelEjDefineretException e) {
//			System.out.println("VinkelEjDefineretException");
////			e.printStackTrace();
//		} catch (NormalkraftEjDefineretException e) {
//			System.out.println("NormalkraftEjDefineretException");
////			e.printStackTrace();
//		}
//		insaetMellemregninger();
//	}


//	private void insaetMellemregninger() {
//		try {
//			
//			TextArea mellemregninger = frontPageMediator.getMellemRegninger();
//			if(frontPageMediator.getFdimTextField() != null)
//			mellemregninger.appendText(pteCalc.getDimensionerendekraft() + "\n");
//			if(frontPageMediator.getFtTextField() != null)
//			mellemregninger.appendText(pteCalc.getTvaerkraftMellemregning() + "\n");
//			if (frontPageMediator.getFnTextField() != null)
//			mellemregninger.appendText(pteCalc.getNormalkraftMellemregning() + "\n");
//		} catch (NormalkraftEjDefineretException e) {
//			System.out.println("NormalkraftEjDefineretException");
//			e.printStackTrace();
//		} catch (DimensionerendeKraftEjDefineretException e) {
//			System.out.println("DimensionerendeKraftEjDefineretException");
//			e.printStackTrace();
//		} catch (VinkelEjDefineretException e) {
//			System.out.println("VinkelEjDefineretException");
//			e.printStackTrace();
//		} catch (TvaerkraftEjDefineretException e) {
//			System.out.println("TvaerkraftEjDefineretException");
//			e.printStackTrace();
//		}
//	}

	public PTECalculatorController getPteCalc() {
		return pteCalc;
	}

}
