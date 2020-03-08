
import java.util.Scanner;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem Filip
 https://open.kattis.com/problems/filip
 */
public class Filip {
    public static void main(String[] args) {
        //read input
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        //reverse the strings and print the maximum of the two reversed values
        System.out.println(Math.max(Integer.parseInt(reverseString(line[0])), Integer.parseInt(reverseString(line[1]))));
        
    }
    //reverse a string input
    public static String reverseString(String a){
        String out = "";
        for(int i = a.length()-1; i >=0; i--)out+=a.charAt(i) + "";
        
        return out;
    }
}
