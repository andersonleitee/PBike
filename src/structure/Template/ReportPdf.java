package structure.Template;

import AddonsToImplement.PBSystem;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import structure.Singleton.SingletonPBSystem;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class ReportPdf extends Report {

    private final Document documentPDF;

    //private UserManager userManager = new UserManager();
    public ReportPdf(){

       documentPDF = new Document();
        try {
            String destinationReport = "reportPdf.pdf";
            PdfWriter.getInstance(this.documentPDF, new FileOutputStream(destinationReport));
            documentPDF.open();
        } catch (DocumentException | FileNotFoundException e) {
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
