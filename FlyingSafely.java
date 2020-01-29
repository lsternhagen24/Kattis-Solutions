
import java.util.Scanner;

/**
 * @author L-Sternhagen
 */
public class FlyingSafely {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_cases = sc.nextInt(); sc.nextLine();
        for(int j = 0; j < test_cases; j++){
            int cities = sc.nextInt();
            int pilots = sc.nextInt();
            sc.nextLine();
            for(int a = 0; a < pilots; a++)sc.nextLine();
            
            System.out.println(cities-1);
        }
    }
}
