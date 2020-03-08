
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem First Orchard
 https://open.kattis.com/problems/orchard
 */
public class FirstOrchard {
    //hold all state's winning probabilities for memoization 
    static Map<String,Double> states = new HashMap<String,Double>();
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] simulation = new Integer[5];
        for(int i = 0; i < 5; i++)simulation[i] = sc.nextInt();
        //done reading input
        System.out.println(getProbability(simulation)/100);

    }
    
    public static double getProbability(Integer[] current_state){
        //if raven has arrived win percentage is 0
        if(current_state[4]==0)return 0;
        //if all fruit baskets are empty win percentage is 100
        if(getSum(current_state)==0){return (double)(100);}
        //find the max fruit basket index
        int gMax = getMaxIndex(current_state);
        
        double current_sum = 0;
        //probability of rolling the max fruit basket index
        double max_probability = (double)2/(double)getNonZeros(current_state);
        //probability of rolling any other index
        double regular_probability = (double)1/(double)getNonZeros(current_state);
        //go through each index
        for(int i = 0; i < 5; i++){
            Integer[] newCur = Arrays.copyOf(current_state, 5);
            newCur[i]--;
            //if state is already at 0 continue
            if(newCur[i] < 0)continue;
            //if at the max fruit basket use the max probability (one more than regular probability to roll), else use regular
            //check if current state's probability has been solved first in map, otherwise calculate it
            if(i==gMax)current_sum+= states.containsKey(Arrays.toString(newCur)) ? max_probability * states.get(Arrays.toString(newCur)): max_probability*getProbability(newCur);
            else current_sum+= states.containsKey(Arrays.toString(newCur)) ? regular_probability * states.get(Arrays.toString(newCur)):regular_probability*getProbability(newCur);
        }
        //add state to map for memoization
        states.put(Arrays.toString(current_state),current_sum);
        return current_sum;
    }
    
    //return nuber of nonzero numbers in array
    public static double getNonZeros(Integer[] a){
        double count = 1;
        for(int i = 0; i < 5; i++){
            if(a[i]>0)count++;
        }
        return count;
        
    }
    //return the index of the most filled fruit baseket
    public static int getMaxIndex(Integer[] a){
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i = 0; i < 4; i++){
            if(a[i]>0 && a[i] > maxValue){maxIndex = i; maxValue = a[i];}
        }
        return maxIndex;
    }
    //get the sum of the fruit baskets
    public static int getSum(Integer[] a){
        int sum = 0;
        for(int i = 0; i < 4; i++){
            sum+=a[i];
        }
        return sum;
    }
}
