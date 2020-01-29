
import java.util.Scanner;

/**
 * @author L-Sternhagen
 */
public class R2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i <n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            int g = b-c;
            if(g>a)System.out.println("advertise");
            else if (g==a)System.out.println("does not matter");
            else System.out.println("do not advertise");
        }
    }
}
