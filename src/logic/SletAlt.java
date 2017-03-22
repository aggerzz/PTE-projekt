package logic;

import presentation.FrontPage;
import presentation.FrontPageMediator;
import presentation.NeedMoreInputTriangle;

public class SletAlt {
	
	
		
	
	public void doIt(){
		FrontPageMediator fpm = FrontPage.frontPageMediator;
		
		fpm.getWeightValueTextField().clear();
		fpm.getVerticalAngleText().clear();
		fpm.getHorizontalAngleText().clear();
		fpm.getFdimTextField().clear();
		fpm.getFtTextField().clear();
		fpm.getFnTextField().clear();
		fpm.getMBTextField().clear();
		fpm.getSigmaBTextField().clear();
		fpm.getSigmaNTextField().clear();
		fpm.getSigmaRefTextField().clear();
		fpm.getSikkerhedsFaktorTextField().clear();
		fpm.getMellemRegninger().clear();
		fpm.getArealText().clear();
		fpm.getTriangle().getChildren().setAll(new NeedMoreInputTriangle());
		fpm.getHalvHoejdeTextField().clear();
		fpm.getLaengdeTextField().clear();
	}
}
