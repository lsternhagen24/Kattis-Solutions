
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author L-Sternhagen
 */
public class FallingApart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        Integer[] pieces = new Integer[n];
        for(int i =0; i < n; i++)pieces[i]= sc.nextInt();
        Arrays.sort(pieces, Collections.reverseOrder()); 
        //input now read and sorted
        int alice = 0; int bob = 0; int turn = -1;
        //let alice pick first then bob, alternating
        for(int i = 0; i < n; i++){
            if(turn < 0)alice+=pieces[i];
            else bob+=pieces[i];
            turn*=-1;
        }
        System.out.println(alice + " " + bob);   
    }
}
