

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author L-Sternhagen
 */
public class PermutationEncription {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while(!((line = br.readLine()).equals("0"))){
           String input = line.substring(line.indexOf(" ")+1);
           String[] e = input.split(" ");
           int [] encyption = new int[e.length];int p = 0;
           for(String i: e)encyption[p++]= Integer.parseInt(i);
           String message = br.readLine();
           char[] m = message.toCharArray();
           String output = encrypt(m, encyption);
            System.out.println(output);
        }
    }
    public static String encrypt(char[] message, int[] encyption){
        double n = (Math.ceil(((double)message.length)/((double)encyption.length)));
        int num = (int)n;
     //   System.out.println(n);
     //   System.out.println(num + " " + encyption.length);
     //   System.out.println(message.length);
        char[] out = new char[num*encyption.length];int cpos = 0;
        for(int i = 0; i < num; i++){
            int pos = 0;
            for(int j = 0; j < encyption.length;j++){
               // System.out.println("i is: " + i + " j is: " + j);
                out[cpos++] = ((i*encyption.length+encyption[pos]-1) >= message.length)  ? ' ': message[i*encyption.length+encyption[pos]-1];
                pos++;
            }
        }
        String o = "";
        for(char h: out)o+=h;
        return "'" + o + "'";
    }
}
