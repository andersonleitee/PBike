//package structure.Method;
//
//import org.w3c.dom.Attr;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerConfigurationException;
//import javax.xml.transform.TransformerException;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;
//import java.io.File;
//
//public class ReportXML {
//
//        try {
//            DocumentBuilderFactory document = DocumentBuilderFactory.newInstance();
//        DocumentBuilder dct = null;
//        try {
//            dct = document.newDocumentBuilder();
//        } catch (ParserConfigurationException ex) {
//            throw new RuntimeException(ex);
//        }
//
//        Document documentXml = dct.newDocument();
//
//            Element root =documentXml.createElement("root");
//            documentXml.appendChild(root);
//
//            Element user = documentXml.createElement("User");
//            Attr id = documentXml.createAttribute("id");
//            id.setValue("1");
//            user.setAttributeNode(id);
//
//            root.appendChild(user);
//
//            Element name = documentXml.createElement("name");
//            name.appendChild(documentXml.createTextNode("José"));
//            user.appendChild(name);
//            TransformerFactory transformerFactory = TransformerFactory.newInstance();
//            try {
//                Transformer transformer = transformerFactory.newTransformer();
//                DOMSource documentFont = new DOMSource(documentXml);
//                StreamResult docFinal = new StreamResult(new File("C://demo.xml"));
//                transformer.transform(documentFont,docFinal);
//            } catch (TransformerConfigurationException ex) {
//                throw new RuntimeException(ex);
//            } catch (TransformerException ex) {
//                throw new RuntimeException(ex);
//            }
//
//
//        } catch (ParserConfigurationException e) {
//            throw new RuntimeException(e);
//        }
//


//}
