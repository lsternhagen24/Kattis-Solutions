import java.util.LinkedList;
import java.util.Scanner;

/*
 * @author lucas
 Solution to Kattis Problem 2048
 https://open.kattis.com/problems/2048
 */
public class TwentyFortyEight {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[4][4];
        //makes board and inilizes it
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                board[row][column] = sc.nextInt();
            }
            sc.nextLine();
        }
      //update the board based on the next direction and print output
        board = update(board, Integer.parseInt(sc.nextLine()));
        for (int o = 0; o < 4; o++) {
            for (int p = 0; p < 4; p++) {
                System.out.print(board[o][p] + " ");
            }
            System.out.println();
        }
    }
   //rotate or calc the board based on x
    public static int[][] update(int[][] board, int x) {
        for(int i = 0; i < x; i++){
            board = rotate(board);
        }
       for(int j = 0; j < 4; j++){
           board[j] = calc(board[j]);
       }
       for(int r = 0; r < 4-x; r++){
           board = rotate(board);
       }
        return board;
    }
//rotates the board
    public static int[][] rotate(int[][] board) {
        int[][] newBoard = new int[4][4];
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                int newR = 3 - column;
                int newC = row;
                newBoard[newR][newC] = board[row][column];
            }

        }
        return newBoard;
    }
   //calcs the board
    public static int[] calc(int[] nu) {
        int i = 0;
        LinkedList<Integer> myList = new LinkedList<Integer>();
        myList.push(nu[i]);
        i++;
        while (i < nu.length) {
            if (canCombine(nu[i], myList.peek())) {
                myList.pop();
                myList.push(nu[i] * 2);
                i++;
                if (i < nu.length) {
                    myList.push(nu[i]);
                    i++;
                }
            } else if (myList.peek() == 0) {
                myList.pop();
                myList.push(nu[i]);
                i++;
            } else if (nu[i] == 0) {
                i++;
            } else {
                myList.push(nu[i]);
                i++;
            }
        }
        for (int b = 0; b < 4; b++) {
            nu[b] = (myList.isEmpty()) ? 0 : myList.pollLast();
        }
        return nu;
    }
//reverse a integer array
    public static int[] reverse(int[] x) {
        int[] y = new int[x.length];
        int q = 0;
        for (int w = x.length - 1; w >= 0; w--) {
            y[q] = x[w];
            q++;
        }
        return y;
    }
//returns true if two int's can combine
    public static boolean canCombine(int a, int b) {
        return (a + b == a * 2 && a != 0 && b != 0) ? true : false;
    }
}
