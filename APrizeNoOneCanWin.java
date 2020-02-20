
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author L-Sternhagen
 Solution to Kattis problem A Prize No One Can Win
 https://open.kattis.com/problems/aprizenoonecanwin
 */
public class APrizeNoOneCanWin {
    public static void main(String[] args) {
        //read input
        Scanner sc = new Scanner(System.in);
        //read number of items n and minumum cost x
        int n = sc.nextInt();
        long x = sc.nextLong();
        sc.nextLine();
        //read all individual items into items array and sort
        long[] items = new long[n];
        for(int i = 0; i < n; i++)items[i] = sc.nextLong();
        Arrays.sort(items);
        //set nummber of items initially available for on sale to 0
        long output = 0;
        //get smallest item price available
        long smallest = items[0];
        //loop through every item price only once
        for(int i = 0; i < n; i++){
            //if sale price minus smallest minus current item is less than 0 break
            if(x-smallest-items[i] <0 && i > 0)break;
            //set smallest to be current item
            smallest = items[i];
            //add one to item count we can set on sale
            output++;
        }
        System.out.println(output);
        
    }
}
