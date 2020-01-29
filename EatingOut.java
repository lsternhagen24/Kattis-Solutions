
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author L-Sternhagen
 */
public class EatingOut {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        
        ArrayList<Integer> a = new ArrayList<Integer>();
        //read input and sort it largest to smallest
        for(int i = 0; i < 3; i++)a.add(sc.nextInt());
        Collections.sort(a);
        Collections.reverse(a);
        
        //overlap array
        int[] overlap = new int[m];
        //initialize to 0
        for(int i =0; i < m; i++)overlap[i]=0;
        //add largest pick first, then second, and finally third
        //use greedy to add to smallest first
        for(int g = 0; g < 3; g++){
            int currentPerson = a.get(g);
            //attempt to fill 0 bucket first, then 1, then 2
            int minBucket = 0;
            //while picks are still left
            while(currentPerson > 0){
                //go through buckets and look for smallest to add to
                for(int i = 0; i < m; i++){
                    if(currentPerson==0)break;
                    if(overlap[i]==minBucket){
                        overlap[i]++;
                        currentPerson--;
                    }
                }
                minBucket++;
            }
        }
        
        
        
        //find if all 3 have same pick 
        boolean found = false;
        for(int i = 0; i < m; i++){if(overlap[i]>2)found = true;}
        //output
        if(found)System.out.println("impossible");
        else System.out.println("possible");
        
        
        
        
    }
}
