import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author lucas
 Solution to Kattis Problem What Does The Fox Say
 https://open.kattis.com/problems/whatdoesthefoxsay
 */
public class WhatDoesTheFoxSay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //scanner for reading input
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        //loop through all test cases
        for (int i = 0; i < testCases; i++) {
            //read all the sounds
            String allSounds = sc.nextLine();
            Map h = new HashMap<String, String>();
            String input = sc.nextLine();
            //map each animal to the sound they make
            while (!input.equals("what does the fox say?")) {
                Scanner sc1 = new Scanner(input);
                String animal = sc1.next();
                sc1.next();
                String key = sc1.next();
                h.put(key, animal);
                input = sc.nextLine();
            }
            Scanner sc2 = new Scanner(allSounds);
            String output = "";
            //loop through input and if the sound didn't come from an animal we have heard it add it to output
            while (sc2.hasNext()) {
                String current = sc2.next();
                if (!h.containsKey(current)) {
                    output += current + " ";
                }
            }
            //print output
            System.out.println(output.trim());
        }
    }
}
