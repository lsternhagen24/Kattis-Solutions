import java.util.Scanner;
/**
 * @author L-Sternhagen
 Solution to Kattis Problem FizzBuzz
 https://open.kattis.com/problems/fizzbuzz
 */
public class FizzBuzz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //read input
        String[] in  = sc.nextLine().split(" ");
        int x = Integer.ParseInt(in[0]);
        int y = Integer.ParseInt(in[1]);
        int n = Integer.ParseInt(in[2]);
        
        //loop through and print output
        for(int i = 1; i <= n ;i++){
            if(isDivisible(i,x) && isDivisible(i,y))System.out.println("FizzBuzz");
            else if(isDivisible(i,x))System.out.println("Fizz");
            else if(isDivisible(i,y))System.out.println("Buzz");
            else System.out.println(i);
        }           
    }
    //return true is a is divisible by b, else false
    public static boolean isDivisible(int a , int b){
        if(a%b==0)return true;
        return false;
    }
}
