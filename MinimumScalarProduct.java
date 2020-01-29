/**
 * @author L-Sternhagen
 */
import java.util.*;
public class MinimumScalarProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        for(int g = 0; g < testCases; g++){
            int num = Integer.parseInt(sc.nextLine());
            String[] first = sc.nextLine().split(" "); long[] firstn = new long[first.length]; int n = 0;
            for(String s: first)firstn[n++] = Long.parseLong(s);
            String[] second = sc.nextLine().split(" "); long[] secondn = new long[second.length]; int m = 0;
            for(String s: second)secondn[m++] = Long.parseLong(s);
                       
            Arrays.sort(firstn);
            Arrays.sort(secondn);
            long sum = 0; 
            for(int i = 0; i < firstn.length; i++){
                sum += firstn[i]*secondn[secondn.length-1-i];
            }
            System.out.println("Case #" + (g+1) + ": " + sum);
        }
        
        
        
    }
}
