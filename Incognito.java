/**
 *
 * @author lucas
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Incognito {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testCases; i++) {
            int numOfItems = Integer.parseInt(sc.nextLine());
            Map<String, ArrayList<String>> items = new HashMap<String, ArrayList<String>>();
            for (int j = 0; j < numOfItems; j++) {
                String line = sc.nextLine();
                Scanner sc2 = new Scanner(line);
                String item = sc2.next();
                String category = sc2.next();
                if (items.containsKey(category)) {
                    items.get(category).add(item);
                } else {
                    items.put(category, new ArrayList<String>());
                    items.get(category).add(item);
                }
            }
            int sum = 1;
            for (String key : items.keySet()) {
                sum *= (items.get(key).size() + 1);
            }
            sum--;
            System.out.println(sum);
        }
    }
}
