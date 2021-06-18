import java.io.File;
import java.util.Scanner;

public class Client {
    SaxMethod saxMethod = new SaxMethod();
    DomMethod domMethod = new DomMethod();

  public void clientChoose(File[] file){

      Scanner scan = new Scanner(System.in);
      System.out.println("Choose parse method: ");
      System.out.println("1: Parse by SAX");
      System.out.println("2: Parse by DOM");

      var choice = scan.nextInt();
      if(choice == 1){
          System.out.println("Your choice is to parse the file using the SAX method.");
          for (File files : file)
              saxMethod.process(files.getPath());
          return;
      }
      if(choice == 2){
          System.out.println("Your choice is to parse the file using the DOM method.");
          for (File files : file)
              domMethod.process(files.getPath());

      } else {
          System.out.println("wrong choice, try again.");
      }
  }
}
