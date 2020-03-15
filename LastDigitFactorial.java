
import java.util.Scanner;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem Last Digit Factorial
 https://open.kattis.com/problems/lastfactorialdigit
 */
public class LastDigitFactorial {
    public static void main(String[] args) {
        //scanner for reading input
        Scanner sc = new Scanner(System.in);
        //read the number of testcases
        int t = sc.nextInt();
        //loop through each test case
        for(int f = 0; f < t; f++){
            int r = sc.nextInt();
            //print out the last digit of the factorial
            System.out.println(getLFact(r));
        }
    }
    //returns the last digit of the factorial
    static String getLFact(int i){
        int s = 1;
        //get the factorial result
        for(int w = 1; w <=i; w++)s*=w;
        String e = s+"";
        //return the last character
        return e.substring(e.length()-1);
    }
}
