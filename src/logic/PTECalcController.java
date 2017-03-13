package logic;

import java.math.BigDecimal;

import domain.FDim;
import exceptions.FDimEjDefineret;
import exceptions.NegativKgException;
import javafx.scene.control.TextArea;
import presentation.FrontPage;

public class PTECalcController {
	TextArea mellemRegninger;

	public PTECalcController() {
		mellemRegninger = FrontPage.frontPageMediator.getMellemRegninger();
	}

	public BigDecimal calculateFdim(BigDecimal Kg) {
		mellemRegninger.setText(Kg + "Kg * 9.816 N = Fdim");
		return FDim.beregnDimensionerendeKraft(Kg);
	}

	public void angivVaegt(BigDecimal Kg, FDim fdim) {
		if (Kg.compareTo(new BigDecimal("0")) != -1) {
			fdim.setKg(Kg);
			fdim.setMellemRegning(Kg.toString() + "Kg * " + FDim.getTyngdekraft() + " N ");
		} else {
			NegativKgException.Instantiate("Den dimensionerende kraft blev ikke angivet");
		}
	}
}
