package presentation;

import exceptions.ArealEjDefineretException;
import exceptions.BoejningsMomentEjDefineretException;
import exceptions.BoejningsspaendingEjDefineretException;
import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.ForskydningsspaendingEjDefineretException;
import exceptions.HalvProfilhoejdeEjDefineretException;
import exceptions.InertimomentEjDefineretException;
import exceptions.LaengdeEjDefineretException;
import exceptions.NegativArealException;
import exceptions.NegativInertimomentException;
import exceptions.NormalkraftEjDefineretException;
import exceptions.NormalspaendingEjDefineretException;
import exceptions.TvaerkraftEjDefineretException;
import exceptions.VinkelEjDefineretException;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;

public class InertimomentTextField extends TextField {
	KommaKontrol kommaKontrol = new KommaKontrol();

	public InertimomentTextField() {
		this.setPromptText("Inertimoment");
		this.setAlignment(Pos.CENTER_RIGHT);
		this.setMaxSize(150, 20);
		this.setOnKeyReleased(e -> {

			try {
				// notifyObservers();

				setStyle("-fx-control-inner-background: #ffffff;");
				if (this.getLength() > 0) {
					this.setAlignment(Pos.CENTER_RIGHT);
					char sidsteBogstav = this.getText().charAt(this.getLength() - 1);
					if (!(sidsteBogstav >= '0' && sidsteBogstav <= '9' || sidsteBogstav == ','
							|| sidsteBogstav == '.')) {
						String tekst = this.getText().substring(0, this.getText().length() - 1);
						this.setText(tekst);
						this.positionCaret(100);

					} else {
						// int cursorPos = weightTextField.getCaretPosition();
						this.setText(kommaKontrol.kontrol(this.getText(), this));
						this.positionCaret(kommaKontrol.getCursorPos());
						FrontPage.frontPageMediator.getObserver().getPteCalc()
								.angivIntertimoment(Double.parseDouble(this.getText()));
					}
				} else
					this.setAlignment(Pos.CENTER_LEFT);

			} catch (NumberFormatException | InertimomentEjDefineretException | NegativInertimomentException e1) {
				this.setAlignment(Pos.CENTER_LEFT);
				setStyle("-fx-control-inner-background: #f92525;");
				e1.printStackTrace();
			}

			try {
				FrontPage.frontPageMediator.getObserver().getPteCalc()
						.angivIntertimoment(Double.parseDouble(this.getText()));
			} catch (NumberFormatException | InertimomentEjDefineretException | NegativInertimomentException e2) {
				setStyle("-fx-control-inner-background: #f92525;");
			}

			
				try {
					FrontPage.frontPageMediator.getObserver().getPteCalc().beregnBoejningsSpaending();
				} catch (BoejningsMomentEjDefineretException | BoejningsspaendingEjDefineretException
						| HalvProfilhoejdeEjDefineretException | InertimomentEjDefineretException e1) {
					//Gør ingenting
				}
			
		});
	}
}
