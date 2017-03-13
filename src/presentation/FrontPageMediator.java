package presentation;

import Domain.Beregning;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FrontPageMediator {
	FrontPageTopLeftInsetter frontPageTopLeft;
	FrontPageBottomInsetter frontPageButtom;
	
	public FrontPageMediator(FrontPageTopLeftInsetter frontPageTopLeft,FrontPageBottomInsetter frontPageButtom){
		this.frontPageTopLeft=frontPageTopLeft;
		this.frontPageButtom=frontPageButtom;
	}

	public TextField getVerticalAngleText() {
		return frontPageTopLeft.getVerticalAngle();
	}

	public TextField getHorizontalAngleText() {
		return frontPageTopLeft.getHorizontalAngle();
	}

	public TextField getWeightValueText() {
		return frontPageTopLeft.getWeightValue();
	}

	public ComboBox<String> getWeightUnit() {
		return frontPageTopLeft.getWeightUnit();
	}

	public TableView<Beregning> getTable() {
		return frontPageButtom.getBeregningsTable();
	}
	public Canvas getTriangle(){
		return frontPageTopLeft.getTriangle();
	}
	
	
	public void setTriangle(Canvas triangle){
		frontPageTopLeft.setTriangle(triangle);
	}
	public void setHorizontalAngleText(TextField tf){
		frontPageTopLeft.setHorizontalAngle(tf);
	}
	public void setVerticalAngleText(TextField tf){
		frontPageTopLeft.setVerticalAngle(tf);
	}
}
