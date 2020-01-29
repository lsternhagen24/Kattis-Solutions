
import java.util.Scanner;

/**
 * @author L-Sternhagen
 */
public class FaucetFlow {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
          
        while(true){
            //read input
            int left = sc.nextInt();
            int right = sc.nextInt(); sc.nextLine();
            if(left==0&&right==0)break;
            String[] in = sc.nextLine().split(" ");
            long[] dividers = new long[in.length];
            for(int i = 0; i < in.length; i++)dividers[i] = Long.parseLong(in[i]);
            //end of reading input

            //find the location where the water drops
            int fill_Location = Math.abs(left/2)+1;
            long sum = getFill3(dividers, fill_Location);
            //print output
            System.out.println(sum);
        }
    }
    //definately not my third attempt at this method, that would be embarressing 
    public static long getFill3(long[] dividers, int fillLocation){
        //get maximum wall on left and right sides
        long leftMax = getHalfMax(dividers, 0, fillLocation);
        long rightMax = getHalfMax(dividers, fillLocation, dividers.length);
        //if maximum is on left, reverse array
        if(leftMax > rightMax){dividers = reverse(dividers); fillLocation = dividers.length - fillLocation;}
        //redo maximums incase reverse was done
        leftMax = getHalfMax(dividers, 0, fillLocation);
        rightMax = getHalfMax(dividers, fillLocation, dividers.length);
        //get the left and right boundary of inner fill zone
        int leftBoundary = getLastMaxIdx(dividers, 0, fillLocation, leftMax);
        int rightBoundary = getFirstMaxIdx(dividers,fillLocation, dividers.length, leftMax);
        //get the sum of this inner boundary
        long sum = (rightBoundary-leftBoundary) * 2 * leftMax;
        //get the left side sum
        long leftSum = calculateSum(dividers, 0, leftBoundary+1);

        //calculate if righside sum needs to be added
        long rightSum = 0;
        //if walls on both sides are even use minimum sum twice
        if(rightMax==leftMax){
            dividers = reverse(dividers);
            fillLocation = dividers.length - fillLocation;
            rightSum = calculateSum(dividers,0,fillLocation);
            sum+=Math.min(leftSum, rightSum) *2;
        }
        //else if right boundary is higher than all of left side add only add left side
        else if(dividers[leftBoundary]< dividers[rightBoundary]) {
            rightSum = 0;
            sum+=leftSum;
        } 
        //else find how much of the rightsum needs to be filled
        else {
            int mxIdx = getFirstMaxIdx(dividers, fillLocation, dividers.length, rightMax);
            long[] b = new long[mxIdx-rightBoundary+1];
            int iterator = 0;
            for(int i = rightBoundary; i <= mxIdx; i++)b[iterator++] = dividers[i];
            rightSum = calculateSum(b, 0, b.length);
            //if the rightsum is greater or equal to all of the leftSum add leftSum twice
            if(rightSum >= leftSum)sum+=leftSum*2;
            //else add leftSum + rightSum to toal
            else sum+= leftSum + rightSum;
        }       
        return sum;
    }
    //calculate the sum given a certain range, from left to right
    public static long calculateSum(long[] dividers, int start, int end){
        long max = dividers[start];
        long sum = 0;
        int current_position = 0;
        for(int i = start+1; i < end; i++){
            if(i==end-1)return sum +=(i-current_position) * max * 2;
            if(dividers[i] > max){
                sum+=(i-current_position) * max * 2;
                max = dividers[i];
                current_position = i;
            }
        }
        return sum;
    }
    //helper functions for max indexes and values
    public static int getLastMaxIdx(long[] a, int start, int end, long comparator){
        int maxIdx = -1;
        for(int i =start; i < end; i++){
            if(a[i] >= comparator){ maxIdx=i;}
        }
        return maxIdx;
    }
    public static int getFirstMaxIdx(long[] a, int start, int end, long comparator){
        int maxIdx = -1;
        for(int i =start; i < end; i++){
            if(a[i] >= comparator){maxIdx=i;break;}
        }
        return maxIdx;
    }
    public static long getHalfMax(long[]a, int start, int end){
        long max = -1;
        for(int i = start; i < end; i++)if(a[i] > max)max = a[i];
        return max;
    }
    static long[] reverse(long a[]) 
    { 
        int n = a.length;
        long[] b = new long[n]; 
        int j = n; 
        for (int i = 0; i < n; i++) { 
            b[j - 1] = a[i]; 
            j = j - 1; 
        } 
        return b;
    }
}
