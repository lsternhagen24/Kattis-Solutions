
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem False Sense of Security
 https://open.kattis.com/problems/falsesecurity
 */
public class FalseSense {
    public static void main(String[] args) {
        //scanner for reading input
        Scanner sc = new Scanner(System.in);
        //map all codes to eachother for quick lookups               
        Map<String,String> aToMorse = new HashMap<String,String>();
        aToMorse.put("A", ".-");
        aToMorse.put("B", "-...");
        aToMorse.put("C", "-.-.");
        aToMorse.put("D", "-..");
        aToMorse.put("E", ".");
        aToMorse.put("F", "..-.");
        aToMorse.put("G", "--.");
        aToMorse.put("H", "....");
        aToMorse.put("I", "..");
        aToMorse.put("J", ".---");
        aToMorse.put("K", "-.-");
        aToMorse.put("L", ".-..");
        aToMorse.put("M", "--");
        aToMorse.put("N", "-.");
        aToMorse.put("O", "---");
        aToMorse.put("P", ".--.");
        aToMorse.put("Q", "--.-");
        aToMorse.put("R", ".-.");
        aToMorse.put("S", "...");
        aToMorse.put("T", "-");
        aToMorse.put("U", "..-");
        aToMorse.put("V", "...-");
        aToMorse.put("W", ".--");
        aToMorse.put("X", "-..-");
        aToMorse.put("Y", "-.--");
        aToMorse.put("Z", "--..");
        aToMorse.put("_", "..--");
        aToMorse.put(",", ".-.-");
        aToMorse.put(".", "---.");
        aToMorse.put("?", "----");
        //map all morse codes back to english
        Map<String, String> morseToA = new HashMap<String,String>();
        for(String i: aToMorse.keySet())morseToA.put(aToMorse.get(i),i);
       
        //read input
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String code = "";
            String lengths = "";
            //first convert back to morse code
            for(int i = 0; i < line.length(); i++){
                String cur = aToMorse.get(line.charAt(i)+"");
                code+=cur;
                lengths+=cur.length()+"";
            }
            //reverse lengths again
            String lengthsReversed = "";
            for(int i = lengths.length()-1; i >=0; i--)lengthsReversed+=lengths.charAt(i);
            //convert back to english
            String output = "";
            for(int i = 0; i < lengthsReversed.length(); i++){
                int c = Integer.parseInt(lengthsReversed.charAt(i)+"");
                String gg = "";
                for(int j = 0; j  < c; j++){gg+=code.charAt(j);}
                code=code.substring(c);
                output+=morseToA.get(gg);
            }
            //print output
            System.out.println(output);
        }
    }
}
