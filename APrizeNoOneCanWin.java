
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author L-Sternhagen
 */
public class APrizeNoOneCanWin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long x = sc.nextLong();
        sc.nextLine();
        long[] items = new long[n];
        for(int i = 0; i < n; i++)items[i] = sc.nextLong();
        Arrays.sort(items);
        long output = 0;
        long smallest = items[0];
        for(int i = 0; i < n; i++){
            if(x-smallest-items[i] <0 && i > 0)break;
            smallest = items[i];
            output++;
        }
        System.out.println(output);
        
    }
}
