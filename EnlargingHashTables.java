

/**
 * @author L-Sternhagen
 Solution to Kattis Problem Enlarging Hashtables
 https://open.kattis.com/problems/engineeringenglish
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class EnlargingHashTables {
    public static void main(String[] args)throws Exception {
        //stream for reading input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //initialize cur
        int cur = -1;
        //loop through all input
        while((cur = Integer.parseInt(br.readLine()))!=0){
            //if the number is not prime add the 'is not prime' part of the output
           String out = isPrime(cur) ? "" : " (" + cur + " is not prime)";
           //find the next prime and print it
           System.out.println(nextPrime(cur) + out);
        }
    }
    //finds the smallest prime that is at least 2x+1 greater than the input
    public static int nextPrime(int i){
        int out = i*2+1;
        if(out%2==0)out+=1;
        //loop until we find the next prime
        while(true){
            if(isPrime(out))break;
            out+=2;
        }
        return out;
    }
    //checks if a number is prime or not
    public static boolean isPrime(int i){
        //loop from 2 to the square root
        int x = ((int)Math.sqrt(i)) + 1;
        for(int d = 2; d < x; d++){
            //if we don't have a remainder the number is not prime
            if(i%d==0)return false;
        }
        //number is prime return true
        return true;
    }
}
