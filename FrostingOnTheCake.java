import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Solution to Kattis Problem Frosting on the Cake
https://open.kattis.com/problems/frosting
*/

public class FrostingOnTheCake {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //hold combined width for first, second and third colors order
        long[] s = new long[3];
        String[] ww = br.readLine().split(" ");
        int iter = 0;
        //read in all widths
        for(int q = 0; q < n; q++){s[iter++]+=Long.parseLong(ww[q]);if(iter==3)iter=0;}
        String[] col = br.readLine().split(" ");
        
        long[]sums  = new long[3];
        //iterate through lengths
        for(int q = 0; q < n; q++){
            long len = Long.parseLong(col[q]);
            int first = (q+2)%3;
            int second = first+1 ==3 ? 0: first+1;
            int third = second+1 == 3 ? 0 :second+1;
            sums[first]+=s[0]*len;
            sums[second]+=s[1]*len;
            sums[third]+=s[2]*len;
        }
        System.out.println(sums[0] + " " + sums[1] + " " + sums[2]);
    }
}
