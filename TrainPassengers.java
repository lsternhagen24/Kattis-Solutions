/**
 * @author L-Sternhagen
 */
import java.util.*;
public class TrainPassengers {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        
        int capacity = sc.nextInt();
        int stops = sc.nextInt();
        sc.nextLine();
        
        int current = 0;
        boolean possible = true;
        for(int q = 0; q < stops; q++){
            int left = sc.nextInt();
            int join = sc.nextInt();
            int stayed = sc.nextInt();
            if(q==0 && left > 0){possible = false; break;}
            if(q==stops-1&&stayed>0){possible = false; break;}
            current = current+join-left;
            if(current>capacity || current < 0 || (current < capacity && stayed>0)){possible = false; break;}
            
        
        }
        if(current!=0)possible = false;
        if(possible == false)System.out.println("impossible");
        else System.out.println("possible");
        
        
        
        
        
    }
}
