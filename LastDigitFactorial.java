
import java.util.Scanner;

/**
 * @author L-Sternhagen
 */
public class LastDigitFactorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int f = 0; f < t; f++){
            int r = sc.nextInt();
            System.out.println(getLFact(r));
        }
    }
    static String getLFact(int i){
        int s = 1;
        for(int w = 1; w <=i; w++)s*=w;
        String e = s+"";
        return e.substring(e.length()-1);
    }
}
