package presentation;

import exceptions.ArealEjDefineretException;
import exceptions.ArmEjDefineretException;
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

		try {
			pte.getBoejningsMoment();
		} catch (BoejningsMomentEjDefineretException | DimensionerendeKraftEjDefineretException
				| LaengdeEjDefineretException e) {

		}
		try {
			pte.getBoejningsMomentMedFt();
		} catch (BoejningsMomentEjDefineretException | LaengdeEjDefineretException
				| DimensionerendeKraftEjDefineretException | TvaerkraftEjDefineretException | ArmEjDefineretException
				| VinkelEjDefineretException e2) {
		}
		try {
			pte.getBoejningsspaending();
      
		} catch (BoejningsspaendingEjDefineretException | LaengdeEjDefineretException | DimensionerendeKraftEjDefineretException | HalvProfilhoejdeEjDefineretException | InertimomentEjDefineretException e) {


		}
		try {
			pte.getFlydeSpaending();
		} catch (FlydeSpaendingEjDefineretException e) {

		}
		try {
			pte.getHalvProfilhoejde();
		} catch (HalvProfilhoejdeEjDefineretException e) {

		}
		try {
			pte.getInertimoment();
		} catch (InertimomentEjDefineretException e) {

		}
		try {
			pte.getLaengde();
		} catch (LaengdeEjDefineretException e) {

		}
		try {
			pte.getNormalkraft();
		} catch (NormalkraftEjDefineretException | DimensionerendeKraftEjDefineretException
				| VinkelEjDefineretException e) {

		}
		try {
			pte.getNormalspaending();
		} catch (NormalspaendingEjDefineretException | DimensionerendeKraftEjDefineretException

				| VinkelEjDefineretException | ArealEjDefineretException e1) {

		}
		try {
			pte.getSigmaRef();
		} catch (InertimomentEjDefineretException | HalvProfilhoejdeEjDefineretException | LaengdeEjDefineretException | ReferenceSpaendingEjDefineretException | DimensionerendeKraftEjDefineretException | VinkelEjDefineretException | NormalspaendingEjDefineretException | ArealEjDefineretException | BoejningsspaendingEjDefineretException | ForskydningsspaendingEjDefineretException | TvaerkraftEjDefineretException e) {

		}
		try {
			pte.getSikkerhedsfaktor();
		} catch (SikkerhedsFaktorEjDefineretException | FlydeSpaendingEjDefineretException
				| ReferenceSpaendingEjDefineretException | InertimomentEjDefineretException | HalvProfilhoejdeEjDefineretException | LaengdeEjDefineretException | DimensionerendeKraftEjDefineretException | VinkelEjDefineretException | NormalspaendingEjDefineretException | ArealEjDefineretException | BoejningsspaendingEjDefineretException | ForskydningsspaendingEjDefineretException | TvaerkraftEjDefineretException e) {

		}
		try {
			pte.getTvaerkraft();
		} catch (TvaerkraftEjDefineretException | DimensionerendeKraftEjDefineretException
				| VinkelEjDefineretException e) {

		}
		try {
			pte.getVinkel();
		} catch (VinkelEjDefineretException e1) {
		}
		try {
			pte.getBoejningsMomentMellemRegning();
		} catch (BoejningsMomentEjDefineretException e) {

		}
		try {
			pte.getBoejningsspaendingMellemregning();
		} catch (BoejningsspaendingEjDefineretException e) {

		}
		try {
			pte.getDimensionerendekraftMellemregning();
		} catch (DimensionerendeKraftEjDefineretException e) {

		}
		try {
			pte.getForskydningsspaendingMellemregning();
		} catch (ForskydningsspaendingEjDefineretException e) {

		}
		try {
			pte.getNormalkraftMellemregning();
		} catch (NormalkraftEjDefineretException | DimensionerendeKraftEjDefineretException
				| VinkelEjDefineretException e) {

		}
		try {
			pte.getNormalspaendingMellemregning();
		} catch (NormalspaendingEjDefineretException e) {

		}
		try {
			pte.getSikkerhedsfaktorMellemregning();
		} catch (SikkerhedsFaktorEjDefineretException | ReferenceSpaendingEjDefineretException
				| FlydeSpaendingEjDefineretException e) {

		}
		try {
			pte.getTvaerkraftMellemregning();
		} catch (TvaerkraftEjDefineretException | DimensionerendeKraftEjDefineretException
				| VinkelEjDefineretException e) {
		}
		try {
			pte.getDimensionerendekraft();
		} catch (DimensionerendeKraftEjDefineretException e) {
		}
		try {
			pte.beregnNormalkraft();
		} catch (DimensionerendeKraftEjDefineretException | VinkelEjDefineretException e) {
		}
		try {
			pte.beregnTvaerkraft();
		} catch (DimensionerendeKraftEjDefineretException | VinkelEjDefineretException e) {
		}
		try {
			pte.beregnBoejningsMoment();
		} catch (DimensionerendeKraftEjDefineretException | LaengdeEjDefineretException e) {
		}
		try {
			pte.beregnBoejningsMomentMedFt();
		} catch (TvaerkraftEjDefineretException | ArmEjDefineretException | DimensionerendeKraftEjDefineretException
				| VinkelEjDefineretException e) {
		}
		try {
			pte.beregnBoejningsSpaending();
		} catch (BoejningsMomentEjDefineretException | BoejningsspaendingEjDefineretException
				| HalvProfilhoejdeEjDefineretException | InertimomentEjDefineretException e) {
		}
		try {
			pte.beregnNormalspaending();
		} catch (DimensionerendeKraftEjDefineretException | VinkelEjDefineretException
				| NormalspaendingEjDefineretException | NormalkraftEjDefineretException | ArealEjDefineretException e) {
		}
		try {
			pte.beregnForskydningsspaendning();
		} catch (DimensionerendeKraftEjDefineretException | VinkelEjDefineretException
				| ForskydningsspaendingEjDefineretException | ArealEjDefineretException
				| TvaerkraftEjDefineretException e) {
		}
		try {
			pte.beregnSigmaRef();
		} catch (NormalspaendingEjDefineretException | BoejningsspaendingEjDefineretException | ForskydningsspaendingEjDefineretException e) {
			
		}
		try {
			pte.beregnSikkerhedsFaktor();
		} catch (ReferenceSpaendingEjDefineretException | FlydeSpaendingEjDefineretException e) {
		}

	}
}
