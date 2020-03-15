
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
Solution to Kattis Problem Torn 2 Pieces
https://open.kattis.com/problems/torn2pieces
*/

public class TornToPieces {
       //map for holding each station name to a station
       static Map<String,Station> allStations = new HashMap<String,Station>();
       static String output = "";

    public static void main(String[] args) {
        //scanner for reading input
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        String line = "";
        //loop through all nums
        for(int i = 0; i < num; i++){
           //initialize destinations and names
           line = sc.nextLine();/**/Scanner sc2 = new Scanner(line);/**/Set<String> destinations = new HashSet<String>();/**/String name = sc2.next();
           while(sc2.hasNext())destinations.add(sc2.next()); 
           allStations.put(name, new Station(name, destinations));
           for(String cur: destinations){
               if(allStations.containsKey(cur)){
                   allStations.get(cur).children.add(name);
               }
               else{
                   allStations.put(cur, new Station(cur, new HashSet<String>(Arrays.asList(name))));
               }
           }
        }
        //find solutions
        String[] finalLine = sc.nextLine().trim().split(" ");
        if(dfs(finalLine[0],finalLine[1])){
        String[] answers = output.split(" ");
        System.out.print(finalLine[0] +  " ");
        for(int i = answers.length-1; i >=0; i--){
            System.out.print(answers[i] + " ");
        }
        }
        else{
            System.out.println("no route found");
        }
    }
    //bfs from one string until we reach a key if possible
    static boolean dfs(String a, String key) {
        if (a.equals(key)) {
            return true; //if goal, return found
        }
        Station ts = allStations.get(a);
        if (ts ==null || ts.visited) {
            return false; //if already visited, quit
        }
        ts.visited = true; //mark as visited
        for(String child: allStations.get(a).children){
            if(dfs(child, key)) {
                output += child + " ";
                return true;
            }
        }
        return false; //if searched everything, quit
        
    }
//station class, has a name, if we have visited it, and the a set of children we can reach
   static class Station {

        String name;
        boolean visited;
        Set<String> children;

        public Station(String name, Set<String> childs) {
            this.name = name;
            visited = false;
            this.children = childs;
        }

        @Override
        public boolean equals(Object a) {
            Station b = (Station)a;
            return this.name.equals(b.name);
        }
    }
}
