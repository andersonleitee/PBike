package structure.Template;

import com.itextpdf.text.DocumentException;

import java.io.IOException;

public abstract class Report {

    void header() throws DocumentException {

    }

    void body() throws DocumentException, IOException {

    }

    void print() throws IOException {

    }
}
