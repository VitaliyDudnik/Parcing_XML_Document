import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
/**
 * We need to define the text in the file by the "line" tag,
 * save all the information in a new file with the name and extension -> <firstName> _ <lastName> _ <title> .txt
 */
public class SaxMethod implements Parsing {
    @Override
    public  List<String> process(String file) {

        LineHandler lineHandler = new LineHandler();
        try {
            File input = new File(file);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(input, lineHandler);
        } catch (Exception e) {
            e.printStackTrace();

        //save all the information in a new file
        } try(BufferedWriter output = new BufferedWriter(new FileWriter(lineHandler.fileTitle))){
            for (String item : lineHandler.line)
                output.write(item);

        }catch (Exception e){
            e.printStackTrace();
        }
        return lineHandler.line;
    }
}
