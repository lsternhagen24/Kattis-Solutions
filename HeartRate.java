import java.util.Scanner;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem Heart Rate
 https://open.kattis.com/problems/heartrate
 */
public class HeartRate {
    public static void main(String[] args) {
        //scanner for reading input
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); sc.nextLine();
        //loop through all test cases
        for(int i = 0; i < t; i++){
            //read b and a, then print output
            double b = sc.nextDouble();
            double a = sc.nextDouble();
            System.out.println((60/a)*(b-1) + " "  + (60/a) * b + " " + (60/a) * (b+1));
        }
    }
}
