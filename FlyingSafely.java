
import java.util.Scanner;

/**
 * @author L-Sternhagen
 Solution to Kattis problem Flying Safely
 https://open.kattis.com/problems/flyingsafely
 */
public class FlyingSafely {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_cases = sc.nextInt(); sc.nextLine();
        //loop through each test case
        for(int j = 0; j < test_cases; j++){
            int cities = sc.nextInt();
            int pilots = sc.nextInt();
            sc.nextLine();
            for(int a = 0; a < pilots; a++)sc.nextLine();
            //cities - 1 is always solution due to the fact that the graph is alwasy connected
            System.out.println(cities-1);
        }
    }
}
