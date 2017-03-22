package presentation;

import exceptions.ArealEjDefineretException;
import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.ForskydningsspaendingEjDefineretException;
import exceptions.NormalkraftEjDefineretException;
import exceptions.NormalspaendingEjDefineretException;
import exceptions.TvaerkraftEjDefineretException;
import exceptions.VinkelEjDefineretException;
import exceptions.erUnderFejlgraenseException;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import logic.PTECalculatorController;
import logic.PTECalculatorControllerImpl;
import observers.AngleObserver;

public class VerticalAngleTextField extends TextField{
	public VerticalAngleTextField () {
		KommaKontrol kommaKontrol = new KommaKontrol();
		this.setPromptText("Vandret vinkel");
		this.setMaxSize(150, 20);
		
		this.setOnKeyReleased(e->{
			try {
				if(this.getText().length()>0){					
					char sidsteBogstav = this.getText().charAt(this.getLength()-1);
					if(!(sidsteBogstav >= '0' && sidsteBogstav <= '9' || sidsteBogstav == ',' || sidsteBogstav == '.' )){										
						String tekst = this.getText().substring(0, this.getText().length()-1 );
						this.setText(tekst);
						this.positionCaret(100);
					}else{
						int cursorPos = this.getCaretPosition();
						this.setText(kommaKontrol.kontrol(this.getText(),this));
						this.positionCaret(cursorPos);
						this.setAlignment(Pos.CENTER_RIGHT);
						notifyObservers();}
				}
				else{
					this.setAlignment(Pos.CENTER_LEFT);
					FrontPage.frontPageMediator.getHorizontalAngleText().setDisable(false);
					FrontPage.frontPageMediator.getHorizontalAngleText().setText("");
					FrontPage.frontPageMediator.frontPageTopLeft.getTriangle().getChildren().setAll(new NeedMoreInputTriangle());
					
				}
			} catch (DimensionerendeKraftEjDefineretException e1) {
				e1.printStackTrace();
			}
		});
		
	}
	private void notifyObservers() throws DimensionerendeKraftEjDefineretException{
		new AngleObserver().update(this.getText(),this);
		try {
			FrontPage.frontPageMediator.getObserver().getPteCalc().angivVinkel(Double.parseDouble(this.getText()), false);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (erUnderFejlgraenseException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		try {
			FrontPage.frontPageMediator.getObserver().getPteCalc().beregnNormalkraft();
		} catch (DimensionerendeKraftEjDefineretException | VinkelEjDefineretException e2) {
			// Gør ingen ting
		}
		try {
			FrontPage.frontPageMediator.getObserver().getPteCalc().beregnTvaerkraft();
		} catch (DimensionerendeKraftEjDefineretException | VinkelEjDefineretException e2) {
			// Gør ingen ting
		}

		try {
			FrontPage.frontPageMediator.getObserver().getPteCalc().beregnForskydningsspaendning();
		} catch (DimensionerendeKraftEjDefineretException | VinkelEjDefineretException
				| ForskydningsspaendingEjDefineretException | ArealEjDefineretException
				| TvaerkraftEjDefineretException e1) {
			// Gør ingen ting
		}
		
		try {
			FrontPage.frontPageMediator.getObserver().getPteCalc().beregnNormalspaending();
		} catch (NormalkraftEjDefineretException | DimensionerendeKraftEjDefineretException | VinkelEjDefineretException | NormalspaendingEjDefineretException | ArealEjDefineretException e1) {
			// gør ingen ting
		}
	}

}
