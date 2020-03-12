
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author lucas
 Solution to Kattis Problem Hay Points
 https://open.kattis.com/problems/haypoints
 */
public class HayPoints {
    public static void main(String[] args) {
        try{
        //read input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int attributes = Integer.parseInt(line.substring(0, line.indexOf(" ")));
        int testCases = Integer.parseInt(line.substring(line.indexOf(" ")+1));
        Map<String, Integer> h = new HashMap<String, Integer>();
        //map each word to the number of points it is worth
        for (int f = 0; f < attributes; f++) {
            String input = br.readLine();
            h.put(input.substring(0, input.indexOf(' ')), Integer.parseInt(input.substring(input.indexOf(' ') + 1)));
        }
        //loop through all test cases
        for (int i = 0; i < testCases; i++) {
            int sum = 0;
            String current = br.readLine();
            //read each line until we reach the period
            while (!current.equals(".")) {
                //split all words on spaces
                String[] a = current.split(" ");
                //loop through all words and if we have the word in our dictionary then add the points to the sum
                for (int v = 0; v < a.length; v++) {
                    String g = a[v];
                    if (h.containsKey(g)) {
                        sum += h.get(g);
                    }
                }
                current = br.readLine();
            }
            //print output
            System.out.println(sum);
        }
        }catch(Exception e){}
    }
}
