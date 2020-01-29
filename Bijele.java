
import java.util.Scanner;

/**
 * @author L-Sternhagen
 */
public class R2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] c = {1,1,2,2,2,8};
        int [] p = new int[6];
        for(int i = 0; i < 6; i++)p[i] = sc.nextInt();
        String out = "";
        for(int i = 0; i < 6; i++){
            if(i!=0)out+=" ";
            int g = c[i]-p[i];
            out+=""+ g;
        }
        System.out.println(out);
    }
}
