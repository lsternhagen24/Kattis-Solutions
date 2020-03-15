import java.util.Scanner;

/**
 * @author lucas
 Solution to Kattis Problem Sort of Sorting
 https://open.kattis.com/problems/sortofsorting
 */
public class SortOfSorting {
    public static void main(String[] args) {
        //scanner for reading input
        Scanner sc = new Scanner(System.in);
        int numOfTests = Integer.parseInt(sc.nextLine());
        //loop through all test cases
        while (numOfTests != 0) {
            //array to hold all names
            String[] names = new String[numOfTests];
            for (int i = 0; i < numOfTests; i++) {
                //sort in the next name
                names = sortIn(names, sc.nextLine());
            }
            //print output after sorting
            for (int i = 0; i < names.length; i++) {
                System.out.println(names[i]);
            }
            System.out.println();
            //read next line
            numOfTests = Integer.parseInt(sc.nextLine());
        }
    }

    public static String[] sortIn(String[] names, String newName) {
        int x = 0;
        //bubble sort newname into names array
        while (names[x] != null && names[x].charAt(0) <= newName.charAt(0)) {
            if (names[x].charAt(0) == newName.charAt(0)) {
                if (names[x].charAt(1) < newName.charAt(1)) {
                    x++;
                    continue;
                } else if (names[x].charAt(1) > newName.charAt(1)) {
                    break;
                } else {
                    x++;
                    continue;
                }
            }
            x++;
        }
        //move all names over
        if (names[x] != null) {
            for (int i = names.length - 1; i > x; i--) {
                names[i] = names[i - 1];
            }
        }
        //insert newname into the correct location
        names[x] = newName;
        //return names which is still sorted
        return names;
    }
}
