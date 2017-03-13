package presentation;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FrontPageMediator {
	FrontPageTopLeftInsetter frontPageTopLeft;
	FrontPageBottomInsetter frontPageBottom;

	public FrontPageMediator(FrontPageTopLeftInsetter frontPageTopLeft, FrontPageBottomInsetter frontPageBottom) {
		this.frontPageTopLeft = frontPageTopLeft;
		this.frontPageBottom = frontPageBottom;
	}

	public TextField getVerticalAngleText() {
		return frontPageTopLeft.getVerticalAngle();
	}

	public TextField getHorizontalAngleText() {
		return frontPageTopLeft.getHorizontalAngle();
	}

	public TextField getWeightValueTextField() {
		return frontPageTopLeft.getWeightValueHBox().getWeightTextField();
	}

	public ComboBox<String> getWeightUnitComboBox() {
		return frontPageTopLeft.getWeightValueHBox().getUnit();
	}

	public Canvas getTriangle() {
		return frontPageTopLeft.getTriangle();
	}

	public TextField getFdimTextField() {
		return frontPageBottom.getFdimTextField();
	}
	public TextArea getMellemRegninger(){
		return frontPageBottom.getMellemRegninger();
	}
	
	public void setTriangle(Canvas triangle) {
		frontPageTopLeft.setTriangle(triangle);
	}

	public void setHorizontalAngleText(TextField tf) {
		frontPageTopLeft.setHorizontalAngle(tf);
	}

	public void setVerticalAngleText(TextField tf) {
		frontPageTopLeft.setVerticalAngle(tf);
	}

}
