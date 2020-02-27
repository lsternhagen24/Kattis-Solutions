
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author L-Sternhagen
 Solution to kattis problem Cantina of Babel
 https://open.kattis.com/problems/cantinaofbabel
 */
public class Cantina {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        Person[] people = new Person[num];
        for(int a = 0; a < num; a++){
            String[] line = br.readLine().split(" ");
            String name = line[0];
            Set<String> under = new HashSet<String>();
            
            for(int s = 2; s < line.length; s++)under.add(line[s]);
            people[a] = new Person(name, line[1],under);
        }
        Map<String, Integer> howMany = new HashMap<String, Integer>();
        for(Person i : people)howMany.put(i.name, 1);
        for(int i = 0; i < num; i++){
            for(int k = 0; k < num; k++){
                if(i==k)continue;
                if(bfs(people[i],people[k],people) && bfs(people[k],people[i],people)){
                    howMany.put(people[i].name,howMany.get(people[i].name)+1);
                }
            }
        }
        ArrayList<Integer> n = new ArrayList<Integer>();
        for(String i: howMany.keySet()){
            n.add(howMany.get(i));
        }
     
        System.out.println(n.size()-findMax(n));
    }
    static int findMax(ArrayList<Integer> a){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < a.size(); i++){
            if(max < a.get(i))max = a.get(i);
        }
        return max;
    }
    static int findMin(ArrayList<Integer> a){
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < a.size(); i++){
            if(min > a.get(i))min = a.get(i);
        }
        return min;
    }
    static boolean bfs(Person start, Person end, Person[] all){
        for(Person g: all)g.visited = false;
        Queue<Person> q = new LinkedList<Person>();
        q.add(start); start.visited = true;
        while(!q.isEmpty()){
           Person cur = q.poll();
            if(cur.equals(end))return true;
            for(Person a: all){
                if(cur.canTalk(a) && !a.visited){
                    q.add(a);
                    a.visited = true;
                }
            }
        }
        return false;
    }
    public static class Person{
        String name;
        String speak;
        Set<String> understand;
        boolean visited;
        public Person(String name, String speak, Set<String> understand){
            this.name = name;
            this.speak = speak;
            this.understand = understand;
            visited = false;
        }
        public boolean canTalk(Person a){
            if(a.speak.equals(speak))return true;
            return a.understand.contains(speak);
        }
        @Override
        public boolean equals(Object o){
            Person a = (Person)o;
            return this.name.equals(a.name);
        }
    }
}
