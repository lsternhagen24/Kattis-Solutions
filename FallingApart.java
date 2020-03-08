
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem falling apart
 https://open.kattis.com/problems/fallingapart
 */
public class FallingApart {
    public static void main(String[] args) {
        //read input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        Integer[] pieces = new Integer[n];
        for(int i =0; i < n; i++)pieces[i]= sc.nextInt();
        //sort pieces in descending order
        Arrays.sort(pieces, Collections.reverseOrder()); 
        //input now read and sorted
        int alice = 0; int bob = 0; int turn = -1;
        //let alice pick first then bob, alternating
        for(int i = 0; i < n; i++){
            //add piece to either alice or bob
            if(turn < 0)alice+=pieces[i];
            else bob+=pieces[i];
            //alternate turn
            turn*=-1;
        }
        //print output
        System.out.println(alice + " " + bob);   
    }
}
