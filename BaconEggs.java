import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Kattis Solution to Bacon, Eggs, and Spam
 *  https://open.kattis.com/problems/baconeggsandspam
 */
public class BaconEggs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //read in customers orders
        Scanner sc = new Scanner(System.in);
        int customers = Integer.parseInt(sc.nextLine());
        //while we still have more day's orders to read
        while (customers != 0) {
            //map each food to a list of customers that ordered it
            Map<String, ArrayList<String>> customerList = new HashMap<String, ArrayList<String>>();
            //for each customer in that day's order
            for (int i = 0; i < customers; i++) {
                //read scanner off of customer's order
                Scanner line = new Scanner(sc.nextLine());
                String customer = line.next();
                //loop through each food item that customer ordered
                while (line.hasNext()) {
                    String food = line.next();
                    //if the food has already been encountered, simply add customer to that list
                    if ((customerList.containsKey(food))) {
                        customerList.get(food).add(customer);
                    //food hasn't been encountered before, so add it to the map
                    } else {
                        customerList.put(food, new ArrayList<String>());
                        customerList.get(food).add(customer);
                    }
                }

            }
            //list to hold each food
            ArrayList<String> names = new ArrayList<String>();
            //add all foods to the names list and sort the list of customer's that ordered that food
            for (String key : customerList.keySet()) {
                names.add(key);
                Collections.sort(customerList.get(key));
            }
            //sort the list of food's alphabetically
            Collections.sort(names);
            //print output
            for (String name : names) {
                String output = "";
                output += name + " ";
                for (int a = 0; a < customerList.get(name).size(); a++) {
                    output += customerList.get(name).get(a) + " ";
                }
                System.out.println(output.trim());
            }
            System.out.println();
            //move onto next day
            customers = Integer.parseInt(sc.nextLine());
        }
    }

}
