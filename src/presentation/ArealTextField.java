package presentation;

import exceptions.ArealEjDefineretException;
import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.ForskydningsspaendingEjDefineretException;
import exceptions.NegativArealException;
import exceptions.TvaerkraftEjDefineretException;
import exceptions.VinkelEjDefineretException;
import javafx.scene.control.TextField;
import observers.ArealObserver;


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
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}

//	private void notifyObservers() {
//		new ArealObserver().update(this.getText(), this);		
//		
//		try {
//			FrontPage.frontPageMediator.getObserver().getPteCalc().angivAreal(Double.parseDouble(this.getText()));
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();		
//	}}
}
