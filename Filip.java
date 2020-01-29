
import java.util.Scanner;

/**
 * @author L-Sternhagen
 */
public class Filip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        System.out.println(Math.max(Integer.parseInt(reverseString(line[0])), Integer.parseInt(reverseString(line[1]))));
        
    }
    public static String reverseString(String a){
        String out = "";
        for(int i = a.length()-1; i >=0; i--)out+=a.charAt(i) + "";
        
        return out;
    }
}
