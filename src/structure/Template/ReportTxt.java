package structure.Template;


import com.itextpdf.text.DocumentException;
import structure.Singleton.SingletonPBSystem;


import java.io.*;

public class ReportTxt extends Report {
    public ReportTxt() throws IOException {
  

        File arq = new File("report.txt");
        FileWriter fileWriter = new FileWriter(arq);
        this.buffer = new BufferedWriter(fileWriter);
        buffer.write(SingletonPBSystem.getInstance().getLoggedUsers().toString());
        buffer.close();
        fileWriter.close();
    }



    @Override
    public void header() throws DocumentException {

    }

    @Override
    public void body() throws DocumentException, IOException {


    }

    @Override
    public void print() throws DocumentException, IOException {
       buffer.close();
    }



}
