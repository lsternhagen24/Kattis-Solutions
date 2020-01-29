
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author L-Sternhagen
 */
public class ABC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int[] d = {a,b,c};
        Arrays.sort(d);
        String output = "";
        sc.nextLine();
        char[] i = sc.nextLine().toCharArray();
        for(int r = 0; r < i.length; r++){
            if(i[r]=='A')output+=d[0] + " ";
            else if(i[r]=='B')output+=d[1]+" ";
            else output+=d[2] + " " ;
        }
        System.out.println(output.trim());
        
    }
}
