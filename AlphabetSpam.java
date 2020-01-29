
import java.util.*;

/**
 * @author L-Sternhagen
 */
public class AlphabetSpam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.nextLine().toCharArray();
        int white = 0;
        int total = 0;
        int lower = 0;
        int upper = 0;
        int special = 0;
        
        for(int i = 0; i < input.length; i++){
            int n = input[i];
            if(n >= 97 && n <= 122)lower++;
            else if(n>=65 && n <= 90)upper++;
            else if(n==95)white++;
            else special++;
            
            total++;
        
        }
        double a = ((double)white)/((double)total);
        double b = ((double)lower)/((double)total);
        double c = ((double)upper)/((double)total);
        double d = ((double)special)/((double)total);
        System.out.println(a + "\n" + b + "\n" + c + "\n" + d);
        
    }
}
