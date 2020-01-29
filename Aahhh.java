
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author L-Sternhagen
 */
public class Aahhh {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        if(a.length() < b.length())System.out.println("no");
        else System.out.println("go");
    }
}
