
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lucas
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

    public static class Person implements Comparable<Person> {
        int[] rank = new int[10];
        String name;
        
        public Person(String[] line){
            this.name = line[0];
            String[] r = line[1].trim().split(" ")[0].split("-");
            int i = 0;
            while(i<r.length){
                int rI = r.length-1-i;
                rank[i++] = r[rI].equals("upper") ? (3) : (r[rI].equals("middle") ? 2 : 1);
            }
            while(i < 10) rank[i++] = 2;
        }

        @Override
        public int compareTo(Person t) {
            int i = 0;
            while(i < 9 && rank[i] == t.rank[i]) i++;
            if(rank[i] == t.rank[i]) return -name.compareTo(t.name);
            return rank[i] - t.rank[i];
        }
    }
}
