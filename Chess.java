
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author lucas
 */
public class Chess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<Character, Integer> row = new HashMap<Character, Integer>();
        Map<Character, Integer> column = new HashMap<Character, Integer>();

        row.put('8', 0);
        row.put('7', 1);
        row.put('6', 2);
        row.put('5', 3);
        row.put('4', 4);
        row.put('3', 5);
        row.put('2', 6);
        row.put('1', 7);
        column.put('A', 0);
        column.put('B', 1);
        column.put('C', 2);
        column.put('D', 3);
        column.put('E', 4);
        column.put('F', 5);
        column.put('G', 6);
        column.put('H', 7);

        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testCases; i++) {
            String output = "";
            String ca = sc.next();
            String ra = sc.next();
            String cb = sc.next();
            String rb = sc.next();
            if (ca.equals(cb) && ra.equals(rb)) {
                System.out.println("0 " + ca + " " + ra);
                continue;
            }
            int c1 = column.get(ca.charAt(0));
            int r1 = row.get(ra.charAt(0));
            int c2 = column.get(cb.charAt(0));
            int r2 = row.get(rb.charAt(0));
            if (isSameColor(r1, c1, r2, c2) == false) {
                System.out.println("Impossible");
                continue;
            }
            int[][] board = new int[8][8];
            int count = 2;
            for (int g = 0; g < 8; g++) {
                for (int j = 0; j < 8; j++) {
                    board[g][j] = count;
                    count++;
                }
            }
            board[r1][c1] = 1;
            board[r2][c2] = 1;
            Set<Integer> set1 = new HashSet<Integer>();
            Set<Integer> set2 = new HashSet<Integer>();
            int iterator = 1;
            while (r1 + iterator < 8 && c1 + iterator < 8) {
                set1.add(board[r1 + iterator][c1 + iterator]);
                iterator++;
            }
            iterator = 1;
            while (r2 + iterator < 8 && c2 + iterator < 8) {
                set2.add(board[r2 + iterator][c2 + iterator]);
                iterator++;
            }
            iterator = 1;
            while (r1 - iterator >= 0 && c1 - iterator >= 0) {
                set1.add(board[r1 - iterator][c1 - iterator]); 
                iterator++;
            }
            iterator = 1;
            while (r2 - iterator >= 0 && c2 - iterator >= 0) {
                set2.add(board[r2 - iterator][c2 - iterator]);
                iterator++;
            }
            iterator = 1;
            while (r1 + iterator < 8 && c1 - iterator >= 0) {
                set1.add(board[r1 + iterator][c1 - iterator]);
                iterator++;
            }
            iterator = 1;
            while (r2 + iterator < 8 && c2 - iterator >= 0) {
                set2.add(board[r2 + iterator][c2 - iterator]);
                iterator++;
            }
            iterator = 1;
            while (r1 - iterator >= 0 && c1 + iterator < 8) {
                set1.add(board[r1 - iterator][c1 + iterator]);
                iterator++;
            }
            iterator = 1;
            while (r2 - iterator >= 0 && c2 + iterator < 8) {
                set2.add(board[r2 - iterator][c2 + iterator]);
                iterator++;
            }
            int key = -1;
            for (int s : set1) {
                if (set2.contains(s)) {
                    key = s;
                }
            }
            if (set1.contains(1)) {
                output += "1 " + ca + " " + ra;

            } else {
                output += "2 " + ca + " " + ra + " ";
            
            for (int w = 0; w < 8; w++) {
                for (int u = 0; u < 8; u++) {
                    if (board[w][u] == key) {
                        for (Character c : column.keySet()) {
                            if (column.get(c) == u) {
                                output += "" + c;
                            }
                        }
                        for (Character c : row.keySet()) {
                            if (row.get(c) == w) {
                                output += " " + c;
                            }
                        }

                    }
                }
            }}
            output += " " + cb + " " + rb;
            System.out.println(output);
        }
    }

    public static boolean isSameColor(int r1, int c1, int r2, int c2) {
        if (isEven(r1) == isEven(c1)) {
            if (isEven(r2) == isEven(c2)) {
                return true;
            }
        }
        if (isEven(r1) != isEven(c1)) {
            if (isEven(r2) != isEven(c2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEven(int x) {
        if (((double) (x)) % 2.0 == 0) {
            return true;
        }
        return false;
    }

}
