
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem I can Guess That Data Structure
 https://open.kattis.com/problems/guessthedatastructure
 */
public class ICanGuessTheDataStructure {
    static Stack<Integer> s;
    static boolean s1;
    static PriorityQueue<Integer> pq; 
    static boolean pq1;
    static LinkedList<Integer> q;
    static boolean q1;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        
        while((line = br.readLine()) !=null){
            int n = Integer.parseInt(line);
            s = new Stack<Integer>(); s1 = true;
            pq = new PriorityQueue<Integer>(Collections.reverseOrder()); pq1 = true;
            q = new LinkedList<Integer>(); q1 = true;
            //loop through all input
            for(int i = 0; i < n; i++){
                String[] lines=  br.readLine().split(" ");
                int op = Integer.parseInt(lines[0]);
                int num = Integer.parseInt(lines[1]);
                //update based on input
                if(op==1)updateStructures(num);
                else updateBooleans(num);
            }
            System.out.println(getType());
        }
    }
    //gets the winner based on booleans, if there is more than one winner then print not sure
    public static String getType(){
        String output = "impossible";
        int n = 0;
        if(q1)n++;
        if(pq1)n++;
        if(s1)n++;
        if(n==1){
        output = getWinner();
        }
        else if(n>1)output="not sure";
        return output;
    }
    //returns the winner
    public static String getWinner(){
    return (q1) ? "queue" : (pq1) ? "priority queue" : "stack";
    }
    //updates all the data structures with num
    public static void updateStructures(int num){
        s.push(num);
        pq.add(num);
        q.addFirst(num);
    }
    //updates the booleans based on input and the state of the structure
    public static void updateBooleans(int num){
        if(!s.isEmpty()&&s.pop()==num){}
        else {s1=false; }
        if(!pq.isEmpty()&&pq.poll()==num){}
        else {pq1=false;}
        if(!q.isEmpty()&&q.pollLast()==num){}
        else{q1=false;}
    }
}
