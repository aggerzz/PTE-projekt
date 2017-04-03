package presentation;

import exceptions.ArealEjDefineretException;
import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.ForskydningsspaendingEjDefineretException;
import exceptions.NormalkraftEjDefineretException;
import exceptions.NormalspaendingEjDefineretException;
import exceptions.TvaerkraftEjDefineretException;
import exceptions.VinkelEjDefineretException;
import exceptions.erUnderFejlgraenseException;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import logic.PTECalculatorController;
import logic.PTECalculatorControllerImpl;
import observers.AngleObserver;

public class HorizontalAngleTextField extends TextField {
	public HorizontalAngleTextField() {
		KommaKontrol kommaKontrol = new KommaKontrol();
		this.setPromptText("Lodret vinkel");
		this.setMaxSize(150, 20);
		this.setOnKeyReleased(e -> {
			try {
				if (this.getText().length() > 0) {
					char sidsteBogstav = this.getText().charAt(this.getLength() - 1);
					if (!(sidsteBogstav >= '0' && sidsteBogstav <= '9' || sidsteBogstav == ','
							|| sidsteBogstav == '.')) {
						String tekst = this.getText().substring(0, this.getText().length() - 1);
						this.setText(tekst);
						this.positionCaret(100);
					}else {
						int cursorPos = this.getCaretPosition();
						this.setText(kommaKontrol.kontrol(this.getText(),this));
						this.positionCaret(cursorPos);
						notifyObservers();
					}
				} else {					
					FrontPage.frontPageMediator.getVerticalAngleText().setDisable(false);
					FrontPage.frontPageMediator.getVerticalAngleText().setText("");
					FrontPage.getFrontPageMediator().getObserver().getPteCalc().angivVinkel(Double.NaN, false);
					FrontPage.frontPageMediator.frontPageTopLeft.getTriangle().getChildren()
							.setAll(new NeedMoreInputTriangle());
					
				}
			} catch (DimensionerendeKraftEjDefineretException | erUnderFejlgraenseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}

	private void notifyObservers() throws DimensionerendeKraftEjDefineretException {
		new AngleObserver().update(this.getText(), this);

		try {
			FrontPage.frontPageMediator.getObserver().getPteCalc().angivVinkel(Double.parseDouble(this.getText()),
					true);
		} catch (NumberFormatException e) {
		} catch (erUnderFejlgraenseException e) {
		}


		Beregn beregn = new Beregn();
		beregn.beregn();
	}
}
