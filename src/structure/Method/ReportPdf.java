package structure.Method;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import controller.UserManager;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;


public class ReportPdf implements Report {

    private final Document documentPDF;
    private UserManager userManager = new UserManager();
    public ReportPdf(UserManager userManager){

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
        title.setAlignment(Element.ALIGN_TOP); 
        title.add(new Chunk("Relatório de acesso as Bases",new Font(Font.FontFamily.HELVETICA,24)));
        documentPDF.add(title);
    }

    @Override
    public void body() throws DocumentException {

        List list = new ArrayList<>();
        for (Object u : userManager.logged){
            list.add(u);
        }
        Paragraph middle = new Paragraph();
        middle.setAlignment(Element.BODY);
        documentPDF.add(middle);

    }

    @Override
    public void print() {
        if(this.documentPDF != null && this.documentPDF.isOpen()){
           this.documentPDF.close();
        }
    }
}
