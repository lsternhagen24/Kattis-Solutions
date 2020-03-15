
import java.util.Scanner;

/**
 * @author L-Sternhagen
Solution to Kattis Problem R2
https://open.kattis.com/problems/r2
 */
public class R2 {
    public static void main(String[] args) {
        //scanner for reading input
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        //print output
        System.out.println((b*2)-a);
    }
}
