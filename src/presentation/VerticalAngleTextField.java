package presentation;

import exceptions.erUnderFejlgraenseException;
import javafx.scene.control.TextField;
import logic.PTECalculatorController;
import logic.PTECalculatorControllerImpl;
import observers.AngleObserver;

public class VerticalAngleTextField extends TextField{
	public VerticalAngleTextField () {
		this.setPromptText("vertical angle");
		this.setMaxSize(150, 20);
		
		this.setOnKeyReleased(e->{
			notifyObservers();
		});
		
	}
	private void notifyObservers(){
		new AngleObserver().update(this.getText(),this);
		try {
			FrontPage.frontPageMediator.getObserver().getPteCalc().angivVinkel(Double.parseDouble(this.getText()), false);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (erUnderFejlgraenseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
