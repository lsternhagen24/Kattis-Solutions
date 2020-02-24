
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Baloni {
    public static void main(String[] args){
        //read all input
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int numOf = Integer.parseInt(sc.nextLine());
        //contains flights of arrows.
        int[] heights = new int[numOf];
        for(int f = 0; f < numOf; f++){
            heights[f] = sc.nextInt();
        }
        //holds all possible heights for balloons
        int[] arr = new int[1000000];
        //loop through all heights of known balloons
        for(int i = 0; i < numOf; i++){
            //get the current height
            int current = heights[i];
            //if we already have an arrow flying at this height subtract it and add that arrow's flight to the level below.
            if(arr[current] > 0){
                arr[current]--;
                arr[current-1]++;
            }
            //else we need to shoot an arrow at this height so update count. Add arrow flight to flight below.
            else{
                arr[current-1]++;
                count++;
            }
        }
        //print output
        System.out.println(count);
    }
}
