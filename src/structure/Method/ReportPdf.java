package structure.Method;

import AddonsToImplement.PBSystem;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import controller.UserManager;
import structure.Singleton.SingletonPBSystem;
import view.UserPrompts;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class ReportPdf implements Report {
    private final Document documentPDF;
    private PBSystem pbSystem = new PBSystem();

    public ReportPdf(){

       documentPDF = new Document();
        try {
            String destinationReport = "reportPdf.pdf";
            PdfWriter.getInstance(this.documentPDF, new FileOutputStream(destinationReport));
            documentPDF.open();
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public void header() throws DocumentException {
        Paragraph title = new Paragraph();
        title.setAlignment(Element.HEADER);
        title.add(new Chunk("Relatório de acesso as Bases",new Font(Font.FontFamily.HELVETICA,24)));
        documentPDF.add(title);
    }

    @Override
    public void body() throws DocumentException {
        Paragraph middle = new Paragraph();
        middle.setAlignment(Element.LISTITEM);
        middle.add(new Chunk( "Users" +String.valueOf(SingletonPBSystem.getInstance().getLoggedUsers().toString()),new Font(Font.FontFamily.HELVETICA,12)));
        documentPDF.add(middle);

    }

    @Override
    public void print() {
        if(this.documentPDF != null && this.documentPDF.isOpen()){
           this.documentPDF.close();
        }
    }
}
