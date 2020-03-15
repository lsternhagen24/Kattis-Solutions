/**
 * @author L-Sternhagen
 Solution to Kattis Problem Train Passengers
 https://open.kattis.com/problems/trainpassengers
 */
import java.util.*;
public class TrainPassengers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //read the capacity and number of stops
        int capacity = sc.nextInt();
        int stops = sc.nextInt();
        sc.nextLine();
        
        int current = 0;
        boolean possible = true;
        //loop through each stop
        for(int q = 0; q < stops; q++){
            int left = sc.nextInt();
            int join = sc.nextInt();
            int stayed = sc.nextInt();
            //if our current capacity is too great or we reach an impossible scenario then break with possible as false
            if(q==0 && left > 0){possible = false; break;}
            if(q==stops-1&&stayed>0){possible = false; break;}
            current = current+join-left;
            if(current>capacity || current < 0 || (current < capacity && stayed>0)){possible = false; break;}

        }
        //print output
        if(current!=0)possible = false;
        if(possible == false)System.out.println("impossible");
        else System.out.println("possible");
    }
}
