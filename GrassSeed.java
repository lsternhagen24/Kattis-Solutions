
import java.util.Scanner;

/**
 * @author L-Sternhagen
 */
public class GrassSeed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double cost = sc.nextDouble();
        int lawns = sc.nextInt();
        double output = 0;
        for(int i = 0; i < lawns; i++){
            double w = sc.nextDouble();
            double l = sc.nextDouble();
            output+= cost * (w*l);
        }
        System.out.println(output);
    }
}
