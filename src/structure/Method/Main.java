package structure.Method;

import com.itextpdf.text.DocumentException;
import controller.UserManager;
import model.User.User;


public class Main {
    public static void main(String[] args) throws DocumentException {

        UserManager userManager = new UserManager();
        userManager.post(new User("Jay","123"));

        ReportPdf reportPdf = new ReportPdf(userManager);
        reportPdf.body();
        reportPdf.header();
        reportPdf.print();

    }
}
