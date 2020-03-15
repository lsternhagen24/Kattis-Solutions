

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem Permutationf Encryption
 https://open.kattis.com/problems/permutationencryption
 */
public class PermutationEncription {
    public static void main(String[] args) throws Exception{
        //reader for reading input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        //loop until we reach the end of input
        while(!((line = br.readLine()).equals("0"))){
           String input = line.substring(line.indexOf(" ")+1);
           String[] e = input.split(" ");
           int [] encyption = new int[e.length];int p = 0;
           //read the encryption 
           for(String i: e)encyption[p++]= Integer.parseInt(i);
           String message = br.readLine();
           char[] m = message.toCharArray();
            //calculate the encryption
           String output = encrypt(m, encyption);
           //print the output
            System.out.println(output);
        }
    }
    public static String encrypt(char[] message, int[] encyption){
        double n = (Math.ceil(((double)message.length)/((double)encyption.length)));
        int num = (int)n;
        char[] out = new char[num*encyption.length];int cpos = 0;
        //loop through each character 
        for(int i = 0; i < num; i++){
            int pos = 0;
            for(int j = 0; j < encyption.length;j++){
               //encypt the message using the encryption passed in
                out[cpos++] = ((i*encyption.length+encyption[pos]-1) >= message.length)  ? ' ': message[i*encyption.length+encyption[pos]-1];
                pos++;
            }
        }
        //concat output into string and return
        String o = "";
        for(char h: out)o+=h;
        return "'" + o + "'";
    }
}
