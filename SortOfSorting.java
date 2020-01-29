import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class SortOfSorting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfTests = Integer.parseInt(sc.nextLine());
        while (numOfTests != 0) {
            String[] names = new String[numOfTests];
            for (int i = 0; i < numOfTests; i++) {
                names = sortIn(names, sc.nextLine());
            }
            for (int i = 0; i < names.length; i++) {
                System.out.println(names[i]);
            }
            System.out.println();
            numOfTests = Integer.parseInt(sc.nextLine());
        }

    }

    public static String[] sortIn(String[] names, String newName) {
        int x = 0;
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
        if (names[x] != null) {
            for (int i = names.length - 1; i > x; i--) {
                names[i] = names[i - 1];
            }
        }
        names[x] = newName;
        return names;
    }
}
