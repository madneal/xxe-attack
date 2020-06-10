import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
//        ReadFromXml(classLoader.getResource("payload1.xml").getFile());
        try {

            unzip(classLoader.getResource("payload.xml.zip").getFile());
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public static void unzip(String filename) throws java.io.IOException {
        FileInputStream fis = new FileInputStream(filename);
        ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));
        ZipEntry entry;
        int entries = 0;
        long total = 0;
        try {
            while ((entry = zis.getNextEntry()) != null) {
                System.out.println("Extracting: " + entry);

                File f = new File("/Users/dongbing" + "/" + "../../../../etc/passwd");
                System.out.println(f.getAbsolutePath());
                int count;
//                byte data[] = new byte[BUFFER];
                // Write the files to the disk, but ensure that the filename is valid,
                // and that the file is not insanely big
                String name = validateFilename(entry.getName(), ".");
                if (entry.isDirectory()) {
                    System.out.println("Creating directory " + name);
                    new File(name).mkdir();
                    continue;
                }
                FileOutputStream fos = new FileOutputStream(name);

            }
        } finally {
            zis.close();
        }
    }

    private static String validateFilename(String filename, String intendedDir)
            throws java.io.IOException {
        File f = new File(filename);
        String canonicalPath = f.getCanonicalPath();

        File iD = new File(intendedDir);
        String canonicalID = iD.getCanonicalPath();

        if (canonicalPath.startsWith(canonicalID)) {
            return canonicalPath;
        } else {
            throw new IllegalStateException("File is outside extraction target directory.");
        }
    }
}
