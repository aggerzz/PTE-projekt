package presentation;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;

public class TriangleField extends StackPane {
	Canvas canvas;

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
}
