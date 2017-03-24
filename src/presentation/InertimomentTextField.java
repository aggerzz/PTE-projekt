package presentation;

import exceptions.BoejningsMomentEjDefineretException;
import exceptions.BoejningsspaendingEjDefineretException;
import exceptions.HalvProfilhoejdeEjDefineretException;
import exceptions.InertimomentEjDefineretException;
import exceptions.NegativInertimomentException;
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
						this.setText(kommaKontrol.kontrol(this.getText(), this));
						this.positionCaret(kommaKontrol.getCursorPos());

						FrontPage.frontPageMediator.getObserver().getPteCalc()
								.angivIntertimoment(Double.parseDouble(this.getText()));

						Beregn beregn = new Beregn();
						beregn.beregn();

					}
				}}
				catch (NumberFormatException | InertimomentEjDefineretException | NegativInertimomentException e1) {
				// TODO Auto-generated catch block
				setStyle("-fx-control-inner-background: #f92525;");
			}

		});
	}
}
