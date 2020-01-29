
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author L-Sternhagen
 */
public class Simon {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for(int i = 0; i < testCases; i++){;
        String input = br.readLine();
        Matcher m = Pattern.compile("^simon says (.*)").matcher(input);
        if(m.find())System.out.println(m.group(1));
        else System.out.println("");
        }
    }
}
