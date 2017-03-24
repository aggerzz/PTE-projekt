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
	private KommaKontrol kommaKontrol = new KommaKontrol();
	
	public ArealTextField() {		
		this.setPromptText("Areal");
		this.setAlignment(Pos.CENTER_RIGHT);
		this.setMaxSize(150, 20);
		this.setOnKeyReleased(e -> {
			try {
				// notifyObservers();
				
				setStyle("-fx-control-inner-background: #ffffff;");
				if (this.getLength() > 0) {					
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
								.angivAreal(Double.parseDouble(this.getText()));
					}				
				}	
			} catch (NegativArealException  e1) {				
				setStyle("-fx-control-inner-background: #f92525;");
				e1.printStackTrace();
			}
			
			Beregn beregn = new Beregn();
			beregn.beregn();


		});
	}
}
