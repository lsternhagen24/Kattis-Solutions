
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem Aaah
 https://open.kattis.com/problems/aaah
 */
public class Aahhh {
    public static void main(String[] args) throws Exception {
        //read input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        //if A is longer print no
        if(a.length() < b.length())System.out.println("no");
        //else print go
        else System.out.println("go");
    }
}
