package structure.Method;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

public interface Report {
    void  header() throws DocumentException;
   void body() throws DocumentException;
   void print();

}