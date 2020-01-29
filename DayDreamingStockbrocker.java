/**
 * @author L-Sternhagen
 */

import java.util.*;
public class DayDreamingStockbrocker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();sc.nextLine();
        
        //read input into array
        int[] b = new int[n];
        for(int a = 0; a < n; a++){
            b[a] = sc.nextInt(); sc.nextLine();            
        }
            
        
        long cash = 100;
        long shares = 0;
        long price = 0;
        int i = 0;
        while(true){
            //while less continue
            while(i < n-1 &&  b[i] > b[i+1])i++;
            if(i==n-1){break;}
            //set current price and number of shares
            price = b[i];
            shares = (long)(Math.floor(cash/price));
            //if greater than 100,000
            if(shares > 100000){shares=100000;cash-=(100000*price);}
            //find cash amount leftover
            else cash -= shares* price;       
            //while price is rising
            while(i < n-1 &&  b[i] <= b[i+1])i++;
            //sell shares since price is no longer rising
            cash += shares * (b[i]);
            //if at last day break
            if(i==n-1){break;}
        }
        System.out.println(cash);
        
        
    }
}
