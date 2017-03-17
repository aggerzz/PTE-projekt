package presentation;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class SuperSubStringHBox {

	public HBox generateSuperHBox(String firstString, String secondString) {
		HBox hbox = new HBox();
		Label labelFirst = new Label();
		Label labelSecond = new Label();
		Label labelColon = new Label(":");
		
		labelFirst.setText(firstString);
		labelSecond.setText(secondString);
		labelSecond.setFont(new Font("Areal", 7));

		hbox.setAlignment(Pos.TOP_LEFT);
		hbox.getChildren().addAll(labelFirst, labelSecond, labelColon);

		return hbox;
	}
	public HBox generateSubHBox(String firstString, String secondString) {
		HBox hbox = new HBox();
		Label labelFirst = new Label();
		Label labelSecond = new Label();
		Label labelColon = new Label(":");

		labelFirst.setText(firstString);
		labelSecond.setText(secondString);
		labelSecond.setFont(new Font("Areal", 7));

		hbox.setAlignment(Pos.BOTTOM_LEFT);
		hbox.getChildren().addAll(labelFirst, labelSecond, labelColon);

		return hbox;
	}
}
