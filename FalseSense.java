
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author L-Sternhagen
 */
public class FalseSense {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
                
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
        Map<String, String> morseToA = new HashMap<String,String>();
        for(String i: aToMorse.keySet())morseToA.put(aToMorse.get(i),i);
        
        
        
        
        
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String code = "";
            String lengths = "";
            for(int i = 0; i < line.length(); i++){
                String cur = aToMorse.get(line.charAt(i)+"");
                code+=cur;
                lengths+=cur.length()+"";
            }
            String lengthsReversed = "";
            for(int i = lengths.length()-1; i >=0; i--)lengthsReversed+=lengths.charAt(i);
            
            String output = "";
            for(int i = 0; i < lengthsReversed.length(); i++){
                int c = Integer.parseInt(lengthsReversed.charAt(i)+"");
                String gg = "";
                for(int j = 0; j  < c; j++){gg+=code.charAt(j);}
                code=code.substring(c);
                output+=morseToA.get(gg);
            
            }
            System.out.println(output);
            
            
        }
        
    }
}
