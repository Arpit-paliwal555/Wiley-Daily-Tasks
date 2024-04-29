import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>(List.of("javed","jimmy","johny"));
        names.replaceAll(String::toUpperCase);
        System.out.println(names);
    }

}
