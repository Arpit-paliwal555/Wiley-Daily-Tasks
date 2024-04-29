import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<String> getValidNames(List<String> names){
        List<String> ans = new ArrayList<>();
        names.forEach((a)->{
            String[] check = a.split(" ");
            if (check.length>=2){
                ans.add(a);
            }
        });
        return ans;
    }
    static List<String> getShortNames(List<String> names){
        List<String> ans = new ArrayList<>();
        names.forEach((a)->{
            String[] check = a.split(" ");
            String temp = "";
            for (String s:check){
                temp += Character.toUpperCase(s.charAt(0));
                temp += ".";
            }
            ans.add(temp);

        });
        return ans;
    }
    static List<String> getAllNames(List<String> names){
        List<String> ans1 = getValidNames(names);
        List<String> ans2 = getShortNames(ans1);
        return ans2;
    }

    public static void main(String[] args) {
        List<String> names = List.of("Harsh Kumar","Virat Kohli", "Mahendra Singh Dhoni","Akash","Karan Chopra");
       // List<String> validNames = getValidNames(names);
       // List<String> shortNames = getShortNames(validNames);
        List<String> allName = getAllNames(names);


        System.out.println("All short names (initials):"+allName);
    }
}