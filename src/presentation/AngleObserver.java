package presentation;

import javafx.scene.control.TextField;

public class AngleObserver {
	FrontPageMediator frontPageMediator;

	public AngleObserver() {
		frontPageMediator = FrontPage.frontPageMediator;
	}

	public void update(String newValue, TextField origin) {
		System.out.println(origin.getClass());
		if (validInput(newValue)) {
			if (origin.getClass().equals(VerticalAngleTextField.class)) {
				updateFields(origin, frontPageMediator.getHorizontalAngleText());
			}

			if (origin.getClass().equals(HorizontalAngleTextField.class)) {
				updateFields(origin, frontPageMediator.getVerticalAngleText());
			}
		}
		
	}

	private void updateFields(TextField origin, TextField otherField) {
		if (origin.getText().isEmpty()) {
			otherField.setDisable(false);
			otherField.setText("");
			origin.setText("");
		} else {
			otherField.setText(Integer.toString(90 - Integer.parseInt(origin.getText())));
			otherField.setDisable(true);

			frontPageMediator.setHorizontalAngleText(otherField);
			frontPageMediator.setTriangle(new TriangleDrawer().createTriangle(frontPageMediator.getTriangle(),
					Integer.parseInt(otherField.getText())));
		}
	}

	private boolean validInput(String input) {
		String regex = "1234567890.";
		for (int i = 0; i < input.length(); i++) {
			int j = i + 1;
			if (!regex.contains(input.substring(i, j))) {
				return false;
			}
		}
		return true;
	}

}
