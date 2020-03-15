
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author lucas
 Solution to Kattis Problem Toilet Seat
 https://open.kattis.com/problems/toilet
 */
public class ToiletSeat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String info = sc.nextLine();
        int up = 0;
        int down = 0;
        char OriginalPosition = info.charAt(0);
        char firstPerson = info.charAt(1);
        //arraylist of characters to hold position of people
        ArrayList<Character> people = new ArrayList<Character>();
        people.add(OriginalPosition);
        //calculate the number of flips up and flips down needed
        for (int i = 1; i < info.length(); i++) {
            if (info.charAt(i) == 'U') {
                up++;
            }
            if (info.charAt(i) == 'D') {
                down++;
            }
            people.add(info.charAt(i));
        }
        //calculate and print out number of flips
        if (OriginalPosition == 'U') {
            System.out.println(down * 2);
            if (firstPerson == 'U') {
                System.out.println((up * 2) - 1);
            } else {
                System.out.println((up * 2) + 1);
            }
            int changes = 0;
            //calculate changes
            for (int j = 1; j < people.size(); j++) {
                if (people.get(j) != people.get(j - 1)) {
                    changes++;
                }
            }
            //print number of changes
            System.out.println(changes);

        }
        //same logic as above for original position of down
        if (OriginalPosition == 'D') {
            if (firstPerson == 'U') {
                System.out.println(down * 2 + 1);
            } else {
                System.out.println(down * 2 - 1);
            }
            if (firstPerson == 'U') {
                System.out.println((up * 2));
            } else {
                System.out.println((up * 2));
            }
            int changes = 0;
            for (int j = 1; j < people.size(); j++) {
                if (!Objects.equals(people.get(j), people.get(j - 1))) {
                    changes++;
                }
            }
            System.out.println(changes);
        }
    }
}
