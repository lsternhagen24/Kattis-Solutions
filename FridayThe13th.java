
import java.util.Scanner;

/**
 * @author L-Sternhagen
 */
public class FridayThe13th {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for(int q = 0; q < testCases; q++){
            int days = sc.nextInt(); 
            int months = sc.nextInt();
            int fridays_the_13th = 0;
            int day = 0;
            int[] days_in_each_month = new int[months];
            //read in months
            for(int r = 0; r < months; r++)days_in_each_month[r] = sc.nextInt();
            //for each month
            for(int i = 0; i < months; i++){
                //get current number of days in month
                int days_in_current_month = days_in_each_month[i];
                //for each day if it is a friday and the 13th then update the number of friday the 13ths
                for(int j = 0; j < days_in_current_month; j++){
                    if(day==5&&j==12)fridays_the_13th++;
                    day++;
                    if(day==7)day=0;      
                }
            }
            System.out.println(fridays_the_13th);
        }
        
        
        
        
    }
}
