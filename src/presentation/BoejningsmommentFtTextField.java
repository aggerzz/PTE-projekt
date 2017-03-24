package presentation;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;

public class BoejningsmommentFtTextField extends TextField {
	KommaKontrol kommaKontrol = new KommaKontrol();
	Beregn beregn = new Beregn();

	public BoejningsmommentFtTextField() {
		this.setPromptText("Hypotinusen");
		this.setAlignment(Pos.CENTER_RIGHT);
		this.setMaxSize(150, 20);
		}
}
