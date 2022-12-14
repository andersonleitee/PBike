import com.itextpdf.text.DocumentException;
import model.User.User;
import structure.Template.ReportPdf;
import structure.Template.ReportTxt;
import structure.Singleton.SingletonPBSystem;
import structure.Singleton.SingletonUserManager;
import view.UserPrompts;

import java.io.IOException;

public class PBike {
    public static void main(String[] args) throws DocumentException, IOException {
        falseUserData();
    }



    public static void falseUserData() throws DocumentException, IOException {
        String[] names = {"Gabriel", "Lara", "Anderson", "Jayanne", "Carol"};
        String[] passwords = {"123456789", "987654312", "147258369", "963852741", "1597532486"};
        //String[] date ={"14:50","10:00","09:00", "16:00","20:00"};
        UserPrompts userPrompts = new UserPrompts();


        for(int i = 0; i < 5; i++){
            SingletonUserManager.getInstance().post(new User(names[i], passwords[i]));
            userPrompts.testUserLogin(names[i], passwords[i]);
        }
        SingletonPBSystem.getInstance().getLoggedUsers().toString();

        ReportPdf reportPdf = new ReportPdf();
        reportPdf.body();
        reportPdf.header();
        reportPdf.print();

         ReportTxt reportTxt = new ReportTxt();
         reportTxt.body();
         reportTxt.print();


    }

}

