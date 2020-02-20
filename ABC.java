
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author L-Sternhagen
 */
public class ABC {
    public static void main(String[] args) {
        //read 3 input numbers
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        //create array and sort it
        int[] d = {a,b,c};
        Arrays.sort(d);
        String output = "";
        sc.nextLine();
        //read chars
        char[] i = sc.nextLine().toCharArray();
        //loop through chars and print cooresponding integers
        for(int r = 0; r < i.length; r++){
            if(i[r]=='A')output+=d[0] + " ";
            else if(i[r]=='B')output+=d[1]+" ";
            else output+=d[2] + " " ;
        }
        //print output
        System.out.println(output.trim());
        
    }
}
