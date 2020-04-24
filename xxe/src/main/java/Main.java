import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        ReadFromXml(classLoader.getResource("payload1.xml").getFile());
    }

    public static void ReadFromXml(String filepath) {
        try {

//            File file = new File(filepath);
//            InputStream stream = new FileInputStream(file);
//            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
////            documentBuilderFactory.setExpandEntityReferences(false);
////            documentBuilderFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
//            DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
//            builder.parse(stream);
            InputStream is = new FileInputStream(new File(
                    "/Users/dongbing/project/xxe-attack/xxe/src/main/resources/payload1.xml"));
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setExpandEntityReferences(false);
            documentBuilderFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
            builder.parse(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
