
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author lucas
 Solution to Kattis Problem Phone List
 https://open.kattis.com/problems/phonelist
 */
public class PhoneList {

    public static void main(String[] args) throws Exception {
        //reader for reading input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        //loop through each testcase
        for (int i = 0; i < testCases; i++) {
            String output = "YES";
            int min = 11;
            int next = Integer.parseInt(br.readLine());
            //set to contain all phone numbers we have previously seen
            Set<String> mySet = new HashSet<String>();
            //array for holding all current strings
            myString[] al = new myString[next];
            for (int a = 0; a < next; a++) {
                String line = br.readLine();
                //find the minimum line length
                if (min > line.length()) {
                    min = line.length();
                }
                //read in new phone number
                al[a] = new myString(line);
            }
            //sort phone numbers
            Arrays.sort(al, Collections.reverseOrder());
            //loop through every phone number
            for (int v = 0; v < al.length; v++) {
                String current = al[v].input;
                //if we already have seen the phone number return NO 
                if (mySet.contains(current)) {
                    output = "NO";
                }
                //add the phone number and all possibilites that are at least as long as the minimum length
                mySet.add(current);
                for (int a = current.length(); a >= min; a--) {
                    mySet.add(current.substring(0, a));
                }
            }
            //print output
            System.out.println(output);
        }
    }
    //custom string for sorting based on length instead of usual string comparison
    public static class myString implements Comparable<myString>, Comparator<myString> {

        String input;

        public myString(String input) {
            this.input = input;
        }

        @Override
        public int compare(myString a, myString b) {
            return a.input.length() > b.input.length() ? 1 : a.input.length() > b.input.length() ? -1 : 0;
        }

        @Override
        public int compareTo(myString h) {
            return (this.input.length() > h.input.length()) ? 1 : (this.input.length() < h.input.length()) ? -1 : 0;
        }
    }
}
