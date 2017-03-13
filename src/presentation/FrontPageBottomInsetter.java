package presentation;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class FrontPageBottomInsetter {
	private TextField FdimTextField;
	private TextArea mellemRegninger;

	public GridPane insetButtom() {

		GridPane buttomGrid = new GridPane();
		buttomGrid.setPadding(new Insets(20,20,20,20));
		mellemRegninger = new TextArea();

		HBox Fdim = new HBox();
		Label FdimLabel = new Label("Fdim: ");
		FdimTextField = new TextField();

		FdimTextField.setPromptText("Fdim");
		Fdim.getChildren().addAll(FdimLabel, FdimTextField);
		
		buttomGrid.add(Fdim, 0, 0);
		buttomGrid.add(mellemRegninger, 5, 0,10,10);

		return buttomGrid;
	}

	public TextField getFdimTextField() {
		return FdimTextField;
	}

	public void setFdimTextField(TextField fdimTextField) {
		FdimTextField = fdimTextField;
	}

	public TextArea getMellemRegninger() {
		return mellemRegninger;
	}

	public void setMellemRegninger(TextArea mellemRegninger) {
		this.mellemRegninger = mellemRegninger;
	}
	

}