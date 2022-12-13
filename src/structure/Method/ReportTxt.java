package structure.Method;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import structure.Singleton.SingletonPBSystem;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class ReportTxt {
    public static void text(String directory, String body) throws IOException {
        FileWriter createFile;
        createFile = new FileWriter(directory,true );
        createFile.write(SingletonPBSystem.getInstance().getLoggedUsers().toString());
        BufferedWriter buffer = new BufferedWriter(createFile);
        PrintWriter printWriter = new PrintWriter(buffer);

        printWriter.append(body);

    }


//        DocumentBuilderFactory document = DocumentBuilderFactory.newInstance();
//        DocumentBuilder dct;
//
//    {
//        try {
//            dct = document.newDocumentBuilder();
//            Document documentXml = dct.newDocument();
//            Element root =documentXml.createElement("root");
//            documentXml.appendChild(root);
//
//            Element user = documentXml.createElement("User");
//            Attr id = documentXml.createAttribute("id");
//            id.setValue("1");
//            user.setAttributeNode(id);
//
//            Element name = documentXml.createElement("name");
//            name.appendChild(documentXml.createTextNode( SingletonPBSystem.getInstance().getLoggedUsers().toString()));
//            user.appendChild(name);
//
//            TransformerFactory transformerFactory = TransformerFactory.newInstance();
//
//        Transformer transformer = transformerFactory.newTransformer();
//        DOMSource documentFont = new DOMSource(documentXml);
//        StreamResult docFinal = new StreamResult(new File("C:\\xml\\demoMPS.xml"));
//        transformer.transform(documentFont,docFinal);
//
//
//        } catch (ParserConfigurationException e) {
//            throw new RuntimeException(e);
//        } catch (TransformerConfigurationException e) {
//            throw new RuntimeException(e);
//        } catch (TransformerException e) {
//            throw new RuntimeException(e);
//        }
//    }
//


}