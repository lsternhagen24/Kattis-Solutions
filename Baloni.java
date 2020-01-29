
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Baloni {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int numOf = Integer.parseInt(sc.nextLine());
        int[] heights = new int[numOf];
        for(int f = 0; f < numOf; f++){
            heights[f] = sc.nextInt();
        }
        int[] arr = new int[1000000];

        for(int i = 0; i < numOf; i++){
            int current = heights[i];
            if(arr[current] > 0){
                arr[current]--;
                arr[current-1]++;
            }
            else{
                arr[current-1]++;
                count++;
            }
        }
        System.out.println(count);
    }
}
