import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String str = """
        abc@gmail.com, harsh@yahoo.com, javed@hotmail.com, johndoe@yahoo.com, johnyB@gmail.com,  johndoe@hotmail.com
        , hello@gmail.com, mike@yahoo.com
        """;
        //splitting the emails
        String[] emails = str.split(",");

        // creating the map of emails to list of emails.
        Map<String, List<String>> map = new HashMap<>();
        for (String x : emails) {
            // string builder to remove spaces and effectively getting substrings.
            StringBuilder sb = new StringBuilder(x.strip());
            // checking the index if @ for cutting the email provider from the string
            int separatorStart = sb.indexOf("@");
            if (separatorStart != -1) {
                String provider = sb.substring(separatorStart + 1);
                //cutting the substring from @ to .
                int separatorEnd = provider.indexOf(".");
                if (separatorEnd != -1) {
                    provider = provider.substring(0, separatorEnd);
                    // check if the provider exists if yes then add if no add to a new list.
                    List<String> emailList = map.getOrDefault(provider.toLowerCase(), new ArrayList<>());
                    emailList.add(sb.toString());
                    // adding to map after converting to lowercase.
                    map.put(provider.toLowerCase(), emailList);
                }
            }
        }
        System.out.println("Gmail: "+map.get("gmail"));
        System.out.println("Yahoo: "+map.get("yahoo"));
        System.out.println("Hotmail: "+map.get("hotmail"));

    }
}
