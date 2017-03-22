package logic;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.TextField;
import presentation.FrontPage;
import presentation.FrontPageMediator;

public class ListMaker {
	FrontPageMediator fpm;
	public ListMaker(){
		fpm = FrontPage.getFrontPageMediator();
	}
	public List<TextField> getTextFields(){
		List<TextField> TFList = new ArrayList<TextField>();
		
		addTextField(fpm.getFdimTextField(), TFList);
		addTextField(fpm.getFtTextField(), TFList);
		addTextField(fpm.getFnTextField(),TFList);
		addTextField(fpm.getMBTextField(),TFList);
		addTextField(fpm.getTauTextField(),TFList);
		addTextField(fpm.getSigmaNTextField(),TFList);
		addTextField(fpm.getSigmaBTextField(),TFList);
		addTextField(fpm.getSigmaRefTextField(),TFList);
		addTextField(fpm.getSikkerhedsFaktorTextField(),TFList);
	
		return TFList;
	}
	public void addTextField(TextField tf, List<TextField> TFList){
		if(!tf.getText().isEmpty()){
			TFList.add(tf);
		}
	}
}
