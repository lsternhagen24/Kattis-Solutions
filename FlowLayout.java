
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author L-Sternhagen
 */
public class FlowLayout {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    static int[][] grid;
    static int n;
    static int MAX_WIDTH_OF_GRID = 80;
    static int MAX_HEIGHT_OF_GRID = 1500;
    static Map<Integer,Integer> rowEnd;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        while(n!=0){
            int cwidth ;
            int cheight;
            grid = new int[MAX_HEIGHT_OF_GRID][MAX_WIDTH_OF_GRID];
            rowEnd = new HashMap<Integer,Integer>();
            for(int ww = 0; ww < MAX_HEIGHT_OF_GRID; ww++)Arrays.fill(grid[ww], 0);
            ArrayList<Integer> heights_to_check = new ArrayList<Integer>();
            heights_to_check.add(0);
            rowEnd.put(0,0);
            while(true){
                cwidth = sc.nextInt();
                cheight = sc.nextInt();
                if(cwidth==-1||cheight==-1)break;
                boolean foundrow = false;
                Integer h = heights_to_check.get(heights_to_check.size()-1);
                for(int e = 0; e < n; e++){
                    if(rectangle_does_fit(h,e,cwidth,cheight)){
                        foundrow = true;
                        addRect(h,e,cwidth,cheight);
                        if(rowEnd.get(h) < cheight)rowEnd.put(h,cheight);
                        break;
                    }
                }
                if(!foundrow){
                    int maxSum = -1; 
                    for(Integer w: rowEnd.keySet()){
                        if(w+rowEnd.get(w) > maxSum){maxSum = w+rowEnd.get(w);}
                    }
                    int newStart = maxSum;
                    addRect(newStart,0, cwidth, cheight);
                    heights_to_check.add(newStart);
                    rowEnd.put(newStart, cheight);
                }
            }
            //start at bottom row and work up to find lowest row
            int maxHeight = -1;
            for(int le = MAX_HEIGHT_OF_GRID-1; le >=0; le--){
                for(int f = 0; f < n; f++){
                    if(grid[le][f]==1){maxHeight = le;break;}
                }
                if(maxHeight!=-1)break;
            }
            int maxWidth = -1;
            //start at right most column and work left to find last column
            for(int re = n-1; re >=0; re--){
                for(int w = 0; w < MAX_HEIGHT_OF_GRID; w++){
                    if(grid[w][re]==1){maxWidth=re; break;}
                }
                if(maxWidth!=-1)break;
            }
            //printGrid(maxHeight, maxWidth);
            System.out.println((maxWidth+1) + " x " + (maxHeight+1)); 
            n = sc.nextInt();
        }
        
        
        
    }
    public static void printGrid(int mx1, int mx2){
        for (int x = 0; x <= mx1; x++) {
            for (int y = 0; y <= mx2; y++) {
                if(grid[x][y]==1)System.out.print(ANSI_RED);
                System.out.print(grid[x][y] + " ");
                if(grid[x][y]==1)System.out.print(ANSI_RESET);
            }
            System.out.println("");
        }
    }
    
    public static void addRect(int rowStart, int columnStart, int width, int height){
        for(int x = rowStart; x < rowStart+height; x++){
            for(int y = columnStart; y < columnStart+width; y++){
                grid[x][y] = 1;
            }
        }
    }
    
    public static boolean rectangle_does_fit(int rowStart, int columnStart, int width, int height){
        if((columnStart+width)>n){return false;}
        for(int row = rowStart; row < rowStart+height; row++){
            for(int column = columnStart; column < columnStart+width; column++){
                if(grid[row][column]==1){return false;}
            }
        }
       //System.out.println("found room for: width, " + width + " height, " + height + " at, " + rowStart + " , " + columnStart);
        return true;
    }
}
