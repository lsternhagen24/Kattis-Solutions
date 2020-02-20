
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author lucas
 Solution to kattis problem A Classy Problem
 https://open.kattis.com/problems/classy
 */
public class AClassyProblem {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for (int w = 0; w < testCases; w++) {
            int numOfNames = Integer.parseInt(br.readLine());
            Person[] names = new Person[numOfNames];
            for(int i = 0; i < numOfNames; i++){
                names[i] = new Person(br.readLine().split(":"));
            }
            Arrays.sort(names, Collections.reverseOrder());
            for(Person p : names) System.out.println(p.name);
            System.out.println("==============================");
        }

    }
//class Person, each person has a rank and name
    public static class Person implements Comparable<Person> {
        //array of integers that holds rank. Each rand can be 10 long. Upper=3, Middle=2, Lower=1
        int[] rank = new int[10];
        //name for tie-breakers
        String name;
        //constructor for creating a person. 
        public Person(String[] line){
            //sets the name from line
            this.name = line[0];
            //reads the rank from input line
            String[] r = line[1].trim().split(" ")[0].split("-");
            int i = 0;
            //initializes the rank array from input
            while(i<r.length){
                //read in reverse since rank is right to left
                int rI = r.length-1-i;
                rank[i++] = r[rI].equals("upper") ? (3) : (r[rI].equals("middle") ? 2 : 1);
            }
            //all classes not inilialized are middle
            while(i < 10) rank[i++] = 2;
        }
        //compare two Persons. 
        @Override
        public int compareTo(Person t) {
            int i = 0;
            //find first difference in rank array
            while(i < 9 && rank[i] == t.rank[i]) i++;
            //if they are the same rank return alphabetical comparison
            if(rank[i] == t.rank[i]) return -name.compareTo(t.name);
            //else return the integer difference
            return rank[i] - t.rank[i];
        }
    }
}
