package presentation;

import javafx.scene.layout.StackPane;

public class NeedMoreInputTriangle extends StackPane {
	public NeedMoreInputTriangle(){
		this.getChildren().setAll(new NeedMoreInputTriangleDrawer().drawTriangle());
	}
}
