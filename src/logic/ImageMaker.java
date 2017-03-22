package logic;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.WritableImage;
import javafx.scene.shape.Path;
public class ImageMaker {

	public void canvasToImage(Canvas canvas){
		
		WritableImage writableImage = new WritableImage((int)canvas.getWidth(), (int)canvas.getHeight());
		canvas.snapshot(null, writableImage);
		RenderedImage ri = SwingFXUtils.fromFXImage(writableImage,null);
		
		try {
			ImageIO.write(ri, "png", new File("test.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
