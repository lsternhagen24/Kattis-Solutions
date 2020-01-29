import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author lucas leave this to piss off everyone
 */
public class BaconEggs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int customers = Integer.parseInt(sc.nextLine());
        while (customers != 0) {
            Map<String, ArrayList<String>> customerList = new HashMap<String, ArrayList<String>>();
            for (int i = 0; i < customers; i++) {
                Scanner line = new Scanner(sc.nextLine());
                String customer = line.next();
                while (line.hasNext()) {
                    String food = line.next();
                    if ((customerList.containsKey(food))) {
                        customerList.get(food).add(customer);

                    } else {
                        customerList.put(food, new ArrayList<String>());
                        customerList.get(food).add(customer);
                    }
                }

            }
            ArrayList<String> names = new ArrayList<String>();
            for (String key : customerList.keySet()) {
                names.add(key);
                Collections.sort(customerList.get(key));
            }
            Collections.sort(names);
            for (String name : names) {
                String output = "";
                output += name + " ";
                for (int a = 0; a < customerList.get(name).size(); a++) {
                    output += customerList.get(name).get(a) + " ";
                }
                System.out.println(output.trim());
            }
            System.out.println();
            customers = Integer.parseInt(sc.nextLine());
        }
    }

}
