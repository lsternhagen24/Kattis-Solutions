
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem Natjecanje
 https://open.kattis.com/problems/natjecanje
 */
public class Natjecanje {
    public static void main(String[] args)throws Exception {
        //reader for reading input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        //set for containing all the broken kayaks
        Set<Integer> broken = new HashSet<Integer>(); 
        in = br.readLine().split(" ");
        for(int i = 0; i < in.length; i++)broken.add(Integer.parseInt(in[i]));
        //set for containing all the reserved kayaks
        Set<Integer> reserve = new HashSet<Integer>();
        in = br.readLine().split(" ");
        for(int i = 0; i < in.length; i++)reserve.add(Integer.parseInt(in[i]));
        //loop through all the reserved kayaks and remove them from the broken set.
        for(Integer i: reserve){
            if(broken.contains(i))broken.remove(i);
            else if(broken.contains(i-1))broken.remove(i-1);
            else if(broken.contains(i+1))broken.remove(i+1);
        }
        //print output
        System.out.println(broken.size());
    }
}
