import java.util.Scanner;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem Falling Mugs
 https://open.kattis.com/problems/falling
 */
public class FallingMugs {
    public static void main(String[] args) {
        //read input
        Scanner sc = new Scanner(System.in);
        long d = sc.nextLong();
        long cur = 0;
        //loop until we reach the distance or we get too fast
        while(true){
            long newA = cur * cur;
            double newB = Math.sqrt(d+newA);
            if(newB%1==0){System.out.println(cur + " " + (int)newB);break;}
            else if(cur>10000000){System.out.println("impossible");break;}
            else {cur++; }
        }
    }
}
