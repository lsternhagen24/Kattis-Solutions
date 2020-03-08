
import java.util.Scanner;

/**
 * @author L-Sternhagen
 Solution to kattis problem Event Planning
 https://open.kattis.com/problems/eventplanning
 */
public class EventPlanning {
    public static void main(String[] args) {
        //read input
        Scanner sc = new Scanner(System.in);
        int people = sc.nextInt();
        int budget = sc.nextInt();
        int hotels = sc.nextInt();
        int weeks = sc.nextInt();
        sc.nextLine();
        int minimum = -1;
        //loop through each hotel
        for(int g = 0; g < hotels; g++){
            //read price for hotel
            int price = sc.nextInt();sc.nextLine();
            //if the pice is greater than the budget then skip the hotel
            if(price*people>budget){sc.nextLine(); continue;}
            //loop through every week possible for this hotel
            for(int h = 0; h < weeks; h++){
                //read the number of open rooms
                int openRooms = sc.nextInt();
                //if there are enough open rooms and we havent booked a room yet this is the new best offer
                if(openRooms>=people&&minimum==-1){minimum=price;break;}
                //if there are enough open rooms and this is the new best price
                if(openRooms>-people&&price < minimum){minimum=price;break;}
            }
            //read next line of input
            sc.nextLine();
        }
        //if we never found a hotel or weekend that worked print 'stay home', otherwise print minimum price found
        if(minimum==-1)System.out.println("stay home");
        else System.out.println(minimum * people);
    }
}
