
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem Virtual Friends
 https://open.kattis.com/problems/virtualfriends
 */
public class VirtualFriends {
    static ArrayList<Integer> size;
    static ArrayList<Integer> position;
    static Map<String,Integer> network;
    public static void main(String[] args)throws Exception {
        //reader for reading input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        //loop through all test cases
        for(int q = 0; q < testCases; q++){
            int iterator = 0;
            //initilize variables
            size = new ArrayList<Integer>();position = new ArrayList<Integer>();network = new HashMap<String, Integer>();
            int relationships = Integer.parseInt(br.readLine());
            //loop through all relationships
            for(int v = 0; v < relationships; v++){
        String[] people = br.readLine().split(" ");
        String person1 = people[0]; String person2 = people[1];
        //add two people to the netword and union their roots
        if(!network.containsKey(person1)){network.put(person1, iterator); position.add(iterator++); size.add(1);}
        if(!network.containsKey(person2)){network.put(person2, iterator); position.add(iterator++); size.add(1);}
        union(person1,person2);
            //print output
            System.out.println(size.get(find(person1)));
            }
            }
    }
    //find's a person
    public static int find(String person){
        int a = network.get(person);
        while (a != position.get(a)) {
            position.set(a, position.get(position.get(a)));
            a = position.get(a);
        }
        return a;
    }
    //union two root nodes
    public static void union(String a, String b) {
        int root1 = find(a);
        int root2 = find(b);
        if (root1 == root2)return;
        if(size.get(root1) < size.get(root2)){size.set(root2, size.get(root2)+size.get(root1)); position.set(root1, root2);}
        else {size.set(root1, size.get(root1)+size.get(root2)); position.set(root2, root1);}
    }
}
