
import java.io.*;
import java.util.*;

/**
 *
 * @author lucas
 Solution to Kattis problem Bela\
 https://open.kattis.com/problems/bela
 */
public class Bela {

    public static void main(String[] args) throws Exception {
        //read input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       //read the number of numbers and the trump suit.
        String[] nums = br.readLine().split(" ");
        String trumpSuit = nums[1];
        int hands = Integer.parseInt(nums[0]);
        int sum = 0;
        //loop through each of the hands
        for (int i = 0; i < hands; i++) {
            for (int j = 0; j < 4; j++) {
                String a = br.readLine();
                //get the suit and value from the hand
                String value = a.substring(0, 1);
                String suit = a.substring(1);
                //if the suit is the trump suit then use the dominant value
                if (suit.equals(trumpSuit)) {

                switch(value){
                    case "A": sum+=11;break;
                    case "K": sum+=4;break;
                    case "Q": sum+=3;break;
                    case "J": sum+=20;break;
                    case "T": sum+=10;break;
                    case "9": sum+=14;break;
                    case "8": sum+=0;break;
                    case "7": sum+=0;break;
                    default: sum+=0;
                        break;
                }
                
                }
                //else use the nondominant value
                else {
                switch(value){
                    case "A": sum+=11;break;
                    case "K": sum+=4;break;
                    case "Q": sum+=3;break;
                    case "J": sum+=2;break;
                    case "T": sum+=10;break;
                    case "9": sum+=0;break;
                    case "8": sum+=0;break;
                    case "7": sum+=0;break;
                    default:break;
                    }

                }
            }
        }
        //print output
        System.out.println(sum);
    }

}
