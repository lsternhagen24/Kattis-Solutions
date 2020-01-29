/**
 * @author L-Sternhagen
 */
import java.util.*;

public class DaylightSavings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int testCases = sc.nextInt();sc.nextLine();
        
        
        for(int q = 0; q < testCases; q++){
        
            String[] input = sc.nextLine().split(" ");
            char r = input[0].charAt(0);
            int minutes = Integer.parseInt(input[1]);
            int curHour = Integer.parseInt(input[2]);
            int curMin = Integer.parseInt(input[3]);
            
            if(r=='F'){
                while(minutes>60){minutes-=60;curHour++;}
                if(minutes+curMin>=60){curMin=curMin+minutes-60; curHour++;}
                else{curMin+=minutes;}
                if(curHour>=24)curHour-=24;
            }else{
                while(minutes>60){minutes-=60;curHour--;}
                if(curMin-minutes<0){curMin=(60+curMin-minutes); curHour--;}
                else {curMin-=minutes;}
                if(curHour<0)curHour+=24;
            
            
            }
            System.out.println(curHour + " " + curMin);
            
        
        
        }
        
        
        
        
    }
}
