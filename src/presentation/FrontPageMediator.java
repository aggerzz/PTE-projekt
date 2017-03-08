package presentation;

import Domain.Beregning;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FrontPageMediator {
	FrontPageTopLeftInsetter frontPage;
	FrontPageBottomInsetter frontPageButtom;
	
	public FrontPageMediator(FrontPageTopLeftInsetter frontPageTopLeft,FrontPageBottomInsetter frontPageButtom){
		this.frontPage=frontPageTopLeft;
		this.frontPageButtom=frontPageButtom;
	}

	public TextField getVerticalAngleText() {
		return frontPage.getVerticalAngle();
	}

	public TextField getHorizontalAngleText() {
		return frontPage.getHorizontalAngle();
	}

	public TextField getWeightValueText() {
		return frontPage.getWeightValue();
	}

	public ComboBox<String> getWeightUnit() {
		return frontPage.getWeightUnit();
	}

	public TableView<Beregning> getTable() {
		return frontPageButtom.beregningsTable;
	}

}
