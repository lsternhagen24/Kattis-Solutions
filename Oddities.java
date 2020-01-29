/**
 * @author L-Sternhagen
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Oddities {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for(int a = 0; a < testCases; a++){
        int cur = Integer.parseInt(br.readLine());
        if(cur%2==0)System.out.println(cur + " is even");
        else System.out.println(cur + " is odd");
        }
    }
}
