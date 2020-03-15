
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem Simon
 https://open.kattis.com/problems/simon
 */
public class Simon {
    public static void main(String[] args)throws Exception {
        //reader for reading input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        //loop through all test cases
        for(int i = 0; i < testCases; i++){
            String input = br.readLine();
            //use regex to find the number matches and all strings that match, then print
            Matcher m = Pattern.compile("^simon says (.*)").matcher(input);
            if(m.find())System.out.println(m.group(1));
            else System.out.println("");
        }
    }
}
