package presentation;

import java.util.ArrayList;
import java.util.List;
import exceptions.DimensionerendeKraftEjDefineretException;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import logic.Enhed;

public class WeightHBox extends HBox {
	TextField weightTextField;
	ComboBox<Enhed> unit;

	public WeightHBox() {

		weightTextField = new TextField();
		weightTextField.setPromptText("Indsæt vægt");

		unit = new ComboBox<Enhed>(FXCollections.observableArrayList(insetUnitOptions()));
		unit.setValue(Enhed.KG);

		this.getChildren().addAll(weightTextField, unit);

		unit.setOnAction(e -> {
			refresh();
		});
		weightTextField.setOnKeyReleased(e -> {
			refresh();
		});
	}

	// De units der er i comboBox
	private List<Enhed> insetUnitOptions() {
		List<Enhed> unitOptions = new ArrayList<Enhed>();
		unitOptions.add(Enhed.GRAM);
		unitOptions.add(Enhed.KG);
		unitOptions.add(Enhed.TON);
		unitOptions.add(Enhed.NEWTON);
		return unitOptions;
	}

	public TextField getWeightTextField() {
		return weightTextField;
	}

	public void setWeightTextField(TextField weightTextField) {
		this.weightTextField = weightTextField;
	}

	public ComboBox<Enhed> getUnit() {
		return unit;
	}

	public void setUnit(ComboBox<Enhed> unit) {
		this.unit = unit;
	}

	public void refresh() {

		try {
			//sæt normalbaggrundsfarve
			if (!weightTextField.getText().isEmpty() && !weightTextField.getText().contains("-")) {
				FrontPage.frontPageMediator.getObserver().getPteCalc()
						.angivVaegt(Double.parseDouble(weightTextField.getText()), unit.getValue());
				//Tjek om vægten er normal
				//hvis unormal ændre baggrund til gul
			}
		} catch (DimensionerendeKraftEjDefineretException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
