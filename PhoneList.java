
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lucas
 */
public class PhoneList {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCases; i++) {
            String output = "YES";
            int min = 11;
            int next = Integer.parseInt(br.readLine());
            Set<String> mySet = new HashSet<String>();
            myString[] al = new myString[next];
            for (int a = 0; a < next; a++) {
                String line = br.readLine();
                if (min > line.length()) {
                    min = line.length();
                }
                al[a] = new myString(line);
            }
            Arrays.sort(al, Collections.reverseOrder());
            for (int v = 0; v < al.length; v++) {
                String current = al[v].input;
                if (mySet.contains(current)) {
                    output = "NO";
                }
                mySet.add(current);
                for (int a = current.length(); a >= min; a--) {
                    mySet.add(current.substring(0, a));
                }
            }
            System.out.println(output);
        }
    }

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
