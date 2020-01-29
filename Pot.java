
import java.util.Scanner;

/**
 * @author L-Sternhagen
 */
public class Pot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt(); sc.nextLine();
        long out = 0;
        for(int i = 0; i < t; i++){
            String in = sc.nextLine();
            long pow = Long.parseLong(in.substring(in.length()-1));
            long base = Long.parseLong(in.substring(0, in.length()-1));
            out += Math.pow(base, pow);
        }
        System.out.println(out);
    
    }
}
