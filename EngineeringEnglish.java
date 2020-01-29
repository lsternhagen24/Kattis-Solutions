
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @author L-Sternhagen
 */
public class EngineeringEnglish {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Set<String> h = new HashSet<String>();
        while((line = br.readLine())!= null){
            String out = "";
            String[] in = line.split(" ");
            for(String i: in){
                if(h.contains(i.toLowerCase()))out+=". ";
                else {
                    h.add(i.toLowerCase());
                    out+= i + " ";
                }
            }
            System.out.println(out);
        }
    }
}
