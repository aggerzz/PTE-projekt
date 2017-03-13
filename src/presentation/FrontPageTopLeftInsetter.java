package presentation;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class FrontPageTopLeftInsetter {
	TextField horizontalAngle;
	TextField verticalAngle;
	TextField weightValue;
	ComboBox<String> weightUnit;
	Canvas triangle;
	TriangleDrawer td = new TriangleDrawer();

	public GridPane insetLeft() {
		Canvas canvas = new Canvas(150,150);
		GridPane beregnerGrid = new GridPane();
		beregnerGrid.setAlignment(Pos.TOP_LEFT);

		beregnerGrid.setGridLinesVisible(true);

		StackPane trianglePane = new StackPane();
		trianglePane.setPadding(new Insets(20, 20, 20, 20));
		horizontalAngle = new HorizontalAngleTextField();
		verticalAngle = new VerticalAngleTextField();
		weightValue = new TextField();
		weightUnit = new ComboBox<String>(FXCollections.observableArrayList( insetUnitOptions() ));
		weightUnit.setValue("Kg");
		

		triangle = td.createTriangle(canvas,40);
		
		//for at få verticalAngle textFeltet på linje med trekanten
		GridPane verticalGrid = new GridPane();
		verticalGrid.setGridLinesVisible(true);
		verticalGrid.add(verticalAngle, 0, 1);
		verticalGrid.setPadding(new Insets(125, 0, 0, 0));

		weightValue.setPromptText("inset weight");

		beregnerGrid.add(horizontalAngle, 0, 0);
		beregnerGrid.add(weightValue, 1, 0);
		beregnerGrid.add(weightUnit, 2, 0);
		beregnerGrid.add(triangle, 0, 1,1,2);
		beregnerGrid.add(verticalGrid, 1, 2);
		
		return beregnerGrid;

	}
	//De units der er i comboBox
	private List<String> insetUnitOptions() {
		List<String> unitOptions = new ArrayList<String>();
		unitOptions.add("G");
		unitOptions.add("Kg");
		unitOptions.add("T");
		unitOptions.add("N");
		return unitOptions;
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

	public TextField getWeightValue() {
		return weightValue;
	}

	public void setWeightValue(TextField weightValue) {
		this.weightValue = weightValue;
	}

	public ComboBox<String> getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(ComboBox<String> weightUnit) {
		this.weightUnit = weightUnit;
	}
	public Canvas getTriangle() {
		return triangle;
	}
	public void setTriangle(Canvas triangle) {
		this.triangle = triangle;
	}
	

}
