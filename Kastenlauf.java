
import java.util.*;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem Katsenlauf
 */
public class Kastenlauf {
    //each station has an x and y coordinate as well as a boolean visited
    public static class Station{
        int x;
        int y;
        boolean visited;
        //constructor, initialize to not have visited before
        public Station(int x, int y){
            this.x = x;
            this.y = y;
            visited = false;
        }
        //can two stations reach eachother
        public boolean canReach(Station a){
          return (Math.abs(this.x-a.x) + Math.abs(this.y - a.y)) <= 1000;
        }
        @Override
        public boolean equals(Object o){
            Station s = (Station)o;
            return (s.x==this.x && s.y==this.y);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        //loop through all test cases
        for(int i = 0; i < testCases; i++){
            int numOfStores = Integer.parseInt(sc.nextLine());
            //read in all stations and their attributes (x, y coordinates)
            Station[] allStations = new Station[numOfStores+2];
            for(int j = 0; j < numOfStores+2; j++){
                Station cur = new Station(sc.nextInt(), sc.nextInt()); sc.nextLine();
                allStations[j] = cur;
            }
            //create a q for bfs, and add start location
            Queue<Station> q = new LinkedList<Station>();
            q.add(allStations[0]);
            //set the goal station we are trying to reach
            Station goal = allStations[allStations.length-1];
           //have we found the goal yet
            boolean foundGoal = false;
            
            //bfs
            while(!q.isEmpty()){
                Station cur = q.remove();
                cur.visited = true;
                //if we reached goal print out happy and set foundGoal to true
                if(cur.equals(goal)){System.out.println("happy");foundGoal = true;}
                //loop through all stores, if we haven't visited and we can reach the next station add it to the queue
                for(int g = 0; g < numOfStores+2; g++){
                    if(allStations[g].visited==false && cur.canReach(allStations[g])){
                        allStations[g].visited = true; q.add(allStations[g]);
                    }
                }
            }
            //if we haven't found our goal print sad
            if(foundGoal==false){System.out.println("sad");}
            else{System.out.Println("happy");}
        }
    }
}
