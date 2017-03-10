package presentation;

import javafx.scene.control.TextField;

public class AngleObserver {
	FrontPageMediator frontPageMediator;

	public AngleObserver() {
		frontPageMediator = FrontPage.frontPageMediator;
	}

	public void update(String newValue, TextField origin) {
		if (validInput(newValue)) {
			if(origin.getClass().equals(VerticalAngleTextField.class)){
				TextField otherField = frontPageMediator.getHorizontalAngleText();
				if (!origin.getText().isEmpty()) {
					
					double verticalAngle = Double.parseDouble(origin.getText());
					
					otherField.setText(Double.toString(90 - verticalAngle));
					otherField.setDisable(true);
					
					frontPageMediator.setTriangle(new TriangleDrawer().createTriangle(frontPageMediator.getTriangle(), verticalAngle));
					
				} else {
					otherField.setDisable(false);
					otherField.setText("");
					origin.setText("");
				}
			}
			if(origin.getClass().equals(HorizontalAngleTextField.class)){
				TextField otherField = frontPageMediator.getVerticalAngleText();
				
				if(!origin.getText().isEmpty()){
					double verticalAngle = 90 - Double.parseDouble(origin.getText());
					
					otherField.setText(Double.toString(verticalAngle));
					otherField.setDisable(true);
					
					
					frontPageMediator.setTriangle(new TriangleDrawer().createTriangle(frontPageMediator.getTriangle(), verticalAngle));
					
				}
				else{
					otherField.setDisable(false);
					otherField.setText("");
					origin.setText("");
				}
			}
		}
	}


	private boolean validInput(String input) {
		String regex = "1234567890.";
		for (int i = 0; i < input.length(); i++) {
			int j = i + 1;
			if (!regex.contains(input.substring(i, j))) {
				return false;
			}
			// TODO : hvis input indeholder komma, skal komma omskrives til
			// punktum.
		}
		return true;
	}

}
