/**
 * @author L-Sternhagen
 Solution to kattis problem Daylight Savings Time
 https://open.kattis.com/problems/dst
 */
import java.util.*;

public class DaylightSavings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //read number of testCases
        int testCases = sc.nextInt();sc.nextLine();
        //loop through testcases
        for(int q = 0; q < testCases; q++){
            //read input
            String[] input = sc.nextLine().split(" ");
            char r = input[0].charAt(0);
            //read number of minutes to change, current minute, current hour
            int minutes = Integer.parseInt(input[1]);
            int curHour = Integer.parseInt(input[2]);
            int curMin = Integer.parseInt(input[3]);
            //if we are rolling clock forward
            if(r=='F'){
                //first increment hour
                while(minutes>60){minutes-=60;curHour++;}
                //if we need to increment hour due to minutes
                if(minutes+curMin>=60){curMin=curMin+minutes-60; curHour++;}
                //else add to minutes
                else{curMin+=minutes;}
                //if we are on a new day, subtract 24 hours
                if(curHour>=24)curHour-=24;
            }else{
                //deincrement hours
                while(minutes>60){minutes-=60;curHour--;}
                //move hour backwards if we have leftover minutes
                if(curMin-minutes<0){curMin=(60+curMin-minutes); curHour--;}
                //else subtract from minutes
                else {curMin-=minutes;}
                //if we are on previous day increment by 24 hours
                if(curHour<0)curHour+=24;
            }
            //print output
            System.out.println(curHour + " " + curMin);
        }
    }
}
