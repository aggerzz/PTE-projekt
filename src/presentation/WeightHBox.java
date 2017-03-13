package presentation;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class WeightHBox extends HBox {
	TextField weightTextField;
	ComboBox<String> unit;

	public WeightHBox() {

		weightTextField = new TextField();
		weightTextField.setPromptText("Inset weight");

		unit = new ComboBox<String>(FXCollections.observableArrayList(insetUnitOptions()));
		unit.setValue("Kg");

		this.getChildren().addAll(weightTextField, unit);

		unit.setOnAction(e -> {
		});
		weightTextField.setOnKeyReleased(e -> {

		});
	}

	// De units der er i comboBox
	private List<String> insetUnitOptions() {
		List<String> unitOptions = new ArrayList<String>();
		unitOptions.add("G");
		unitOptions.add("Kg");
		unitOptions.add("T");
		unitOptions.add("N");
		return unitOptions;
	}


	public TextField getWeightTextField() {
		return weightTextField;
	}

	public void setWeightTextField(TextField weightTextField) {
		this.weightTextField = weightTextField;
	}

	public ComboBox<String> getUnit() {
		return unit;
	}

	public void setUnit(ComboBox<String> unit) {
		this.unit = unit;
	}

}
