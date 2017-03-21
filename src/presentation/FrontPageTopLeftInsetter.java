package presentation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class FrontPageTopLeftInsetter {
	TextField horizontalAngle;
	TextField verticalAngle;
	TextField areal;
	WeightHBox weightHBox;
	ComboBox<String> weightUnit;
	TriangleDrawer td = new TriangleDrawer();
	TriangleField trianglePane;

	public GridPane insetLeft() {
		Canvas startCanvas = new Canvas(300, 300);
		Canvas triangleCanvas = td.createTriangle(startCanvas, 40);
		GridPane beregnerGrid = new GridPane();
		beregnerGrid.setAlignment(Pos.TOP_LEFT);

		trianglePane = new TriangleField();
		trianglePane.setCanvas(triangleCanvas);
		trianglePane.getChildren().setAll(new NeedMoreInputTriangle());
		trianglePane.setPadding(new Insets(10,10,10,10));
		trianglePane.setPrefWidth(320);
		trianglePane.setPrefHeight(320);
		
		horizontalAngle = new HorizontalAngleTextField();
		Label vandretLabel = new Label("Vandret vinkel:");
		VBox vandretVBox = new VBox();
		vandretVBox.getChildren().addAll(vandretLabel,horizontalAngle);
		
		verticalAngle = new VerticalAngleTextField();
		Label lodretLabel = new Label("Lodret vinkel:");
		VBox lodretVBox = new VBox();
		lodretVBox.getChildren().addAll(lodretLabel,verticalAngle);
		
		weightHBox = new WeightHBox();
		Label weightLabel = new Label("Vægt:");
		VBox weightVBox = new VBox();
		weightVBox.getChildren().addAll(weightLabel,weightHBox);
		
		areal = new ArealTextField();
		Label arealLabel = new Label("Areal:");
		VBox arealVBox = new VBox();
		arealVBox.getChildren().addAll(arealLabel,areal);
		
		

//		if(Double.parseDouble(HorizontalAngleTextField.getText()))
		
		// for at få verticalAngle textFeltet på linje med trekanten
		GridPane verticalGrid = new GridPane();
		verticalGrid.add(lodretVBox, 0, 1);
		verticalGrid.add(arealVBox, 1, 1);
		verticalGrid.setHgap(5);

		beregnerGrid.add(vandretVBox, 0, 0);
		beregnerGrid.add(weightVBox, 1, 0);
		beregnerGrid.add(trianglePane, 0, 1, 1, 2);
		beregnerGrid.add(verticalGrid, 1, 2);
		beregnerGrid.setHgap(5);
		verticalGrid.setAlignment(Pos.BOTTOM_LEFT);
		
		return beregnerGrid;

	}

	public TextField getHorizontalAngle() {
		return horizontalAngle;
	}

	public void setHorizontalAngle(TextField horizontalAngle) {
		this.horizontalAngle = horizontalAngle;
	}

	public TextField getVerticalAngle() {
		return verticalAngle;
	}

	public void setVerticalAngle(TextField verticalAngle) {
		this.verticalAngle = verticalAngle;
	}

	public TextField getAreal() {
		return areal;
	}

	public void setAreal(TextField areal) {
		this.areal = areal;
	}

	public WeightHBox getWeightValueHBox() {
		return weightHBox;
	}

	public void setWeightValue(WeightHBox weightValue) {
		this.weightHBox = weightValue;
	}

	public TriangleField getTriangle() {
		return trianglePane;
	}

	public void setTriangle(Canvas triangle) {
		trianglePane.getChildren().setAll(triangle);
	}

}
