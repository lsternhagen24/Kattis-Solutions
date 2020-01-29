
import java.util.Scanner;

/**
 * @author L-Sternhagen
 */
public class EventPlanning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int people = sc.nextInt();
        int budget = sc.nextInt();
        int hotels = sc.nextInt();
        int weeks = sc.nextInt();
        sc.nextLine();
        int minimum = -1;
        
        for(int g = 0; g < hotels; g++){
            
            int price = sc.nextInt();sc.nextLine();
            if(price*people>budget){sc.nextLine(); continue;}
            
            for(int h = 0; h < weeks; h++){
                int openRooms = sc.nextInt();
                if(openRooms>=people&&minimum==-1){minimum=price;break;}
                if(openRooms>-people&&price < minimum){minimum=price;break;}
            }
        
        
            sc.nextLine();
        }
        if(minimum==-1)System.out.println("stay home");
        else System.out.println(minimum * people);
        
        
        
    }
}
