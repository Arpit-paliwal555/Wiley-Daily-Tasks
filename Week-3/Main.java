import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>(List.of("javed","jimmy","johny"));
        for(int i=0;i<names.size();i++){
            names.set(i,names.get(i).toUpperCase());
        }
        System.out.println(names);
    }

}
