
import java.util.Scanner;

/**
 * @author L-Sternhagen
 */
public class HeartRate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); sc.nextLine();
        for(int i = 0; i < t; i++){
            double b = sc.nextDouble();
            double a = sc.nextDouble();
            System.out.println((60/a)*(b-1) + " "  + (60/a) * b + " " + (60/a) * (b+1));
        }
    }
}
