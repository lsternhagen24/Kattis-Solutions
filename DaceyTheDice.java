/**
 * @author L-Sternhagen
 Solution to Kattis problem Dacey the Dice
 https://open.kattis.com/problems/daceydice
 */
import java.util.*;
public class DaceyTheDice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //read the number of testcases
        int testCases = sc.nextInt(); sc.nextLine();
        for(int zz = 0; zz < testCases; zz++){
            int n = sc.nextInt(); sc.nextLine();
            int startR=0, startY = 0;
            //initialize grid
            char[][] grid = new char[n][n];
            //loop through grid
            for(int r = 0; r < n; r++){
                String line = sc.nextLine();
                for(int c = 0; c < line.length(); c++){
                    //populate grid
                    grid[r][c] = line.charAt(c);
                    if(grid[r][c]=='S'){startR = r; startY=c;}
                }
            }
            
            //do search
           
        //keep marked locations
        Set<State> marked = new HashSet<State>();
        State startState = new State(startR, startY ,"1 2 3");
       
        //add first location
        Queue<State> a = new LinkedList<State>(); 
        a.add(startState);
        boolean found = false;
        while(!a.isEmpty()){
            //parse out data from string
            State cur = a.poll();

            if(grid[cur.curR][cur.curC]=='H' && cur.posTop==2){found = true; break;}

            //if in trap continue
            if(grid[cur.curR][cur.curC]=='*'){continue;}
           
            String pos = cur.posTop + " " + cur.posRight + " " + cur.posBack;
            
            //roll all four directions
            State g = new State(cur.curR+1,cur.curC,rollBackward(pos));
            if(cur.curR < n-1 && !marked.contains(g)){a.add(g);marked.add(g);}
            g = new State(cur.curR-1,cur.curC,rollForward(pos));
            if(cur.curR >0 && !marked.contains(g)){a.add(g);marked.add(g);}
            g = new State(cur.curR,cur.curC+1,rollRight(pos));
            if(cur.curC < n-1 && !marked.contains(g)){a.add(g);marked.add(g);}
            g = new State(cur.curR,cur.curC-1,rollLeft(pos));
            if(cur.curC > 0 && !marked.contains(g)){a.add(g);marked.add(g);}
        }
        
        //output
            if(found)System.out.println("Yes");
            else System.out.println("No");
        
        }
        
    }
    public static class State {
        int curR;
        int curC;
        int posTop;
        int posBack;
        int posRight;
        
        //Holds the state of the dice
        public State(int curR, int curC, String pos){
            
            this.curR = curR;
            this.curC = curC;
            String[] in = pos.split(" ");
            this.posTop = Integer.parseInt(in[0]);
            this.posRight = Integer.parseInt(in[1]);
            this.posBack = Integer.parseInt(in[2]);
        }
        //override hashcode so we can add to set
        @Override
        public int hashCode(){
            String a = curR + ","+curC + "," + posTop + "," + posRight + "," + posBack;
            return a.hashCode();
        }
        //override equals for comparison
        @Override
        public boolean equals(Object o){
            State a = (State)o;
            if(this.curR==a.curR&&this.curC==a.curC&&this.posTop==a.posTop&&this.posBack==a.posBack&&this.posRight==a.posRight)return true;
            else return false;
        }
    }
    //generate new state from rolling dice right
    public static String rollRight(String pos){
        String[] in = pos.split(" ");
        int top = Integer.parseInt(in[0]);
        int right = Integer.parseInt(in[1]);
        int back = Integer.parseInt(in[2]);

        int newTop, newRight, newBack = 0;
        newRight = top;
        newBack = back;
        newTop =7-right;

    return newTop + " " + newRight + " " + newBack;
    }
   //generate new state from rolling dice left
    public static String rollLeft(String pos){
        
        String[] in = pos.split(" ");
        int top = Integer.parseInt(in[0]);
        int right = Integer.parseInt(in[1]);
        int back = Integer.parseInt(in[2]);
        
        int newTop, newRight, newBack = 0;
        newRight = 7-top;
        newBack = back;
        newTop = right;
          
    return newTop + " " + newRight + " " + newBack;
    }
   //generate new state from rolling dice forward
    public static String rollForward(String pos){
        
        String[] in = pos.split(" ");
        int top = Integer.parseInt(in[0]);
        int right = Integer.parseInt(in[1]);
        int back = Integer.parseInt(in[2]);
        int newTop, newRight, newBack = 0;
        newRight = right;
        newBack = 7-top;
        newTop = back;

    return newTop + " " + newRight + " " + newBack;
    }
   //generate new state from rolling dice backward
    public static String rollBackward(String pos){
        
        String[] in = pos.split(" ");
        int top = Integer.parseInt(in[0]);
        int right = Integer.parseInt(in[1]);
        int back = Integer.parseInt(in[2]);
        int newTop, newRight, newBack = 0;
        newRight = right;
        newBack = top;
        newTop = 7-back;
        
    return newTop + " " + newRight + " " + newBack;
    }
}
