
import java.util.Scanner;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem Grass Seed
 https://open.kattis.com/problems/grassseed
 */
public class GrassSeed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //read in the cost of seed
        double cost = sc.nextDouble();
        //read in the number of lawns
        int lawns = sc.nextInt();
        double output = 0;
        //read the length and width of the lawn, then multiply by the cost and add to the total output
        for(int i = 0; i < lawns; i++){
            double w = sc.nextDouble();
            double l = sc.nextDouble();
            output+= cost * (w*l);
        }
        //print output
        System.out.println(output);
    }
}
