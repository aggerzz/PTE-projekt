package presentation;

import exceptions.ArmEjDefineretException;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;

public class BoejningsmomentFtTextField extends TextField {
	KommaKontrol kommaKontrol = new KommaKontrol();
	Beregn beregn = new Beregn();

	public BoejningsmomentFtTextField() {
		this.setPromptText("Kommer måske");
		this.setAlignment(Pos.CENTER_RIGHT);
		this.setMaxSize(150, 20);
		
		//TODO FJERN NÅR DET VIRKER
		this.setDisable(true);
		
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
						this.setText(kommaKontrol.kontrol(this.getText(), this));
						this.positionCaret(kommaKontrol.getCursorPos());
						FrontPage.frontPageMediator.getObserver().getPteCalc()
								.angivArm(Double.parseDouble(this.getText()));

						Beregn beregn = new Beregn();
						beregn.beregn();
					}
				} else
					FrontPage.getFrontPageMediator().getObserver().getPteCalc().angivArm(Double.NaN);
			} catch (ArmEjDefineretException e1) {
				e1.printStackTrace();
			}

			Beregn beregn = new Beregn();
			beregn.beregn();
		});
	}
}
