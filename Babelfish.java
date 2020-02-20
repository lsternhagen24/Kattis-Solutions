
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author lucas
 Kattis Solution to Babelfish
 https://open.kattis.com/problems/babelfish
 */
public class Babelfish {

    public static void main(String[] args) {
        try {
            //read input
            Scanner sc = new Scanner(System.in);
            Map h = new HashMap();
            String s = sc.nextLine();
            //parse the local and foreign language from string
            while (s.indexOf(" ") > -1) {
                String local = s.substring(0, s.indexOf(" "));
                String foreign = s.substring(s.indexOf(" ") + 1);
                //map the foreign word to it's local counterpart
                h.put(foreign, local);
                s = sc.nextLine();
            }
            int r = 0;
            //read output words
            while (sc.hasNextLine()) {
                String t = sc.next();
                //if we don't know the definition, print 'eh', else get definition from map
                String output = (!h.containsKey(t)) ? "eh" : (String) h.get(t);
                System.out.println(output);
            }
        } catch (Exception e) {

        }
    }
}
