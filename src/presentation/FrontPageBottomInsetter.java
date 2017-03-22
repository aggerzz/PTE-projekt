package presentation;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class FrontPageBottomInsetter {
	private TextField fdimTextField;
	private TextField ftTextField;
	private TextField fnTextField;
	private TextField mbTextField;
	private TextField tauTextField;
	private TextField sigmaNTextField;
	private TextField sigmaBTextField;
	private TextField sigmaRefTextField;
	private TextField sfTextField;
	private Label fdimEnhedLabel, ftEnhedLabel, fnEnhedLabel, mbEnhedLabel;
					
	private TextArea mellemRegninger;

	public GridPane insetButtom() {
		SuperSubStringHBox superSubStringHBox = new SuperSubStringHBox();

		GridPane buttomGrid = new GridPane();
		buttomGrid.setPadding(new Insets(20, 20, 20, 20));
		buttomGrid.setHgap(5);
		mellemRegninger = new TextArea();

		HBox fdimHBox = superSubStringHBox.generateSubHBox("F", "Dim");
		fdimTextField = new TextField();
		fdimTextField.setPromptText("Fdim");
		fdimTextField.setEditable(false);
		fdimEnhedLabel = new Label("N");
		
		HBox ftHBox = superSubStringHBox.generateSubHBox("F", "T");
		ftTextField = new TextField();
		ftTextField.setPromptText("Ft");
		ftTextField.setEditable(false);
		ftEnhedLabel = new Label("N");

		HBox fnHBox = superSubStringHBox.generateSubHBox("F", "N");
		fnTextField = new TextField();
		fnTextField.setPromptText("Fn");
		fnTextField.setEditable(false);
		fnEnhedLabel = new Label("N");

		Label mbLabel = new Label("MB: ");
		mbTextField = new TextField();
		mbTextField.setPromptText("MB");
		mbTextField.setEditable(false);
		mbEnhedLabel = new Label("N/mm");

		Label tauLabel = new Label("\u03C4: ");
		tauTextField = new TextField();
		tauTextField.setPromptText("Tau");
		tauTextField.setEditable(false);	
		HBox tauEnhedLabel = superSubStringHBox.generateSuperHBox("N/mm", "2");
		

		HBox sigmaNHBox = superSubStringHBox.generateSubHBox("\u03C3", "N");
		sigmaNTextField = new TextField();
		sigmaNTextField.setPromptText("sigmaN");
		sigmaNTextField.setEditable(false);
		HBox sigmaNEnhedLabel = superSubStringHBox.generateSuperHBox("N/mm", "2");

		HBox sigmaBHBox = superSubStringHBox.generateSubHBox("\u03C3", "B");
		sigmaBTextField = new TextField();
		sigmaBTextField.setPromptText("sigmaB");
		sigmaBTextField.setEditable(false);
		HBox sigmaBEnhedLabel = superSubStringHBox.generateSuperHBox("N/mm", "2");

		HBox sigmaRefHBox = superSubStringHBox.generateSubHBox("\u03C3", "Ref");
		sigmaRefTextField = new TextField();
		sigmaRefTextField.setPromptText("sigmaRef");
		sigmaRefTextField.setEditable(false);
		HBox sigmaRefEnhedLabel = superSubStringHBox.generateSuperHBox("N/mm", "2");

		Label sfLabel = new Label("SF: ");
		sfTextField = new TextField();
		sfTextField.setPromptText("SF");
		sfTextField.setEditable(false);
		
		// TODO mangler get og set motoder p�, MB - tau - sigmaN - sigmaB -
		// sigmaRef - SF

		buttomGrid.add(fdimHBox, 0, 0);
		buttomGrid.add(fdimTextField, 1, 0);
		buttomGrid.add(ftHBox, 0, 1);
		buttomGrid.add(ftTextField, 1, 1);
		buttomGrid.add(fnHBox, 0, 2);
		buttomGrid.add(fnTextField, 1, 2);
		buttomGrid.add(mbLabel, 0, 3);
		buttomGrid.add(mbTextField, 1, 3);
		buttomGrid.add(tauLabel, 0, 4);
		buttomGrid.add(tauTextField, 1, 4);
		buttomGrid.add(sigmaNHBox, 0, 5);
		buttomGrid.add(sigmaNTextField, 1, 5);
		buttomGrid.add(sigmaBHBox, 0, 6);
		buttomGrid.add(sigmaBTextField, 1, 6);
		buttomGrid.add(sigmaRefHBox, 0, 7);
		buttomGrid.add(sigmaRefTextField, 1, 7);
		buttomGrid.add(sfLabel, 0, 8);
		buttomGrid.add(sfTextField, 1, 8);
		
		buttomGrid.add(fdimEnhedLabel, 2, 0);
		buttomGrid.add(ftEnhedLabel, 2, 1);
		buttomGrid.add(fnEnhedLabel, 2, 2);
		buttomGrid.add(mbEnhedLabel, 2, 3);
		buttomGrid.add(tauEnhedLabel, 2, 4);
		buttomGrid.add(sigmaNEnhedLabel, 2, 5);
		buttomGrid.add(sigmaBEnhedLabel, 2, 6);
		buttomGrid.add(sigmaRefEnhedLabel, 2, 7);

		buttomGrid.add(mellemRegninger, 3, 0, 4, 10);

		return buttomGrid;
	}

	// Get og set metoderne på tekstfields

	public TextArea getMellemRegninger() {
		return mellemRegninger;
	}

	public void setMellemRegninger(TextArea mellemRegninger) {
		this.mellemRegninger = mellemRegninger;
	}

	public TextField getFdimTextField() {
		return fdimTextField;
	}

	public void setFdimTextField(TextField FdimTextField) {
		fdimTextField = FdimTextField;
	}

	public TextField getFtTextField() {
		return ftTextField;
	}

	public void setFtTextField(TextField FtTextField) {
		ftTextField = FtTextField;
	}

	public TextField getFnTextField() {
		return fnTextField;
	}

	public void setFnTextField(TextField FnTextField) {
		fnTextField = FnTextField;
	}

	public TextField getMbTextField() {
		return mbTextField;
	}

	public void setMbTextField(TextField MbTextField) {
		mbTextField = MbTextField;
	}

	public TextField getTauTextField() {
		return tauTextField;
	}

	public void setTauTextField(TextField TauTextField) {
		tauTextField = TauTextField;
	}

	public TextField getSigmaNTextField() {
		return sigmaNTextField;
	}

	public void setSigmaNTextField(TextField SigmaNTextField) {
		sigmaNTextField = SigmaNTextField;
	}

	public TextField getSigmaBTextField() {
		return sigmaBTextField;
	}

	public void setSigmaBTextField(TextField SigmaBTextField) {
		sigmaBTextField = SigmaBTextField;
	}

	public TextField getSigmaRefTextField() {
		return sigmaRefTextField;
	}

	public void setSigmaRefTextField(TextField SigmaRefTextField) {
		sigmaRefTextField = SigmaRefTextField;
	}

	public TextField getSFTextField() {
		return sfTextField;
	}

	public void setSFTextField(TextField SFTextField) {
		sfTextField = SFTextField;
	}
}