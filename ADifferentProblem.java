
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author lucas
 Solution to kattis problem A Different Problem
 https://open.kattis.com/problems/different
 */
public class ADifferentProblem {
    public static void main(String[] args)throws Exception {
        Scanner sc = new Scanner(System.in);
          String line = "";
        //read while not end of file
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            //use biginteger class since integers can be 15^15
            BigInteger a = new BigInteger(line.substring(0,line.indexOf(" ")));
            BigInteger b = new BigInteger(line.substring(line.indexOf(" ")+1));
            //call subtract to get difference
            BigInteger c = a.subtract(b);
            //print output
            System.out.println(c.abs());
        }
    }
}
