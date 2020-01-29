
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author L-Sternhagen
 */
public class FlagQuiz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        int n = sc.nextInt(); sc.nextLine();
        String[]firstLine = sc.nextLine().split(", ");
        int numParts = firstLine.length;
        String[][] input = new String[n][numParts];
        input[0] = firstLine;
        for(int i = 1; i < n; i++)input[i] = sc.nextLine().split(", ");
        //build map for fast lookups to use for faster comparing strings
        Map<String,Integer> comparer = new HashMap<String, Integer>();
        int iterator = 0;
        for(int a = 0; a < n; a++){
            for(int b = 0; b < numParts; b++){
                if(!comparer.containsKey(input[a][b]))comparer.put(input[a][b], iterator++);
            }
        }
        //hold the max sum of number of changes for each answer
        int[] sums = new int[n];
        Arrays.fill(sums,0);
        //loop through every answer and compare to every other answer
        for(int f = 0; f < n; f++){
            //for every other answer
            for(int e = 0; e < n; e++){
                //if on same answer continue
                if(e==f)continue;
                int sum = 0;
                //for each part in each answer compare them
                for(int r = 0; r < numParts; r++){
                    //if the two parts are not equal incriment the sum
                    if(!comparer.get(input[f][r]).equals(comparer.get(input[e][r])))sum++;
                }
                if(sums[f] < sum)sums[f]=sum;
            }
            
        }
        //find the minimum number of changes needed and all equal ones to an arraylist
        ArrayList<Integer> mins = new ArrayList<Integer>();
        int minsum  = Integer.MAX_VALUE;
        for(int q = 0; q < n; q++){
            if(sums[q] < minsum){
                minsum = sums[q];
                mins.clear();
                mins.add(q);
            } else if(sums[q]==minsum)mins.add(q);
        }
        //print all min answers
        for(Integer p: mins){System.out.println(printString(input[p]));}
        
        
    }
    public static String printString(String[] g){
        String output = "";
        for(String i: g){
            output+= i + ", ";
        }
        output = output.substring(0,output.lastIndexOf(","));
        output = output.trim();
        return output;
    }
}
