package structure.Method;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import model.Dock.Dock;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class ReportPdf implements Report {
    private Dock takeBike;
    private Document documentPDF;

    public ReportPdf(Dock takeBike){
        this.takeBike = takeBike;
        this.documentPDF = new Document();
        try {
            String destinationReport = "reportPdf.pdf";
            PdfWriter.getInstance(this.documentPDF, new FileOutputStream(destinationReport));
            this.documentPDF.open();
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public void gerarCabecalho() throws DocumentException {
        Paragraph title = new Paragraph();
        title.setAlignment(Element.ALIGN_TOP); 
        title.add(new Chunk("Relatório de acesso as Bases",new Font(Font.FontFamily.HELVETICA,24)));
        this.documentPDF.add(title);
    }

//    @Override
//    public void gerarCorpo() {
//
//    }
//
//    @Override
//    public void gerarRodape() {
//
//    }
//
//    @Override
//    public void imprimir() {
//
//    }
}
