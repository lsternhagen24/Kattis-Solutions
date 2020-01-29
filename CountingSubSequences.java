
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author L-Sternhagen
 */
public class CountingSubSequences {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCases; i++) {
            br.readLine();
            int n = Integer.parseInt(br.readLine());
            String[] in = br.readLine().split(" ");
            int[] input = new int[n];
            for (int a = 0; a < n; a++) {
                input[a] = Integer.parseInt(in[a]);
            }
            long sum = 0;
            Map<Long, Integer> myMap = new HashMap<>();
            myMap.put(0L,1);
            long sum47 = 0;
            for (int f = 0; f < n; f++) {
                sum += input[f];
                if (myMap.containsKey(sum)) {
                    myMap.put(sum, myMap.get(sum) + 1);
                } else {
                    myMap.put(sum, 1);
                }
                if (myMap.containsKey(sum - 47)) {
                    sum47 += myMap.get(sum - 47);
                }
            }
            System.out.println(sum47);
        }
    }
}
