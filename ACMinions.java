
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author lucas
 Solution to kattis problem Air Conditioned Minions
 https://open.kattis.com/problems/airconditioned
 */
public class ACMinions {

    public static void main(String[] args) throws Exception {
        //BufferedReader to read input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //read number of minions
        int n = Integer.parseInt(br.readLine());
        //Array of sets of integers for each possible room. Inilialize all rooms.
        Set<Integer>[] rooms = new HashSet[2*n];
        for(int i = 0; i< rooms.length; i++){
            rooms[i] = new HashSet<Integer>();
        }
        //loop through every minion
        for(int m = 0; m < n; m++){
            //read each minion's minimum and maximum temperatures into aray
            String[] line = br.readLine().split(" ");
            //add each minion's maximum temperature to it's minumum room
            rooms[Integer.parseInt(line[0])-1].add(Integer.parseInt(line[1])-1);
        }
        int min = Integer.MAX_VALUE, count = 0;
        //loop through each room, increment count of number of rooms needed if higher temperature is found
        for(int i = 0; i < rooms.length; i++){
            //if element in previous room has higher value than room number increment number of rooms needed
            if(min < i){ min = Integer.MAX_VALUE; count++;}
            //loop through elements in room and find max temperature in room.
            for(int e : rooms[i]) if(min > e) min = e;
        }
        //if we only need one room case
        if(min < rooms.length) count++;
        //print count
        System.out.println(count);
    }
}
