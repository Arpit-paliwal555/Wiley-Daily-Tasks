import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Ask the user for the file names
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        // Attempt to open the file and read its content
        try (scanner) {
            File file = new File(fileName);
            String ans = "y";
            while(ans.equals("y")){
                System.out.println("Enter text to be written:");
                FileWriter myWriter = new FileWriter(file);
                myWriter.write(scanner.nextLine());
                System.out.println("Do you want to add more?");
                ans = scanner.nextLine();
                if (!ans.equals("y"))
                    myWriter.close();
            }

            Scanner fileScanner = new Scanner(file);
            System.out.println("Contents of the file:");

            // Read and display each line of the file
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine()+"\n");
            }

        } catch (IOException e) {
            System.out.println("File not found: " + fileName);
        }

    }

}