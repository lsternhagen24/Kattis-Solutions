import java.util.Scanner;

/**
 *
 */
public class FireFly {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int h = sc.nextInt();
        
        int[] cCount = new int[h];
        int[] gCount = new int[h];
        
        //read input
        for(int i = 0; i < n; i++){
            if(i%2==0)gCount[sc.nextInt()-1]++;
            else cCount[h-sc.nextInt()]++;
        }
        //stalag
        int[] oCount = new int[h];
        oCount[0] = cCount[0];
        for(int i = 1; i < h; i++){
            oCount[i] = oCount[i-1] + cCount[i];
        }
        //stala
        int gg = 0;
        for(int i = h-1; i >=0; i--){
            gg=gg+gCount[i];
            oCount[i]+=gg;
        }
                            
        int minO = Integer.MAX_VALUE;
        int minCount = 0;
        for(int i = 0; i < h; i++){
            if(oCount[i] < minO){minO=oCount[i];minCount=1;}
            else if(minO==oCount[i])minCount++;
            
        }
        System.out.println(minO + " " + minCount);
        
        
        
        
        
    }
    
}
