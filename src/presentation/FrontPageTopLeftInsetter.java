package presentation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class FrontPageTopLeftInsetter {
	TextField horizontalAngle;
	TextField verticalAngle;
	TextField areal;
	WeightHBox weightHBox;
	ComboBox<String> weightUnit;
	TriangleDrawer td = new TriangleDrawer();
	TriangleField trianglePane;

	public GridPane insetLeft() {
		Canvas startCanvas = new Canvas(150, 150);
		Canvas triangleCanvas = td.createTriangle(startCanvas, 40);
		GridPane beregnerGrid = new GridPane();
		beregnerGrid.setAlignment(Pos.TOP_LEFT);

		beregnerGrid.setGridLinesVisible(false);
		trianglePane = new TriangleField();
		trianglePane.setPadding(new Insets(20, 20, 20, 20));
		trianglePane.setCanvas(triangleCanvas);
		trianglePane.getChildren().setAll(new NeedMoreInputTriangle());

		horizontalAngle = new HorizontalAngleTextField();
		verticalAngle = new VerticalAngleTextField();
		areal = new ArealTextField();
		weightHBox = new WeightHBox();

//		if(Double.parseDouble(HorizontalAngleTextField.getText()))
		
		// for at få verticalAngle textFeltet på linje med trekanten
		GridPane verticalGrid = new GridPane();
		verticalGrid.add(verticalAngle, 0, 1);
		verticalGrid.add(areal, 1, 1);
		verticalGrid.setHgap(5);

		beregnerGrid.add(horizontalAngle, 0, 0);
		beregnerGrid.add(weightHBox, 1, 0);
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
