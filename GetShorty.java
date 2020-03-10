import java.util.*;
/*
Solution to Kattis Problem Get Shorty
https://open.kattis.com/problems/getshorty
*/

public class GetShorty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        while(n!=0&&m!=0){
            //build graph, map each location to a set of edges it can reach
            Map<Integer,Set<Edge>> locs = new HashMap<Integer,Set<Edge>>();
            for(int i = 0 ; i < m; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                double l = sc.nextDouble();
                if(!locs.containsKey(a))locs.put(a, new HashSet<Edge>());
                Set<Edge> cur = locs.get(a);
                cur.add(new Edge(b,l));
                if(!locs.containsKey(b))locs.put(b, new HashSet<Edge>());
                cur = locs.get(b);
                cur.add(new Edge(a,l));
            }
            //graph now built
            //set of marked locations
            Set<Integer> marked = new HashSet<Integer>();
            //priorityqueue for dijkstra's algorithm
            PriorityQueue<State> pq = new PriorityQueue<State>();
            //start at location 0, with height 1
            pq.add(new State(0,1));
            //run dijkstra
            while(true){
                State cur = pq.poll();
                if(marked.contains(cur.location))continue;
                marked.add(cur.location);
                //if at ending location
                if(cur.location==n-1){
                    //get output and round it to 4 decimal places
                    String output =((double)Math.round(cur.height * 10000d) / 10000d) + "";
                    while(output.length()-output.indexOf(".") <= 4)output+="0";
                    System.out.println(output);
                    break;
                }
                //go through each edge of current location
                for(Edge w: locs.get(cur.location)){
                    double height = cur.height * w.cost;
                    if(!marked.contains(w.location))pq.add(new State(w.location, height));
                }

            }
            n = sc.nextInt();
            m = sc.nextInt();
        }
    }
    //state for holding current location and current height, implements comparable for priority queue. Larger height has higher priority.
    public static class State implements Comparable{
        int location; 
        double height;
        public State(int location, double height){
            this.location = location;
            this.height = height;
        }
        
        @Override
        public boolean equals(Object o){
            State b = (State)o;
            return this.location==b.location && this.height == b.height;
        }
        @Override
        public int compareTo(Object o){
            State b = (State)o;
            return this.height - b.height > 0 ? -1 : this.height-b.height < 0 ? 1 : 0;
        }
        @Override
        public int hashCode(){
            String e = this.location + "  " + this.height;
            return e.hashCode();
        }
    }
    //holds a location where the edge goes, and the cost of using the edge
    public static class Edge{
        int location;
        double cost;
        public Edge(int location, double cost){
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
