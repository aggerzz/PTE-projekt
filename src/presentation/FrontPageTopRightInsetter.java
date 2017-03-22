package presentation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sun.misc.Cleaner;

public class FrontPageTopRightInsetter {
	TextField areal, inertimoment, halvhoejde;

	public GridPane insetRight() {
		SuperSubStringHBox superSubStringHBox = new SuperSubStringHBox();

		GridPane gridRight = new GridPane();
		gridRight.setAlignment(Pos.TOP_LEFT);
		gridRight.setPadding(new Insets(0, 0, 0, 20));

		// Areal
		Label arealLabel = new Label("Areal:");
		areal = new ArealTextField();
		HBox mm2LabelHBox = superSubStringHBox.generateSuperHBox("mm", "2");
		HBox arealHBox = new HBox();
		arealHBox.setSpacing(2);
		arealHBox.setAlignment(Pos.BOTTOM_LEFT);
		arealHBox.getChildren().addAll(areal, mm2LabelHBox);

		// Inertimoment
		Label inertimomentLabel = new Label("I:");
		inertimoment = new InertimomentTextField();
		HBox mm4LabelHBox = superSubStringHBox.generateSuperHBox("mm", "4");
		HBox inertimomentHBox = new HBox();
		inertimomentHBox.setSpacing(2);
		inertimomentHBox.setAlignment(Pos.BOTTOM_LEFT);
		inertimomentHBox.getChildren().addAll(inertimoment, mm4LabelHBox);

		// Halvhoejde (e)
		Label halvhoejdeLabel = new Label("e:");
		halvhoejde = new HalvHoejdeTextField();
		Label mmLabel = new Label("mm");
		HBox halvhoejdeHBox = new HBox();
		halvhoejdeHBox.setSpacing(2);
		halvhoejdeHBox.setAlignment(Pos.BOTTOM_LEFT);
		halvhoejdeHBox.getChildren().addAll(halvhoejde, mmLabel);

		VBox samlingAfHBox = new VBox();
		samlingAfHBox.getChildren().addAll(arealLabel, arealHBox, inertimomentLabel, inertimomentHBox, halvhoejdeLabel,
				halvhoejdeHBox);
		gridRight.add(samlingAfHBox, 0, 0);

		GridPane gridmini = new GridPane();
		VBox knapperVBox = new VBox();
		Button sletAltKnap = new Button("Slet Alt");
		sletAltKnap.setMinSize(150, 22);
		sletAltKnap.setOnAction(e -> {
			// mangler en funktion som sletter indhold i input/outputfelter (MN)
		});
		Button exporterTilPdfKnap = new Button("Exporter til pdf");
		exporterTilPdfKnap.setMinSize(150, 22);
		exporterTilPdfKnap.setOnAction(e -> {
			//mangler forbindelse til funktionen exporterPDF (MN)
		});
		knapperVBox.getChildren().addAll(sletAltKnap, exporterTilPdfKnap);
		gridmini.add(knapperVBox, 0, 0);
		gridmini.setPadding(new Insets(30, 0, 0, 0));
		
		gridRight.add(gridmini, 0, 1);
		return gridRight;
	}

}
