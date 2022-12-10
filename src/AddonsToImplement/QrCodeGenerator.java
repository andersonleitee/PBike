package AddonsToImplement;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class QrCodeGenerator {
    public static void generateQR(String path, String format , String text, String name){
        try {

            File myFile = new File(path+"/"+name+"."+format);

            Hashtable<EncodeHintType, ErrorCorrectionLevel>
                hintMap = new Hashtable<>();

            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            QRCodeWriter qrCodeWriter = new QRCodeWriter();

            BitMatrix byteMatrix =
                    qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 100, 100, hintMap);

            int CrunchyWidth = byteMatrix.getWidth();
            BufferedImage image = new BufferedImage(CrunchyWidth, CrunchyWidth,
                    BufferedImage.TYPE_INT_RGB);
            image.createGraphics();

            Graphics2D graphics = (Graphics2D) image.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, CrunchyWidth, CrunchyWidth);
            graphics.setColor(Color.BLACK);

            for (int i = 0; i < CrunchyWidth; i++) {
                for (int j = 0; j < CrunchyWidth; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }
            ImageIO.write(image, format, myFile);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }

    }



}
