package presentation;

import javafx.scene.control.TextField;
import observers.AngleObserver;

public class VerticalAngleTextField extends TextField{
	public VerticalAngleTextField () {
		this.setPromptText("vertical angle");
		this.setMaxSize(150, 20);
		
		this.setOnKeyReleased(e->{
			notifyObservers();
		});
		
	}
	private void notifyObservers(){
		new AngleObserver().update(this.getText(),this);
	}

}
