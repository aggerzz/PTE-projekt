package presentation;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class TriangleDrawer extends Canvas {

	public Canvas createTriangle(Canvas canvas, double vGrad) {
		if (vGrad > 90) {
			vGrad = vGrad - ((int) vGrad / 90) * 90;
		}
		if (vGrad < 0) {
			vGrad = vGrad - 2 * vGrad;
		}

		double x2 = 3 * (90 - vGrad);
		double x1 = 0;

		double vRad = (vGrad / 360) * (2 * Math.PI);

		double y1 = 0;
		double y2 = x2 * Math.tan(vRad);

		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

		gc.setStroke(Color.RED);
		tegnLinje(gc, 0, 0, x2, 0);

		gc.setStroke(Color.BLACK);
		gc.setLineWidth(3);
		tegnLinje(gc, x1, y1, x2, y2);

		gc.setStroke(Color.GREEN);
		drawLineWithArrow(gc, x2, y2, x2, y1);
		
		return canvas;

	}

	private void tegnLinje(GraphicsContext gc, double x1, double y1, double x2, double y2) {
		double padding = 25;
		double height = gc.getCanvas().getHeight() - 2 * padding;

		y1 = -y1 + height;
		y2 = -y2 + height;

		x1 = x1 + padding;
		x2 = x2 + padding;

		y1 = y1 + padding;
		y2 = y2 + padding;

		gc.strokeLine(x1, y1, x2, y2);

	}

	private void drawLineWithArrow(GraphicsContext gc, double x1, double y1, double x2, double y2) {
		double padding = 25;
		double height = gc.getCanvas().getHeight() - 2 * padding;

		y1 = -y1 + height;
		y2 = -y2 + height;

		x1 = x1 + padding;
		x2 = x2 + padding;

		y1 = y1 + padding;
		y2 = y2 + padding;

		gc.strokeLine(x2, y2, x2, y1);

		gc.setFill(Color.BLACK);
		gc.fillPolygon(new double[] { x2, x2 + 5, x2 - 5 }, new double[] { y2, y2 - 10, y2 - 10 }, 3);
	}

}
