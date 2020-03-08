import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem Exact Change
 https://open.kattis.com/problems/exactchange2
 */
public class ExactChange {

    public static void main(String[] args)throws Exception {
            //read input
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int testCases = Integer.parseInt(br.readLine());
            //for each test case
            for(int y = 0; y < testCases; y++){
                //change needed
                int changeNeeded = Integer.parseInt(br.readLine());                
                
                //number of different bills
                int n = Integer.parseInt(br.readLine());
                //read change amounts into array
                int[] changesAvailable = new int[n];
                for(int i = 0; i <n; i++){changesAvailable[i]=(Integer.parseInt(br.readLine()));}

                int[] allStates = new int[21000];
                //9998+9999 is technically max solution needed to be kept
                for(int i = 0; i  < 21000; i++)allStates[i] = Integer.MAX_VALUE;
                allStates[0]=0;
                //make sure not to update until after slots have been checked
                Map<Integer,Integer> updates;
                //go linearly through every state starting at 0, up until changeNeeded
                for(int k = 0; k < n; k++){
                    updates = new HashMap<Integer,Integer>();
                    int currentCoin = changesAvailable[k];
                    for(int i = 0; i <= changeNeeded; i++){
                        //get current state, if not set yet continue since state is unreachable
                       if(allStates[i]==Integer.MAX_VALUE)continue;
                       //got through every option state has left
                       if(allStates[i]+1 < allStates[i+currentCoin])updates.put(i+currentCoin,allStates[i]+1);
                    }
                    //now update array to keep from updating slot more than once
                    for(int f: updates.keySet())allStates[f]=updates.get(f);
                }
                //find lowest score >= changeneeded
                int best = changeNeeded;
                while(allStates[best]==Integer.MAX_VALUE)best++;

                System.out.println(best + " " + allStates[best]);
            }
    }
}
/*
Test Case
1
10000
10
1000
200
6000
400
2200
900
20
55
87
41
*/
