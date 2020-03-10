
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem George
 https://open.kattis.com/problems/george    
 */
public class George {
    public static void main(String[] args) {
        //read input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();
        int end = sc.nextInt();
        int diff =sc.nextInt();
        int numInter = sc.nextInt();
        int[] georgeLoc = new int[numInter];
        for(int i = 0; i <numInter; i++)georgeLoc[i] = sc.nextInt();
        //create a map of intersection locations and read in graph
        Map<Integer,Set<Edge>> locs = new HashMap<Integer,Set<Edge>>();
        for(int i = 0 ; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int l = sc.nextInt();
            if(!locs.containsKey(a))locs.put(a, new HashSet<Edge>());
            Set<Edge> cur = locs.get(a);
            cur.add(new Edge(b,l));
            if(!locs.containsKey(b))locs.put(b, new HashSet<Edge>());
            cur = locs.get(b);
            cur.add(new Edge(a,l));
        }
        //create a map from where goerge was to a timeperiod that he was there
        Map<String, TimePeriod> georgeRoute = new HashMap<String,TimePeriod>();
        int s = 0;
        for(int i = 0; i < numInter-1; i++){
            String e = georgeLoc[i] + " " + georgeLoc[i+1];
            Set<Edge> gg = locs.get(georgeLoc[i]);
            int co = 0;
            for(Edge ii: gg)if(ii.location==georgeLoc[i+1]){co=ii.cost; break;}
            int ou = s+co;
            georgeRoute.put(Math.min(georgeLoc[i], georgeLoc[i+1]) + " " + Math.max(georgeLoc[i], georgeLoc[i+1]),new TimePeriod(s, ou));
            s = ou;
        }
        //set of marked locations
        Set<Integer> marked = new HashSet<Integer>();
        PriorityQueue<State> pq = new PriorityQueue<State>();
        pq.add(new State(start,diff));
        //search for best time
        while(true){
            State cur = pq.poll();
            //System.out.println("at location: " + cur.location + " during time : " +  cur.time );
            if(marked.contains(cur.location))continue;
            marked.add(cur.location);
            //if we have reached the end print output
            if(cur.location==end){System.out.println(cur.time-diff);break;}
            for(Edge w: locs.get(cur.location)){
                int time = cur.time + w.cost;
                String f = Math.min(cur.location, w.location) + " " + Math.max(cur.location, w.location);
                if(georgeRoute.containsKey(f)){
                    TimePeriod dd = georgeRoute.get(f);
                    if(dd.start < cur.time && dd.end > cur.time){time+= (dd.end - (cur.time));}
                }
                if(!marked.contains(w.location))pq.add(new State(w.location, time));
            }   
        }
    }
    //holds the time period george was at an intersection
    public static class TimePeriod{
        int start;
        int end;
        public TimePeriod(int start, int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public boolean equals(Object o){
            TimePeriod b = (TimePeriod)o;
            return this.start==b.start && this.end == b.end;
        }
        @Override
        public int hashCode(){
            String e = this.start + "  " + this.end;
            return e.hashCode();
        }
    }
    //holds a state that george was in
    public static class State implements Comparable{
        int location; 
        int time;
        public State(int location, int time){
            this.location = location;
            this.time = time;
        }
        @Override
        public boolean equals(Object o){
            State b = (State)o;
            return this.location==b.location && this.time == b.time;
        }
        @Override
        public int compareTo(Object o){
            State b = (State)o;
            return this.time - b.time;
        }
        @Override
        public int hashCode(){
            String e = this.location + "  " + this.time;
            return e.hashCode();
        }
    }
    //edge for weighted graph
    public static class Edge{
        int location;
        int cost;
        public Edge(int location, int cost){
            this.location = location;
            this.cost = cost;
        }
        @Override
        public boolean equals(Object o){
            Edge b = (Edge)o;
            return this.location==b.location && this.cost == b.cost;
        }
        @Override
        public int hashCode(){
            String e = this.location + "  " + this.cost;
            return e.hashCode();
        }
        
    }
}
