/**
 * @author lucas
 Solution to Kattis Problem Incognito
https://open.kattis.com/problems/incognito
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Incognito {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        //loop through every test case
        for (int i = 0; i < testCases; i++) {
            //read the number of items
            int numOfItems = Integer.parseInt(sc.nextLine());
            //map each item to a list of the type
            Map<String, ArrayList<String>> items = new HashMap<String, ArrayList<String>>();
            for (int j = 0; j < numOfItems; j++) {
                String line = sc.nextLine();
                Scanner sc2 = new Scanner(line);
                String item = sc2.next();
                String category = sc2.next();
                //if we already have the category add the item to that category
                if (items.containsKey(category)) {
                    items.get(category).add(item);
                } 
                //otherwise add the item to a new category
                else {
                    items.put(category, new ArrayList<String>());
                    items.get(category).add(item);
                }
            }
            int sum = 1;
            //multiply the sum by the number of categorys and items
            for (String key : items.keySet()) {
                sum *= (items.get(key).size() + 1);
            }
            sum--;
            //print output
            System.out.println(sum);
        }
    }
}
