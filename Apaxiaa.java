
import java.util.Scanner;
/*
Kattis Solution to Apaxiaa
https://open.kattis.com/problems/apaxiaaans
*/

public class Apaxiaa {

    public static void main(String[] args) {
        //read input
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        //loop through every character and replace all consecutive characters with one character
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                int a = i + 1;
                //find last consecutive same character
                while (a < input.length() && input.charAt(a) == input.charAt(i)) a++;
                //remove all of that character except for one
                input = input.substring(0,i) + input.substring(a-1);
            }
        }
        //print output
        System.out.println(input);
    }
}
