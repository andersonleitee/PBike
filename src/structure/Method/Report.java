package structure.Method;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

import java.io.IOException;

public interface Report {
    void  header() throws DocumentException;
   void body() throws DocumentException, IOException;
   void print() throws DocumentException, IOException;

}