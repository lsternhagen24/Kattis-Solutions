/**
 * @author L-Sternhagen
 Solution to kattis problem Cantina of Babel
 https://open.kattis.com/problems/cantinaofbabel
 */
import java.util.*;
public class CantinaOfBabel {
    public static void main(String[] args) {
        //read input
        Scanner sc = new Scanner(System.in);
        int numOfPeople = Integer.parseInt(sc.nextLine());
        Person[] people = new Person[numOfPeople];
        for (int i = 0; i < numOfPeople; i++)people[i] = new Person(sc.nextLine().split(" "));
        //int[] holds which group each person is in
        int[] groups = new int[numOfPeople];
        //initialize each person to their own group
        for (int i = 0; i < numOfPeople; i++)groups[i] = i;
        //loop through each pair of people and bfs to eachother
        for (int i = 0; i < numOfPeople; i++){
            for (int j =0; j < numOfPeople; j++){
                if(i==j)continue;
                //if we can bfs each way, the two people can converse
                if(bfs(i, j, people) && bfs(j,i,people)){
                    //find which group i is in.
                    int groupa = groups[i];
                    //initialize everyone in the group of i to now be in the group of j
                    for(int t = 0; t< numOfPeople; t++){
                        if(groups[t]==groupa)groups[t] = groups[j];
                    }
                }
            }
        }
        //find the count of how many people are in each group
        int[] countGroups = new int[numOfPeople];
        for(int i = 0 ; i < groups.length; i++)countGroups[groups[i]]++;
        //find the maximum group size
        int max = -1;
        for(int i = 0; i < countGroups.length; i++){
            if(max < countGroups[i])max = countGroups[i];
        }
        //print out how many people are not in the largest group
        System.out.println(numOfPeople-max);
        
        
    }
    //breadth first search from one person to another person in array P
    public static boolean bfs(int start, int end, Person[] p){
        //array to hold people we have already been to
        int[] marked = new int[p.length];
        //queue for bfs
        Queue<Integer> q = new LinkedList<Integer>();
        //add and mark start to the queue
        q.add(start);
        marked[start] = 1;
        //loop while we have more people to visit
        while(!q.isEmpty()){
            int cur = q.poll();
            //if we reached end person quit
            if(cur == end)return true;
            for (int i = 0; i < p.length; i++){
                if(i==cur)continue;
                Person current_person = p[i];
                //if we haven't visited the person and they can converse then add new person to queue
                if(marked[i]==0 && current_person.understands.contains(p[cur].speak)){
                    marked[i] = 1;
                    q.add((i));
                }
            }
        }
        //two people cannot converse
        return false;        
    }
    //class to hold which person, the language they speak, and all other languages they understand
    public static class Person {
        String speak;
        Set<String> understands;
        //initialize person
        public Person(String[] u){
            this.speak = u[1];
            Set<String> a = new HashSet<String>();
            for (int i = 1; i < u.length; i++)a.add(u[i]);
            this.understands = a;
        }
    }
}

