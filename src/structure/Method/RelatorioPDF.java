package structure.Method;

import structure.Facade.ManagersFacade;

public class RelatorioPDF implements Relatorio{

    private ManagersFacade takeBike;
    // private Document documentoPDF;
    private String caminhoRelatorio = "RelatorioPDF.pdf";

    public RelatorioPDF(ManagersFacade takeBike){
        this.takeBike = takeBike;
        //this.documentoPDF = new Document();
        //PdfWriter.getInstance(this.documentoPDF, new fileOutputStream(caminhoRelatorio));
        //this.documetoPDF.open();
        //importar try catch


    }
    @Override
    public void gerarCabecalho() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void gerarCorpo() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void gerarRodape() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void imprimir() {
        // TODO Auto-generated method stub
        
    }

}