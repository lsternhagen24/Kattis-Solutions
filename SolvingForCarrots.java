
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem Solving For Carrots
 https://open.kattis.com/problems/carrots
 */
public class SolvingForCarrots {
    public static void main(String[] args)throws Exception {
        //reader for reading input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        //solution will always be second number.
        System.out.println(a[1]);
    }
}
