package presentation;

import java.io.IOException;
import com.itextpdf.text.DocumentException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.PdfExporter;

public class FrontPageTopRightInsetter {
	private SletAlt sletAlt;
	TextField areal, inertimoment, halvhoejde, laengde, sigmaTill, boejningsmomentFt;

	public GridPane insetRight() {
		SuperSubStringHBox superSubStringHBox = new SuperSubStringHBox();

		GridPane gridRight = new GridPane();
		gridRight.setAlignment(Pos.TOP_LEFT);
		gridRight.setPadding(new Insets(0, 0, 0, 20));

		// Laengde
		Label laengdeLabel = new Label("Vandret længde:");
		laengde = new LaengdeTextField();
		Label mmlaengdeLabel = new Label("mm");
		HBox laengdeHBox = new HBox();
		laengdeHBox.setSpacing(2);
		laengdeHBox.setAlignment(Pos.BOTTOM_LEFT);
		laengdeHBox.getChildren().addAll(laengde, mmlaengdeLabel);

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

		// Flydespaending (SigmaTill)
		HBox sigmaTillHBox2 = superSubStringHBox.generateSubHBox("\u03C3", "Till");
		// Label sigmaTillLabel = new Label("SigmaTill:");
		sigmaTill = new SigmaTillTextField();
		HBox nmm2LabelHBox = superSubStringHBox.generateSuperHBox("N/mm", "2");
		HBox sigmaTillHBox = new HBox();
		sigmaTillHBox.setSpacing(2);
		sigmaTillHBox.setAlignment(Pos.BOTTOM_LEFT);
		sigmaTillHBox.getChildren().addAll(sigmaTill, nmm2LabelHBox);

		//Boejningsmoment udregn. med Ft (Kranarmen)
		HBox boejningsmomentFtHBoxLabel = superSubStringHBox.generateSubHBox("Længde af F", "N");
		boejningsmomentFt = new BoejningsmomentFtTextField();
		Label nmmLabel = new Label("mm");
		HBox boejningsmomentFtHBox = new HBox();
		boejningsmomentFtHBox.setSpacing(2);
		boejningsmomentFtHBox.setAlignment(Pos.BOTTOM_LEFT);
		boejningsmomentFtHBox.getChildren().addAll(boejningsmomentFt, nmmLabel);
		
		VBox samlingAfHBox = new VBox();
		samlingAfHBox.getChildren().addAll(laengdeLabel, laengdeHBox, boejningsmomentFtHBoxLabel, boejningsmomentFtHBox, arealLabel, arealHBox, inertimomentLabel,
				inertimomentHBox, halvhoejdeLabel, halvhoejdeHBox, sigmaTillHBox2, sigmaTillHBox);
		gridRight.add(samlingAfHBox, 0, 0);

		GridPane gridmini = new GridPane();
		VBox knapperVBox = new VBox();
		Button sletAltKnap = new Button("Slet Alt");
		sletAltKnap.setMinSize(150, 28);
		sletAltKnap.setOnAction(e -> {
			sletAlt = new SletAlt();
			sletAlt.doIt();
		});
		Button exporterTilPdfKnap = new Button("Exporter til pdf");
		exporterTilPdfKnap.setMinSize(150, 28);
		exporterTilPdfKnap.setOnAction(e -> {
			PdfExporter pdfExporter = new PdfExporter();
			try {
				pdfExporter.exportToPdf();
			} catch (DocumentException | IOException e1) {
			}
		});

		knapperVBox.getChildren().addAll(sletAltKnap, exporterTilPdfKnap);
		gridmini.add(knapperVBox, 0, 0);
		gridmini.setPadding(new Insets(30, 0, 0, 0));

		gridRight.add(gridmini, 0, 1);
		return gridRight;
	}
}
