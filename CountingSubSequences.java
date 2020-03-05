import java.util.*;
/**
 * @author lucas
 * Solution to Kattis problem Counting Subsequences.
 * https://open.kattis.com/problems/subseqhard
 */
public class CountingSubSeq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_cases = Integer.parseInt(sc.nextLine());
        //loop through each test case
        for(int t = 0; t < test_cases; t++){
            sc.nextLine(); sc.nextLine();
            //read input
            String[] nums = sc.nextLine().split(" ");
            //hold each sum and the amount of times we have seen it
            Map<Long,Integer> distinctNumCount = new HashMap<Long,Integer>();
            //we start with 0 sum
            distinctNumCount.put(0L, 1);
            int count47 = 0; long curSum = 0L;
            //loop through each integer
            for(int i = 0; i < nums.length; i++){
                //add to current sum
                curSum += Long.parseLong(nums[i]);
                //if we have encountered this sum before increment it
                if(distinctNumCount.containsKey(curSum)){
                    distinctNumCount.put(curSum, distinctNumCount.get(curSum) + 1);
                }
                //else put map it to one
                else distinctNumCount.put(curSum, 1);
                //add the number of times we have seen a sum that is 47 less than current sum, or 0 if we haven't seen any
                count47+= distinctNumCount.getOrDefault(curSum-47, 0);
            }
            //print output
            System.out.println(count47);  
        }
    }
}
