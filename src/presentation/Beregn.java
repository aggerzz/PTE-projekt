package presentation;

import exceptions.ArealEjDefineretException;
import exceptions.BoejningsMomentEjDefineretException;
import exceptions.BoejningsspaendingEjDefineretException;
import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.FlydeSpaendingEjDefineretException;
import exceptions.ForskydningsspaendingEjDefineretException;
import exceptions.HalvProfilhoejdeEjDefineretException;
import exceptions.InertimomentEjDefineretException;
import exceptions.LaengdeEjDefineretException;
import exceptions.NormalkraftEjDefineretException;
import exceptions.NormalspaendingEjDefineretException;
import exceptions.ReferenceSpaendingEjDefineretException;
import exceptions.SikkerhedsFaktorEjDefineretException;
import exceptions.TvaerkraftEjDefineretException;
import exceptions.VinkelEjDefineretException;
import exceptions.angivBoejningsspaendingEjDefineretException;
import logic.PTECalculatorController;

public class Beregn {

	public void beregn() {


		PTECalculatorController pte = FrontPage.getFrontPageMediator().getObserver().getPteCalc();
try{
		pte.getBoejningsMoment();
		pte.getBoejningsspaending();
		pte.getDimensionerendekraft();
		pte.getFlydeSpaending();
		pte.getHalvProfilhoejde();
		pte.getInertimoment();
		pte.getLaengde();
		pte.getNormalkraft();
		pte.getNormalspaending();
		pte.getSigmaRef();
		pte.getSikkerhedsfaktor();
		pte.getTvaerkraft();
		pte.getVinkel();
		pte.getBoejningsMomentMellemRegning();
		pte.getBoejningsspaendingMellemregning();
		pte.getDimensionerendekraftMellemregning();
		pte.getForskydningsspaendingMellemregning();
		pte.getNormalkraftMellemregning();
		pte.getNormalspaendingMellemregning();
		pte.getSikkerhedsfaktorMellemregning();
		pte.getTvaerkraftMellemregning();
		pte.beregnBoejningsMoment();
		pte.beregnBoejningsSpaending();
		pte.beregnForskydningsspaendning();
		pte.beregnNormalkraft();
		pte.beregnNormalspaending();
		pte.beregnSigmaRef();
		pte.beregnSikkerhedsFaktor();
		pte.beregnTvaerkraft();
		
	} catch (BoejningsMomentEjDefineretException | DimensionerendeKraftEjDefineretException
			| LaengdeEjDefineretException | BoejningsspaendingEjDefineretException
			| FlydeSpaendingEjDefineretException | HalvProfilhoejdeEjDefineretException
			| InertimomentEjDefineretException | NormalkraftEjDefineretException | VinkelEjDefineretException
			| NormalspaendingEjDefineretException | ReferenceSpaendingEjDefineretException
			| SikkerhedsFaktorEjDefineretException | TvaerkraftEjDefineretException
			| ForskydningsspaendingEjDefineretException | ArealEjDefineretException
			| angivBoejningsspaendingEjDefineretException e) {
		
		System.out.println("Beregn.beregn her fejl");
		
	}
	}
}
