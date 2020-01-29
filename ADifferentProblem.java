
import java.math.BigInteger;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lucas
 */
public class ADifferentProblem {
    public static void main(String[] args)throws Exception {
        Scanner sc = new Scanner(System.in);
          String line = "";
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            BigInteger a = new BigInteger(line.substring(0,line.indexOf(" ")));
            BigInteger b = new BigInteger(line.substring(line.indexOf(" ")+1));
            BigInteger c = a.subtract(b);
            System.out.println(c.abs());
        }
    }
}
