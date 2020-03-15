/**
 * @author L-Sternhagen
 Solution to Kattis Problem Minimum Scalar Product
 https://open.kattis.com/problems/minimumscalar
 */
import java.util.*;
public class MinimumScalarProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        //loop through each test case
        for(int g = 0; g < testCases; g++){
            int num = Integer.parseInt(sc.nextLine());
            //read each line into an array of longs
            String[] first = sc.nextLine().split(" "); long[] firstn = new long[first.length]; int n = 0;
            for(String s: first)firstn[n++] = Long.parseLong(s);
            String[] second = sc.nextLine().split(" "); long[] secondn = new long[second.length]; int m = 0;
            for(String s: second)secondn[m++] = Long.parseLong(s);
            //sort each array                     
            Arrays.sort(firstn);
            Arrays.sort(secondn);
            long sum = 0; 
            //get the output minimum scalar product
            for(int i = 0; i < firstn.length; i++){
                sum += firstn[i]*secondn[secondn.length-1-i];
            }
            //print output
            System.out.println("Case #" + (g+1) + ": " + sum);
        }
    }
}
