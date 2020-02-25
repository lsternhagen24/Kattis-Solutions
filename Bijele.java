
import java.util.Scanner;

/**
 * @author L-Sternhagen
 Kattis solution to Bijele Problem
 https://open.kattis.com/problems/bijele
 */
public class R2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //what a valid set should look like
        int[] c = {1,1,2,2,2,8};
        //p will hold what the set currently looks like
        int [] p = new int[6];
        //read input
        for(int i = 0; i < 6; i++)p[i] = sc.nextInt();
        String out = "";
        //loop through current chess set
        for(int i = 0; i < 6; i++){
            //don't add space before the first character
            if(i!=0)out+=" ";
            //print out the difference between the valid number and what we currently have
            int g = c[i]-p[i];
            out+=""+ g;
        }
        //print output
        System.out.println(out);
    }
}
