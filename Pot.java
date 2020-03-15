
import java.util.Scanner;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem Pot
 https://open.kattis.com/problems/pot
 */
public class Pot {
    public static void main(String[] args) {
        //scanner for reading input
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt(); sc.nextLine();
        long out = 0;
        //loop through each test case
        for(int i = 0; i < t; i++){
            String in = sc.nextLine();
            //calculate the solution
            long pow = Long.parseLong(in.substring(in.length()-1));
            long base = Long.parseLong(in.substring(0, in.length()-1));
            out += Math.pow(base, pow);
        }
        //print output
        System.out.println(out);
    }
}
