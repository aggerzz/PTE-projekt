package presentation;

import javafx.scene.control.TextField;

public class VerticalAngleTextField extends TextField{
	public VerticalAngleTextField () {
		this.setPromptText("vertical angle");
		this.setMaxSize(150, 20);
		
		this.setOnKeyReleased(e->{
			new AngleObserver().update(this.getText(),this);
		});
		
	}

}
