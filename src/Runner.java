import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter document directory.");
        String path = scan.nextLine();

        ClientPath.fileCheck(path);
        scan.close();
    }
}






