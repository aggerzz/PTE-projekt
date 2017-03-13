package observers;

import java.math.BigDecimal;

import logic.PTECalcController;
import logic.UnitConverter;
import presentation.FrontPage;
import presentation.FrontPageMediator;
import domain.FDim;

public class TimeToCalculateObserver {
	FrontPageMediator frontPageMediator;

	public TimeToCalculateObserver() {
		frontPageMediator = FrontPage.frontPageMediator;
	}

	public void update() {
		String weight = frontPageMediator.getWeightValueTextField().getText();
		String unit = frontPageMediator.getWeightUnitComboBox().getValue();

		if (ValidInput(weight, unit)) {
			
			BigDecimal weightInKg = new UnitConverter().convertToKg(weight, unit);
			BigDecimal Fdim = new PTECalcController().calculateFdim(weightInKg);

			frontPageMediator.getFdimTextField().setText(Fdim.setScale(3, BigDecimal.ROUND_HALF_UP).toString() + " N ");
		}
	}

	private boolean ValidInput(String weight, String unit) {
		
		if (weight.contains(",")) {
			weight = weight.replaceAll(",", ".");
		}
		
		if (!weight.isEmpty() && !unit.isEmpty() && !weight.isEmpty() && !weight.contains("-") ) {
			return true;
		} else
			return false;
	}
}
