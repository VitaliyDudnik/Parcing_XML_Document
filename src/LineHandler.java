import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;
/**
 * We need to define the text in the file by the "line" tag,
 * save all the information in a new file with the name and extension -> <firstName> _ <lastName> _ <title> .txt
 */
public class LineHandler extends DefaultHandler {

    List<String> line = new ArrayList<>();
    String firstName, lastName, title, fileTitle;
    boolean l, first, last, tit = false;

    @Override
    public void startDocument() {
        System.out.println("The program is running");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        if (qName.equals("line")) { l = true; }

        if(qName.equals("firstName")){ first = true; }

        if(qName.equals("lastName")){ last = true; }

        if(qName.equals("title")){ tit = true; }
    }

    @Override
    public void characters(char[] ch, int start, int length) {

        if(l) {
            line.add(new String(ch, start, length)+"\n");
            l = false;
        }if(first){
            firstName = new String(ch, start, length);
            first = false;
        }if(last){
            lastName = new String(ch, start, length);
            last = false;
        }if(tit){
            title = new String(ch, start, length);
            tit = false;
        }
        fileTitle = String.join("_", firstName, lastName, title + ".txt");
    }
    @Override
    public void endDocument() { System.out.println("Program completed"); }
}



