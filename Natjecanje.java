
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @author L-Sternhagen
 */
public class Natjecanje {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        Set<Integer> broken = new HashSet<Integer>(); 
        in = br.readLine().split(" ");
        for(int i = 0; i < in.length; i++)broken.add(Integer.parseInt(in[i]));
        Set<Integer> reserve = new HashSet<Integer>();
        in = br.readLine().split(" ");
        for(int i = 0; i < in.length; i++)reserve.add(Integer.parseInt(in[i]));
        for(Integer i: reserve){
            if(broken.contains(i))broken.remove(i);
            else if(broken.contains(i-1))broken.remove(i-1);
            else if(broken.contains(i+1))broken.remove(i+1);
        }
        System.out.println(broken.size());
    }
}
