package presentation;

import java.util.ArrayList;
import java.util.List;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.erUnderFejlgraenseException;
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

		if (!weightTextField.getText().isEmpty() && !weightTextField.getText().contains("-")) {

			try {
				// sæt normalbaggrundsfarve
				if (!weightTextField.getText().isEmpty() && !weightTextField.getText().contains("-")) {
					char sidsteBogstav = weightTextField.getText().charAt(weightTextField.getLength()-1);
					if(!(sidsteBogstav >= '0' && sidsteBogstav <= '9' || sidsteBogstav == ',' || sidsteBogstav == '.' )){										
						String tekst = weightTextField.getText().substring(0, weightTextField.getText().length()-1 );
						System.out.println(tekst);
						weightTextField.setText(tekst);
						weightTextField.positionCaret(100);
					}				
					FrontPage.frontPageMediator.getObserver().getPteCalc()
							.angivVaegt(Double.parseDouble(weightTextField.getText()), unit.getValue());
				}
			} catch (NumberFormatException | DimensionerendeKraftEjDefineretException | erUnderFejlgraenseException e) {
				e.printStackTrace();
				// Tjek om vægten er normal
				// hvis unormal ændre baggrund til gul
			}
		}

	}

}
