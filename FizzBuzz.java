

import java.util.Scanner;

/**
 * @author L-Sternhagen
 */
public class FizzBuzz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] in  = sc.nextLine().split(" ");
        int[] in2 = new int[in.length];
        for(int a = 0; a <in.length; a++)in2[a]=Integer.parseInt(in[a]);
        int x = in2[0];
        int y = in2[1];
        int n = in2[2];
        
        for(int i = 1; i <= n ;i++){
            if(isDivisible(i,x) && isDivisible(i,y))System.out.println("FizzBuzz");
            else if(isDivisible(i,x))System.out.println("Fizz");
            else if(isDivisible(i,y))System.out.println("Buzz");
            else System.out.println(i);
        
        
        }
                
    }
    public static boolean isDivisible(int a , int b){
        if(a%b==0)return true;
        return false;
    }
    
    
}
