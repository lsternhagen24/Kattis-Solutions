
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class HayPoints {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int attributes = Integer.parseInt(line.substring(0, line.indexOf(" ")));
        int testCases = Integer.parseInt(line.substring(line.indexOf(" ")+1));
        Map<String, Integer> h = new HashMap<String, Integer>();
        for (int f = 0; f < attributes; f++) {
            String input = br.readLine();
            h.put(input.substring(0, input.indexOf(' ')), Integer.parseInt(input.substring(input.indexOf(' ') + 1)));
        }
        for (int i = 0; i < testCases; i++) {
            int sum = 0;
            String current = br.readLine();
            while (!current.equals(".")) {
                String[] a = current.split(" ");
                for (int v = 0; v < a.length; v++) {
                    String g = a[v];
                    if (h.containsKey(g)) {
                        sum += h.get(g);
                    }
                }
                current = br.readLine();
            }
            System.out.println(sum);
        }
        }catch(Exception e){}
    }

}
