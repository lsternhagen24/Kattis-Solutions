import java.util.Scanner;

/**
 * @author L-Sternhagen
 */
public class FallingMugs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long d = sc.nextLong();
        long cur = 0;
       // long oldDiff = 1;
        while(true){
            long newA = cur * cur;
            double newB = Math.sqrt(d+newA);
            if(newB%1==0){System.out.println(cur + " " + (int)newB);break;}
            else if(cur>10000000){System.out.println("impossible");break;}
            else {cur++; }
        
        }
        
        
        
        
        
        
    }
}
