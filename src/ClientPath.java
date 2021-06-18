import java.io.File;
import java.util.Arrays;

public class ClientPath {

    static void fileCheck(String path) {

        Client client = new Client();
        File f = new File(path);

        try {
            if (!f.exists()) {
                System.out.println("Path: " + f.getPath());
                System.out.println("Exists: " + f.exists());
                return;
            }
            if (f.exists()) {
                if (f.isDirectory()) {
                    File[] file = f.listFiles((dir, name) -> name.endsWith("xml"));
                    assert file != null;
                    if (file.length != 1) {
                        System.out.println("The program parses only one valid file: " + file.length);
                        System.out.println("Please try again.");
                        return;
                    }
                    System.out.println("Path: " + f.getPath());
                    System.out.println("Exists: " + f.exists());
                    System.out.println("Is writeable: " + f.canWrite());
                    System.out.println("Is readable: " + f.canRead());
                    System.out.println("Amount of valid documents: " + file.length);

                    if (Arrays.stream(f.listFiles()).count() == 0) {
                        System.out.println("Directory is empty, please enter another path.");
                    }
                    client.clientChoose(file);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
