
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem Flip Five
 https://open.kattis.com/problems/flipfive
 */
public class FlipFive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        
        for(int i = 0; i < n; i++){
            //read in current board
            String board = "";
            for(int j = 0; j < 3; j++){
                board += sc.nextLine();
            }
            //initialize queue for bfs
            Queue<State> q = new LinkedList<State>();
            //set to make sure we dont check state more than once
            Set<String> statesVisited = new HashSet<String>();
            
            //if board is already complete continue
            if(board.equals(".........")){System.out.println("0");continue;}
            //add first states into queue and set
            for(int r = 0; r < 9; r++){
                String w = updateState(r,board);
                statesVisited.add(w);
                q.add(new State(w,1));
            } 
            //run bfs on states
            while(!q.isEmpty()){
                //get current state
                State cur = q.poll();
                //if at end break and print flips
                if(cur.b.equals(".........")){System.out.println(cur.flips);break;}
                //else add all new flips
                for(int r = 0; r < 9; r++){
                    String w = updateState(r,cur.b);
                    //if new state hasnt been visited yet add to queue
                    if(!statesVisited.contains(w)){q.add(new State(w,cur.flips+1));statesVisited.add(w);}
                }
            }
        }
    }
    //hold state and number of flips done
    public static class State{
        String b; 
        int flips;
        
        public State(String b, int flips){
            this.b = b;
            this.flips = flips;
        }
    }
    
    //flip boards based on position
    public static String updateState(int i, String currentState){
        switch(i){
            case 0: return flip(new int[]{0,1,3,-1,-1}, currentState);
            case 1: return flip(new int[]{0,1,2,4,-1}, currentState);
            case 2: return flip(new int[]{1,2,5,-1,-1}, currentState);
            case 3: return flip(new int[]{0,3,4,6,-1}, currentState);
            case 4: return flip(new int[]{1,3,4,5,7}, currentState);
            case 5: return flip(new int[]{2,4,5,8,-1}, currentState);
            case 6: return flip(new int[]{3,6,7,-1,-1}, currentState);
            case 7: return flip(new int[]{4,6,7,8,-1}, currentState);
            case 8: return flip(new int[]{5,7,8,-1,-1}, currentState);
            default: return ""; 
        }
        
    
    }
    //update board based on flip array
    public static String flip(int[] a, String input){
        for(int i = 0; i < 5; i++){
            if(a[i]>-1){
                input = input.charAt(a[i])=='*' ? input.substring(0,a[i]) + "." + input.substring(a[i]+1): input.substring(0,a[i]) + "*" + input.substring(a[i]+1);
            }
        }
        return input;
    }
}
