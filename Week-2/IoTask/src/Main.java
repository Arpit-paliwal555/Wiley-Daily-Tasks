import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Ask the user for the file names
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();


        try (scanner;
             RandomAccessFile file = new RandomAccessFile(fileName, "rw");
             ) {

            String ans = "y";
            while(ans.equals("y")){
                System.out.println("Enter text to be written:");
                //FileWriter myWriter = new FileWriter(file);
                file.writeUTF(scanner.nextLine()+"\n");
                file.seek(0);
                System.out.println("Do you want to add more?");
                ans = scanner.nextLine();

            }

            String content = file.readUTF();
            System.out.println("Contents of the file:");
            System.out.println(content);

//            while (fileScanner.hasNextLine()) {
//                System.out.println(fileScanner.nextLine()+"\n");
//            }

        } catch (IOException e) {
            System.out.println("File not found: " + fileName);
        }

    }

}