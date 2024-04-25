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

        String[] emails = str.split(",");
        Map<String, List<String>> map = new HashMap<>();
        for (String x : emails) {
            StringBuilder sb = new StringBuilder(x.strip());
            int separatorStart = sb.indexOf("@");
            if (separatorStart != -1) {
                String provider = sb.substring(separatorStart + 1);
                int separatorEnd = provider.indexOf(".");
                if (separatorEnd != -1) {
                    provider = provider.substring(0, separatorEnd);
                    List<String> emailList = map.getOrDefault(provider.toLowerCase(), new ArrayList<>());
                    emailList.add(sb.toString());
                    map.put(provider.toLowerCase(), emailList);
                }
            }
        }
        System.out.println("Gmail: "+map.get("gmail"));
        System.out.println("Yahoo: "+map.get("gmail"));
        System.out.println("Hotmail: "+map.get("gmail"));

    }
}