package presentation;


import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.ForskydningsspaendingEjDefineretException;
import exceptions.LaengdeEjDefineretException;
import exceptions.NormalspaendingEjDefineretException;
import exceptions.angivBoejningsspaendingEjDefineretException;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;

public class LaengdeTextField extends TextField {
	KommaKontrol kommaKontrol = new KommaKontrol();
	Beregn beregn = new Beregn();
	public LaengdeTextField() {	

	this.setPromptText("Vandret længde");
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
							.angivLaengde(Double.parseDouble(this.getText()));
				beregn.beregn();
				}
			}
		}catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (LaengdeEjDefineretException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		} 
		
		try {
			FrontPage.frontPageMediator.getObserver().getPteCalc().beregnBoejningsMoment();
		} catch (DimensionerendeKraftEjDefineretException | LaengdeEjDefineretException e1) {
			// gør ingen ting
		}
		
	});
	
	}
}