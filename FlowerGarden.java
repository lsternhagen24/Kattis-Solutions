
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem Flower Garden
 https://open.kattis.com/problems/flowergarden
 */
public class FlowerGarden {
    static final int TRANSLATE = 500;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_cases = sc.nextInt(); 
        //generate all primes under 20001
        Set<Integer> primes = sieveOfEratosthenes(20001);

        for(int qq = 0; qq < test_cases; qq++){
            
            int n = sc.nextInt();
            int d = sc.nextInt(); 
            //distance array to each point
            ArrayList<Double> distances = new ArrayList<Double>();
            distances.add(0.0);
            //start at translated origin
            int curRow = TRANSLATE, curColumn = TRANSLATE;
            for(int b = 0; b < n; b++){
                //read new coordinates
                int new_column = sc.nextInt()+TRANSLATE;
                int new_row = sc.nextInt()+TRANSLATE; 
                //add the distance to get to the old point plus the distance to get from the old point to current point
                distances.add(getDistance(curRow, curColumn, new_row,new_column) + distances.get(distances.size()-1));
                //update the current row and column to new point
                curRow = new_row;   
                curColumn = new_column;
            }
            int maxIdx = 0;
            //find max index
            for(int i = 0; i < distances.size(); i++){
                if(distances.get(i) <= d && primes.contains(i))maxIdx =i;
            }
            System.out.println(maxIdx);
        }   
    }
    //get distance between two points
    public static double getDistance(int r1, int c1, int r2, int c2){
        return Math.sqrt(Math.pow(r1-r2,2) + Math.pow(c1-c2,2));
    }
    //fast generation of primes using sieve
    public static Set<Integer> sieveOfEratosthenes(int n) {
        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        Set<Integer> primeNumbers = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }
}
