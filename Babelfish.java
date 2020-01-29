
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class Babelfish {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Map h = new HashMap();
            String s = sc.nextLine();
            while (s.indexOf(" ") > -1) {
                String local = s.substring(0, s.indexOf(" "));
                String foreign = s.substring(s.indexOf(" ") + 1);
                h.put(foreign, local);
                s = sc.nextLine();

            }
            int r = 0;
            while (sc.hasNextLine()) {
                String t = sc.next();
                String output = (!h.containsKey(t)) ? "eh" : (String) h.get(t);
                System.out.println(output);
            }
        } catch (Exception e) {

        }
    }
}
