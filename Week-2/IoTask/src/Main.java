import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) throws Exception {


        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the file name: ");
        String fileName = "temp.txt";


        try (scanner;
        ) {
            File file = new File(fileName);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            String ans = "y";
            while (ans.equals("y")) {
                System.out.println("Enter text to be written:");
                //FileWriter myWriter = new FileWriter(file);
                scanner.next();
                randomAccessFile.writeUTF(scanner.nextLine() + "\n");
                randomAccessFile.seek(0);
                System.out.println("Do you want to add more?");
                ans = scanner.nextLine();

            }
            System.out.println("Contents of the file:");
            while (randomAccessFile.getFilePointer() < file.length()) {
                System.out.println(randomAccessFile.readUTF());
            }
            randomAccessFile.close();
            String content = file.readUTF();

            System.out.println(content);

            Scanner fileScanner;
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine() + "\n");
            }

        } catch (IOException e) {
            System.out.println("File not found: " + fileName);
        }
    }

