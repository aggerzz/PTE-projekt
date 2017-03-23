package presentation;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.NegativKgException;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import logic.Enhed;

public class FrontPageMediator {
	FrontPageTopLeftInsetter frontPageTopLeft;
	FrontPageBottomInsetter frontPageBottom;
	FrontPageTopRightInsetter frontPageTopRight;
	PTEObserverImpl pteObs = new PTEObserverImpl(this);

	public FrontPageMediator(FrontPageTopLeftInsetter frontPageTopLeft, FrontPageBottomInsetter frontPageBottom,
			FrontPageTopRightInsetter frontPageTopRight) {
		this.frontPageTopLeft = frontPageTopLeft;
		this.frontPageBottom = frontPageBottom;
		this.frontPageTopRight = frontPageTopRight;
	}

	// Output felterne i PageBottom
	public TextField getFdimTextField() {
		return frontPageBottom.getFdimTextField();
	}

	public TextField getFtTextField() {
		return frontPageBottom.getFtTextField();
	}

	public TextField getFnTextField() {
		return frontPageBottom.getFnTextField();
	}

	public TextField getMBTextField() {
		return frontPageBottom.getMbTextField();
	}

	public TextField getTauTextField() {
		return frontPageBottom.getTauTextField();
	}

	public TextField getSigmaNTextField() {
		return frontPageBottom.getSigmaNTextField();
	}

	public TextField getSigmaBTextField() {
		return frontPageBottom.getSigmaBTextField();
	}

	public TextField getSigmaRefTextField() {
		return frontPageBottom.getSigmaRefTextField();
	}

	public TextField getSikkerhedsFaktorTextField() {
		return frontPageBottom.getSFTextField();
	}

	public TextArea getMellemRegninger() {
		return frontPageBottom.getMellemRegninger();
	}

	// Input felterne i FrontTopRight
	public TextField getLaengdeTextField() {
		return frontPageTopRight.laengde;
	}

	public TextField getArealText() {
		return frontPageTopRight.areal;
	}

	public TextField getInertimoment() {
		return frontPageTopRight.inertimoment;
	}

	public TextField getHalvHoejdeTextField() {
		return frontPageTopRight.halvhoejde;
	}

	public TextField getSigmaTillTextField() {
		return frontPageTopRight.sigmaTill;
	}

	// Get og set på Input felter i FrontPageTopLeft
	public TextField getVerticalAngleText() {
		return frontPageTopLeft.getVerticalAngle();
	}

	public void setVerticalAngleText(TextField tf) {
		frontPageTopLeft.setVerticalAngle(tf);
	}

	public TextField getHorizontalAngleText() {
		return frontPageTopLeft.getHorizontalAngle();
	}

	public void setHorizontalAngleText(TextField tf) {
		frontPageTopLeft.setHorizontalAngle(tf);
	}

	public TextField getWeightValueTextField() {
		return frontPageTopLeft.getWeightValueHBox().getWeightTextField();
	}

	public ComboBox<Enhed> getWeightUnitComboBox() {
		return frontPageTopLeft.getWeightValueHBox().getUnit();
	}

	public TriangleField getTriangle() {
		return frontPageTopLeft.getTriangle();
	}

	public void setTriangle(Canvas triangle) {
		frontPageTopLeft.setTriangle(triangle);
	}

	// De resterende
	public PTEObserverImpl getObserver() {
		return pteObs;
	}
	
	public void angivVaegt(double vaegt, Enhed enhed) throws NegativKgException{
		pteObs.getPteCalc().angivVaegt(vaegt, enhed);
	}
	public boolean ervaegtNormal() throws DimensionerendeKraftEjDefineretException{
		return pteObs.getPteCalc().erVaegtNormal();
		
	}

}
