
import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem Fractiponal Lotion
 https://open.kattis.com/problems/fractionallotion
 */
public class FractionalLotion {
    public static void main(String[] args)throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));        
        //while read input
        String line = "";
        while((line=in.readLine())!=null){
            //read n
            int n = Integer.parseInt(line.substring(line.indexOf("/")+1));
            int count = 0;
            //go from n+1 to n*2+1
            for(int aa=n+1; aa < n*2+1; aa++ ){
                int r = aa-n;
                int g = n*n+r*n;
                //if we have found a solution increment count
                if(g%r==0){count++;}
            }
            //print out count
            out.write(count + "\n");           
        }
        out.flush();
    }
}
