package presentation;

import exceptions.ArealEjDefineretException;
import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.ForskydningsspaendingEjDefineretException;
import exceptions.NegativArealException;
import exceptions.NormalkraftEjDefineretException;
import exceptions.NormalspaendingEjDefineretException;
import exceptions.TvaerkraftEjDefineretException;
import exceptions.VinkelEjDefineretException;
import javafx.scene.control.TextField;

public class ArealTextField extends TextField {
	public ArealTextField() {
		this.setPromptText("Areal");
		this.setMaxSize(150, 20);
		this.setOnKeyReleased(e -> {
			try {
				//notifyObservers();
				FrontPage.frontPageMediator.getObserver().getPteCalc().angivAreal(Double.parseDouble(this.getText()));
			} catch (NegativArealException e1) {				
				e1.printStackTrace();
			}
			try {
				FrontPage.frontPageMediator.getObserver().getPteCalc().beregnForskydningsspaendning();
			} catch (DimensionerendeKraftEjDefineretException | VinkelEjDefineretException
					| ForskydningsspaendingEjDefineretException | ArealEjDefineretException
					| TvaerkraftEjDefineretException e1) {
				// gør ingen ting
			}
			
			try {
				FrontPage.frontPageMediator.getObserver().getPteCalc().beregnNormalspaending();
			} catch (NormalkraftEjDefineretException | DimensionerendeKraftEjDefineretException | VinkelEjDefineretException | NormalspaendingEjDefineretException | ArealEjDefineretException e1) {
				// gør ingen ting
			}			
		});
	}
}
