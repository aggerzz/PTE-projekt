package logic;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageType;
import com.itextpdf.io.image.Jpeg2000ImageData;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.io.image.JpegImageData;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import presentation.FrontPage;
import presentation.FrontPageMediator;

public class PdfExporter {
	FrontPageMediator fpm;
	Document document;

	public PdfExporter() {
		fpm = FrontPage.getFrontPageMediator();
	}

	public void exportToPdf() {
		String placement = "C:\\PTE-Projekt pdf document";
		List<TextField> TFList = new ListMaker().getTextFields();
		Canvas triangle = fpm.getTriangle().getCanvas();
		TextArea mellemRegninger = fpm.getMellemRegninger();

		PdfWriter writer;
		try {
			writer = new PdfWriter(placement);

			PdfDocument pdf = new PdfDocument(writer);
			document = new Document(pdf);
			
			addTextFields();
			addMellemRegninger(mellemRegninger);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addTextFields() {
		document.add(new Paragraph("Fdim 	= " + fpm.getFdimTextField().getText()+ "\n"));
		document.add(new Paragraph("Ft 		= " + fpm.getFtTextField().getText()+ "\n"));
		document.add(new Paragraph("Fn 		= " + fpm.getFnTextField().getText()+ "\n"));
		document.add(new Paragraph("Mb 		= " + fpm.getMBTextField().getText()+ "\n"));
		document.add(new Paragraph("Tau		= " + fpm.getTauTextField().getText()+ "\n"));
		document.add(new Paragraph("SigmaN 	= " + fpm.getSigmaNTextField().getText()+ "\n"));
		document.add(new Paragraph("SigmaB	= " + fpm.getSigmaBTextField().getText()+ "\n"));
		document.add(new Paragraph("SigmaRef= " + fpm.getSigmaRefTextField().getText()+ "\n"));
		document.add(new Paragraph("SF		= " + fpm.getSikkerhedsFaktorTextField().getText()+ "\n"));
	}

	public void addMellemRegninger(TextArea mellemRegninger) {
		document.add(new Paragraph("\n\n"));
		document.add(new Paragraph(mellemRegninger.getText()));
	}

}
