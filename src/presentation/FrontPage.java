package presentation;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FrontPage {
	public static FrontPageMediator frontPageMediator; 

	public void start(Stage stage) {
		BorderPane root = new BorderPane();		
		Scene frontPage = new Scene(root);
		
		stage.setTitle("PTE Lommeregner");
				
		FrontPageTopLeftInsetter fptInsetter = new FrontPageTopLeftInsetter();
		FrontPageBottomInsetter fpbInsetter = new FrontPageBottomInsetter();
		FrontPageTopRightInsetter fptrInsetter = new FrontPageTopRightInsetter();
		
		root.setPadding(new Insets (10,20,10,20));
		root.setLeft(fptInsetter.insetLeft());
		root.setBottom(fpbInsetter.insetButtom());
		root.setRight(fptrInsetter.insetRight());
		
		frontPageMediator = new FrontPageMediator(fptInsetter,fpbInsetter);
		
		frontPageMediator.getWeightValueTextField().requestFocus();
		stage.setScene(frontPage);
		stage.setResizable(false);
		stage.show();
	}
	public static FrontPageMediator getFrontPageMediator(){
		return frontPageMediator;
	}

}
