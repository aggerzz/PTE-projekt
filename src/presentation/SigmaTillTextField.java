package presentation;

import exceptions.FlydeSpaendingEjDefineretException;
import exceptions.ReferenceSpaendingEjDefineretException;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;

public class SigmaTillTextField extends TextField {
	KommaKontrol kommaKontrol = new KommaKontrol();
	public SigmaTillTextField() {
		this.setPromptText("sigmaTill");
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
						FrontPage.frontPageMediator.getObserver().getPteCalc().angivFlydespaending(Double.parseDouble(this.getText()));
						Beregn beregn = new Beregn();
						beregn.beregn();
					}
				}else
					FrontPage.getFrontPageMediator().getObserver().getPteCalc().angivFlydespaending(Double.NaN);
			}catch (NumberFormatException | FlydeSpaendingEjDefineretException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			
				Beregn beregn = new Beregn();
				beregn.beregn();
		});
		
		}

}
