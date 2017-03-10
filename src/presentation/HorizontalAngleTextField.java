package presentation;

import javafx.scene.control.TextField;

public class HorizontalAngleTextField extends TextField {
	public HorizontalAngleTextField(){
		this.setPromptText("horizontal angle");
		this.setMaxSize(150, 20);
		this.setOnKeyReleased(e->{
			new AngleObserver().update(this.getText(), this);
		});
	}
}
