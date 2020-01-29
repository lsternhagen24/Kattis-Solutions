
import java.util.*;

/**
 * @author L-Sternhagen
 */
public class Kastenlauf {
    
    public static class Station{
        int x;
        int y;
        boolean visited;
        
        public Station(int x, int y){
            this.x = x;
            this.y = y;
            visited = false;
        }
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
        
        for(int i = 0; i < testCases; i++){
            int numOfStores = Integer.parseInt(sc.nextLine());
            
            Station[] allStations = new Station[numOfStores+2];
            for(int j = 0; j < numOfStores+2; j++){
                Station cur = new Station(sc.nextInt(), sc.nextInt()); sc.nextLine();
                allStations[j] = cur;
            }
            
            Queue<Station> q = new LinkedList<Station>();
            q.add(allStations[0]);
            
            Station goal = allStations[allStations.length-1];
           
            boolean foundGoal = false;
            
            //bfs
            while(!q.isEmpty()){
                Station cur = q.remove();
                cur.visited = true;
                //if we reached goal print out happy and set foundGoal to true
                if(cur.equals(goal)){System.out.println("happy");foundGoal = true;}
                
                for(int g = 0; g < numOfStores+2; g++){
                    if(allStations[g].visited==false && cur.canReach(allStations[g])){
                        allStations[g].visited = true; q.add(allStations[g]);
                    }
                }
            }
            if(foundGoal==false)
            System.out.println("sad");
        }
        
    }
}
