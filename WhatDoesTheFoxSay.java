import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class WhatDoesTheFoxSay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testCases; i++) {
            String allSounds = sc.nextLine();
            Map h = new HashMap<String, String>();
            String input = sc.nextLine();
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
            while (sc2.hasNext()) {
                String current = sc2.next();
                if (!h.containsKey(current)) {
                    output += current + " ";
                }
            }
            System.out.println(output.trim());
        }

    }
}