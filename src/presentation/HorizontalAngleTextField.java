package presentation;

import javafx.scene.control.TextField;
import observers.AngleObserver;

public class HorizontalAngleTextField extends TextField {
	public HorizontalAngleTextField(){
		this.setPromptText("horizontal angle");
		this.setMaxSize(150, 20);
		this.setOnKeyReleased(e->{
			notifyObservers();
		});
	}
	private void notifyObservers(){
		new AngleObserver().update(this.getText(), this);
		
	}
}
