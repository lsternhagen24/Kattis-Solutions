
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem Engineering English
 https://open.kattis.com/problems/engineeringenglish    
 */
public class EngineeringEnglish {
    public static void main(String[] args)throws Exception {
        //stream reader for input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        //set to contain words we have already seen
        Set<String> h = new HashSet<String>();
        //loop through all input
        while((line = br.readLine())!= null){
            String out = "";
            //split on all words
            String[] in = line.split(" ");
            for(String i: in){
                //if we have already seen the word then add a period
                if(h.contains(i.toLowerCase()))out+=". ";
                else {
                    //otherwise add the word to our set and add the word
                    h.add(i.toLowerCase());
                    out+= i + " ";
                }
            }
            //print output
            System.out.println(out);
        }
    }
}
