package presentation;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.FlydeSpaendingEjDefineretException;
import exceptions.HalvProfilhoejdeEjDefineretException;
import exceptions.LaengdeEjDefineretException;
import exceptions.NegativHalvProfilhoejdeException;
import exceptions.ReferenceSpaendingEjDefineretException;
import exceptions.SikkerhedsFaktorEjDefineretException;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;

public class HalvHoejdeTextField extends TextField {
	KommaKontrol kommaKontrol = new KommaKontrol();
	public HalvHoejdeTextField() {
		this.setPromptText("Halv profilhøjde");
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
						FrontPage.frontPageMediator.getObserver().getPteCalc().angivHalvProfilhoejde
								(Double.parseDouble(this.getText()));
					}
				}
			}catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (HalvProfilhoejdeEjDefineretException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NegativHalvProfilhoejdeException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				// gør ingenting
			}		
			
			try {
				FrontPage.frontPageMediator.getObserver().getPteCalc().beregnSikkerhedsFaktor();
			} catch (FlydeSpaendingEjDefineretException | ReferenceSpaendingEjDefineretException  e1) {
				// gør ingen ting
			}
			
		});
		
		}
}
