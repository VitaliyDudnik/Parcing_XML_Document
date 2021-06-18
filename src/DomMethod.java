import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class DomMethod implements Parsing {
    @Override
    public List<String> process(String file) {
        List<String> line = new ArrayList<>();

        try {
            System.out.println("The program is running");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(String.valueOf(file)));
            document.getDocumentElement().normalize();

            //Define the tag name and take the text from there
            NodeList nList = document.getElementsByTagName("lines");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node node = nList.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    String text = eElement.getTextContent();
                    line.add(text);
                }
            }
            //We need a header for the new file.
            // The header must contain tags from the parsing file. e.g. <firstName> _ <lastName> _ <title> .txt
            NodeList nList1 = document.getElementsByTagName("firstName");
            NodeList nList2 = document.getElementsByTagName("title");
            NodeList nList3 = document.getElementsByTagName("lastName");
            for (int temp1 = 0; temp1 < nList1.getLength(); temp1++) {
                Node node1 = nList1.item(temp1);
                for (int temp2 = 0; temp2 < nList2.getLength(); temp2++) {
                    Node node2 = nList2.item(temp2);
                    for (int temp3 = 0; temp3 < nList3.getLength(); temp3++) {
                        Node node3 = nList3.item(temp3);
                        if (node1.getNodeType() == Node.ELEMENT_NODE|
                                node2.getNodeType() == Node.ELEMENT_NODE|
                                node3.getNodeType() == Node.ELEMENT_NODE) {
                            Element eElement1 = (Element) node1;
                            Element eElement2 = (Element) node2;
                            Element eElement3 = (Element) node3;
                            String firstName = eElement1.getTextContent();
                            String title = eElement2.getTextContent();
                            String lastName = eElement3.getTextContent();
                            file = String.join("_",firstName, lastName, title +".txt");
                        }}}}
        }catch (Exception e){
            e.printStackTrace();
        }
        //Writing information from parsing a file to a new file with the header
        // String.join ("_", firstName, lastName, title + ". Txt") -> William_Shakespeare_Sonnet 130.txt
        try (BufferedWriter output = new BufferedWriter(new FileWriter(file))) {
            for (String item : line) {
                output.write(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("The program completed");
        return line;
    }
}
