package presentation;

import java.text.DecimalFormat;

import exceptions.ArealEjDefineretException;
import exceptions.BoejningsMomentEjDefineretException;
import exceptions.BoejningsspaendingEjDefineretException;
import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.FlydeSpaendingEjDefineretException;
import exceptions.ForskydningsspaendingEjDefineretException;
import exceptions.LaengdeEjDefineretException;
import exceptions.NormalkraftEjDefineretException;
import exceptions.NormalspaendingEjDefineretException;
import exceptions.ReferenceSpaendingEjDefineretException;
import exceptions.SikkerhedsFaktorEjDefineretException;
import exceptions.TvaerkraftEjDefineretException;
import exceptions.VinkelEjDefineretException;
import logic.PTECalculatorController;
import logic.PTECalculatorControllerImpl;
import logic.PTEObserver;

public class PTEObserverImpl implements PTEObserver {
	FrontPageMediator frontPageMediator;
	PTECalculatorController pteCalc = new PTECalculatorControllerImpl();

	public PTEObserverImpl(FrontPageMediator fpm) {

		frontPageMediator = fpm;
		pteCalc.tilmeldObserver(this);
	}

	public void update() {
		frontPageMediator.getMellemRegninger().clear();
		   DecimalFormat formatter = new DecimalFormat("#0.000");
		    
		try {
			double fDim = pteCalc.getDimensionerendekraft();
			String fDimText = formatter.format(fDim); //TODO formater til 3 decimaler
			frontPageMediator.getFdimTextField().setText(fDimText );
			String fDimMellemregning = pteCalc.getDimensionerendekraftMellemregning();
			tilfoejMellemregning(fDimMellemregning);

		} catch (DimensionerendeKraftEjDefineretException e1) {
			frontPageMediator.getFdimTextField().clear();
		}
		
		try {
			double tvaerkraft = pteCalc.getTvaerkraft();
			String tvaerkraftText = formatter.format(tvaerkraft);
			frontPageMediator.getFtTextField().setText(tvaerkraftText);
			String tvaerkraftMellemregning = pteCalc.getTvaerkraftMellemregning();
			tilfoejMellemregning(tvaerkraftMellemregning);

		} catch (TvaerkraftEjDefineretException | DimensionerendeKraftEjDefineretException
				| VinkelEjDefineretException e1) {
			frontPageMediator.getFtTextField().clear();
		}
		
		try {			
			double normalkraft = pteCalc.getNormalkraft();
			String normalkraftText = formatter.format(normalkraft);
			frontPageMediator.getFnTextField().setText(normalkraftText);
			String normalkraftMellemregning = pteCalc.getNormalkraftMellemregning();
			tilfoejMellemregning(normalkraftMellemregning);

		} catch (NormalkraftEjDefineretException | DimensionerendeKraftEjDefineretException
				| VinkelEjDefineretException e1) {
			frontPageMediator.getFnTextField().clear();
		}
		 
		try {
			double forskydningsspaending = pteCalc.getForskydningsspaending();
			String forskydningsspaendingText = formatter.format(forskydningsspaending);
			
			frontPageMediator.getTauTextField().setText(forskydningsspaendingText);
			String forskydningsspaendingMellemregning = pteCalc.getForskydningsspaendingMellemregning();
			tilfoejMellemregning(forskydningsspaendingMellemregning);
		} catch (ForskydningsspaendingEjDefineretException | TvaerkraftEjDefineretException | ArealEjDefineretException| DimensionerendeKraftEjDefineretException
				| VinkelEjDefineretException  e1) {
			frontPageMediator.getTauTextField().clear();
			
		}	
		
		try {
			double normalspaending = pteCalc.getNormalspaending();
			String normalspaendingText = formatter.format(normalspaending);

			frontPageMediator.getSigmaNTextField().setText(normalspaendingText);
			String normalspaendingMellemregning = pteCalc.getNormalspaendingMellemregning();
			tilfoejMellemregning(normalspaendingMellemregning);

		} catch (NormalspaendingEjDefineretException | DimensionerendeKraftEjDefineretException
				| VinkelEjDefineretException e1) {
			frontPageMediator.getSigmaNTextField().clear();			
		}
			double boejningsSpaending;
			try {
				boejningsSpaending = pteCalc.getBoejningsspaending();
			
			String boejningsSpaendingText = formatter.format(boejningsSpaending);
			
			frontPageMediator.getSigmaBTextField().setText(boejningsSpaendingText);
			String boejningsSpaendingMellemRegninger = pteCalc.getBoejningsspaendingMellemregning();
			tilfoejMellemregning(boejningsSpaendingMellemRegninger);
			} catch (BoejningsspaendingEjDefineretException e) {
				frontPageMediator.getSigmaBTextField().clear();
			}
			
			try {
				double boejningsmoment = pteCalc.getBoejningsMoment();
				String boejningsmomentText = formatter.format(boejningsmoment);
				
				frontPageMediator.getMBTextField().setText(boejningsmomentText);
				String boejningsmomentMellemRegninger = pteCalc.getBoejningsMomentMellemRegning();
				tilfoejMellemregning(boejningsmomentMellemRegninger);

			} catch (BoejningsMomentEjDefineretException | DimensionerendeKraftEjDefineretException |LaengdeEjDefineretException e1) {
				frontPageMediator.getMBTextField().clear();			
			}
			try {
				double referencespaending = pteCalc.getSigmaRef();
				String referencespaendingText = formatter.format(referencespaending);

				frontPageMediator.getSigmaRefTextField().setText(referencespaendingText);
				String referenceSpaendingMellemRegning = pteCalc.ReferenceSpaendingGetMellemRegning();
				tilfoejMellemregning(referenceSpaendingMellemRegning);

			} catch (ReferenceSpaendingEjDefineretException e1) {
				frontPageMediator.getSigmaRefTextField().clear();			
			}
			try {
				double sikkerhedsfaktor = pteCalc.getSikkerhedsfaktor();
				String sikkerhedsfaktorText= formatter.format(sikkerhedsfaktor);

				frontPageMediator.getSikkerhedsFaktorTextField().setText(sikkerhedsfaktorText);
				String sikkerhedsfaktorMellemRegning = pteCalc.getSikkerhedsfaktorMellemregning();
				tilfoejMellemregning(sikkerhedsfaktorMellemRegning);

			} catch (SikkerhedsFaktorEjDefineretException | ReferenceSpaendingEjDefineretException | FlydeSpaendingEjDefineretException e1) {
				frontPageMediator.getSikkerhedsFaktorTextField().clear();			
			}
	}		
	private void tilfoejMellemregning(String mellemregning) {
		frontPageMediator.getMellemRegninger().appendText(mellemregning + "\n");

	}
	
	

	public PTECalculatorController getPteCalc() {
		
		return pteCalc;
	}
}
