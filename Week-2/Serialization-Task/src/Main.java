import java.io.*;

public class Main {
    public static void main(String[] args) {
        Product prd = new Product(123,"laptop","june-2024");
        serializeObject(prd);
        File serFile = new File("Product.ser");
        Product prd2 = (Product) deSerializeObject(serFile.getName());
        System.out.println(prd2);
    }
    public static void serializeObject(Object object) {
        try(OutputStream outputStream = new FileOutputStream("Product.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)){
            objectOutputStream.writeObject(object);
        }
        catch (IOException ex){
            System.err.println(ex.getMessage());
        }
    }
    public static Object deSerializeObject(String filename){
        try(InputStream inputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            return objectInputStream.readObject();
        }
        catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
}