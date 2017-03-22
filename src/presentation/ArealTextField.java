package presentation;

import exceptions.ArealEjDefineretException;
import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.ForskydningsspaendingEjDefineretException;
import exceptions.NegativArealException;
import exceptions.NormalkraftEjDefineretException;
import exceptions.NormalspaendingEjDefineretException;
import exceptions.TvaerkraftEjDefineretException;
import exceptions.VinkelEjDefineretException;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;

public class ArealTextField extends TextField {
	public ArealTextField() {
		this.setPromptText("Areal");
//		this.setAlignment(Pos.CENTER_RIGHT);
		this.setMaxSize(150, 20);
		this.setOnKeyReleased(e -> {
			try {
				// notifyObservers();
				this.setAlignment(Pos.CENTER_RIGHT);
				setStyle("-fx-control-inner-background: #ffffff;");
				FrontPage.frontPageMediator.getObserver().getPteCalc().angivAreal(Double.parseDouble(this.getText()));
			} catch (NegativArealException e1) {
				this.setAlignment(Pos.CENTER_LEFT);
				setStyle("-fx-control-inner-background: #f92525;");
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
			} catch (NormalkraftEjDefineretException | DimensionerendeKraftEjDefineretException
					| VinkelEjDefineretException | NormalspaendingEjDefineretException | ArealEjDefineretException e1) {
				// gør ingen ting
			}
		});
	}
}
