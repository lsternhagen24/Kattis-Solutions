
import java.io.*;
import java.util.*;

/**
 *
 * @author lucas
 */
public class Bela {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        String trumpSuit = nums[1];
        int hands = Integer.parseInt(nums[0]);
        int sum = 0;
        for (int i = 0; i < hands; i++) {
            for (int j = 0; j < 4; j++) {
                String a = br.readLine();
                String value = a.substring(0, 1);
                String suit = a.substring(1);

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
        System.out.println(sum);

    }

}
