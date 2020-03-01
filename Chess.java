import java.util.*;
/**
 *
 * @author lucas
 * Solution to kattis problem Chess
 * https://open.kattis.com/problems/chess
 */
public class Chess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        for(int t = 0; t < testCases; t++){
            String[] input = sc.nextLine().split(" ");
            int startC = getColumnIndex(input[0].charAt(0));
            int startR = Integer.parseInt(input[1])-1;
            int endC = getColumnIndex(input[2].charAt(0));
            int endR = Integer.parseInt(input[3])-1;
            //if start and end are on different colors print impossible
            if(((startC%2!=endC%2)&&(startR%2==endR%2))||((startC%2==endC%2)&&(startR%2!=endR%2))){System.out.println("Impossible"); continue;}
            //if start and end are one move away just print out start and end
            if (Math.abs(startC-endC)==Math.abs(startR-endR) && startC!=endC && startR!=endR){System.out.println("1 " + getColumnChar(startC) + " " + (startR+1) + " " + getColumnChar(endC) + " " + (endR+1)); continue;}
            //if we have the same start as finish then print out 0 moves
            if ((startC-endC)==(startR-endR) && startC==endC && startR==endR){System.out.println("0 " + getColumnChar(startC) + " " + (startR+1) ); continue;}
            
            
            //each direction matrix we can move from a starting point
            int[][] dir = {{1,1},{-1,1},{1,-1},{-1,-1}};
            //middle points we will reach
            int midR=0, midC = 0;
            //for each length we can move in each direction
            boolean found = false;
            for(int i = 0; i < 8; i++){
                //for each direction we can move
                for(int j = 0;j < 4; j++){
                    //get current directions
                    int[]a = dir[j];
                    //find new middle points
                    midC = startC+(a[0]*i);
                    midR = startR+(a[1]*i);
                    //if middle points are in the 8x8 matrix
                    if(midC>=0&&midC<8&&midR>=0&&midR<8){
                        //if we are an equal distance and not on the same row or column then we have found the middle point
                        if(Math.abs(midC-endC)==Math.abs(midR-endR) && midC!=endC && midR!=endR){
                            found=true;
                            break;
                        }
                    }
                }
                //if we have found middle point break
                if (found)break;    
            }
            //print output
            System.out.println("2 " + getColumnChar(startC) + " " + (startR+1)+ " " + getColumnChar(midC) + " " + (midR+1) + " " + getColumnChar(endC) + " " + (endR+1));            
            
        }
    }
    //return the index of the chess board based on ascii value
    public static int getColumnIndex(char c){
        return ((int)c)-64 - 1;
    }
    //return the cooresponding char for a given index of the chessboard
    public static char getColumnChar(int i){
        return (char)(i + 1 + 64);
    }
}
