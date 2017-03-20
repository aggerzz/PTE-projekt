package presentation;

import java.util.ArrayList;
import java.util.List;

import exceptions.ArealEjDefineretException;
import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.ForskydningsspaendingEjDefineretException;
import exceptions.TvaerkraftEjDefineretException;
import exceptions.VinkelEjDefineretException;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import logic.PTECalculatorController;
import logic.PTECalculatorControllerImpl;
import logic.UnitConverter;

public class WeightHBox extends HBox {
	TextField weightTextField;
	ComboBox<String> unit;

	public WeightHBox() {

		weightTextField = new TextField();
		weightTextField.setPromptText("Insert weight");

		unit = new ComboBox<String>(FXCollections.observableArrayList(insetUnitOptions()));
		unit.setValue("Kg");

		this.getChildren().addAll(weightTextField, unit);

		unit.setOnAction(e -> {
		});
		weightTextField.setOnKeyReleased(e -> {

			try {
				if (!weightTextField.getText().isEmpty() && !weightTextField.getText().contains("-")) {
					FrontPage.frontPageMediator.getObserver().getPteCalc()
							.angivVaegt(new UnitConverter().convertToKg(weightTextField.getText(), unit.getValue()));
				}
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (DimensionerendeKraftEjDefineretException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				FrontPage.frontPageMediator.getObserver().getPteCalc().beregnNormalkraft();
			} catch (DimensionerendeKraftEjDefineretException | VinkelEjDefineretException e2) {
				// Gør ingen ting
			}
			try {
				FrontPage.frontPageMediator.getObserver().getPteCalc().beregnTvaerkraft();
			} catch (DimensionerendeKraftEjDefineretException | VinkelEjDefineretException e2) {
				// Gør ingen ting
			}

			try {
				FrontPage.frontPageMediator.getObserver().getPteCalc().beregnForskydningsspaendning();
			} catch (DimensionerendeKraftEjDefineretException | VinkelEjDefineretException
					| ForskydningsspaendingEjDefineretException | ArealEjDefineretException
					| TvaerkraftEjDefineretException e1) {
				// Gør ingen ting
			}
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
