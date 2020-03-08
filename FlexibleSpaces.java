

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem Flexible Places
 https://open.kattis.com/problems/flexible
 */
public class FlexibleSpaces {
    public static void main(String[] args) throws Exception{
        //read input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        int width = Integer.parseInt(data[0]);
        int n = Integer.parseInt(data[1]);
        String[] input = br.readLine().split(" ");
        //initialize all numbers in input and parse into Integers
        int[] nums = new int[n+2]; int pos = 1; nums[0] = 0;
        for(String s: input)nums[pos++] = Integer.parseInt(s);
        nums[pos] = width;
        //set to hold all possible widths
        Set<Integer> all = new HashSet<Integer>();
        for(int i = n+1; i > 0; i--){
            int cur = nums[i];
            for(int j: nums){
                if(j >= cur)continue;
                all.add(cur-j);
            }
        }
        //find and print output
        Integer[] out = all.toArray(new Integer[all.size()]);
        Arrays.sort(out);
        String output = "";
        for(Integer i: out)output+=i+ " ";
        output = output.trim();
        System.out.println(output);
    }
}
