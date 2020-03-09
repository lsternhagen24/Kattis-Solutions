
import java.util.Scanner;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem Flow Shop
 https://open.kattis.com/problems/flowshop
 */
public class FlowShop {
    public static void main(String[] args) {
        //scanner to read input
        Scanner sc = new Scanner(System.in);
        int swath = sc.nextInt();
        int stages = sc.nextInt();
        sc.nextLine();
        //hold dp finish times
        int[][] finishTimes = new int[swath][stages];
        //hold input
        int[][] inputGrid = new int[swath][stages];
        //read input into grid
        for(int i = 0; i < swath; i++){
            for(int j = 0; j < stages; j++){
                inputGrid[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        //finished reading input
        
        //fill in first column
        finishTimes[0][0]=inputGrid[0][0];
        for(int i = 1; i < swath; i++){
            finishTimes[i][0] = finishTimes[i-1][0] + inputGrid[i][0];
        }
        //fill in first row
        for(int i = 1; i < stages; i++){
            finishTimes[0][i]=finishTimes[0][i-1]+inputGrid[0][i];
        }
        //fill in dp table
        for(int i = 1; i < stages; i++){
            for(int j = 1; j < swath; j++){
                int extraWaitTime = (finishTimes[j][i-1] < finishTimes[j-1][i]) ? finishTimes[j-1][i] - finishTimes[j][i-1] : 0;
                finishTimes[j][i] = finishTimes[j][i-1] + inputGrid[j][i] + extraWaitTime;
            }
        }
        String output = "";
        //find final output and concat string
        for(int i = 0; i < swath; i++)output+= finishTimes[i][stages-1] + " ";
        //print output
        System.out.println(output.trim());

       /* uncomment for testing
        for(int a = 0; a < swath; a++){
            for(int b = 0; b < stages; b++){
                System.out.print(finishTimes[a][b] + " ");
            }
            System.out.println("");
        }
        */
    }
}
