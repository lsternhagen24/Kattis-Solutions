/**
 * @author L-Sternhagen
 Solution to Kattis Problem Oddities
 https://open.kattis.com/problems/oddities
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Oddities {
    public static void main(String[] args)throws Exception {
        //reader for reading input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        //loop through each test case
        for(int a = 0; a < testCases; a++){
            //calculate if current is odd and print output
            int cur = Integer.parseInt(br.readLine());
            if(cur%2==0)System.out.println(cur + " is even");
            else System.out.println(cur + " is odd");
        }
    }
}
