import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author lucas
 * Solution to Kattis problem CD
 * https://open.kattis.com/problems/cd
 */
public class CD {
    public static void main(String[] args)throws Exception {
        //read first two inputs to get number of cd's to read
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        String line = br.readLine();

        //loop while there are more test cases
        while(!line.equals("0 0")){
            int a = Integer.parseInt(line.substring(0,line.indexOf(" ")));
            int b = Integer.parseInt(line.substring(line.indexOf(" ")+1));
            HashSet<Integer> set = new HashSet<Integer>();
            int output = 0;
            //loop through every CD
            for(int i = 0; i < a+b; i++){
                int cur = Integer.parseInt(br.readLine());
                //if we already have the CD then we have a duplicate
                if(set.contains(cur))output++;
                //else add to our set
                else set.add(cur);
            }
            //print output
            System.out.println(output);
            line = br.readLine();
        }
    }
}
