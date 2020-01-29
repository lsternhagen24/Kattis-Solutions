

/**
 * @author L-Sternhagen
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class EnlargingHashTables {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int cur = -1;
        
        while((cur = Integer.parseInt(br.readLine()))!=0){
           String out = isPrime(cur) ? "" : " (" + cur + " is not prime)";
           
            System.out.println(nextPrime(cur) + out);
        
        
        }
        
        
        
        
    }
    
    
    
    public static int nextPrime(int i){
        int out = i*2+1;
        if(out%2==0)out+=1;
        while(true){
            if(isPrime(out))break;
            out+=2;
        }
        return out;
    }
    public static boolean isPrime(int i){
        int x = ((int)Math.sqrt(i)) + 1;
        for(int d = 2; d < x; d++){
            if(i%d==0)return false;
        }
        return true;
    
    
    }
}
