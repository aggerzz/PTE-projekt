package application;

import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import logic.ImageMaker;
import presentation.FrontPage;
import presentation.TriangleDrawer;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		FrontPage fp = new FrontPage();
		fp.start(primaryStage);
	
	}

	public static void main(String[] args) {
		launch(args);
	}
}

















































/*bøh*/