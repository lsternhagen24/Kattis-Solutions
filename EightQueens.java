import java.util.Scanner;

public class EightQueens {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] board = new String[8];
        for (int i = 0; i < 8; i++) {
        board[i] = sc.nextLine();
        }
        EightQueens answer = new EightQueens(board);
        if(answer.doesPass()){
            System.out.println("valid");
        }
        else{
            System.out.println("invalid");
        }
    }
    public static class EightQueens {

    int[][] chessBoard = new int[8][8];

    public EightQueens(String[] a) {
        int count = 0;
        for(String s : a){
            for(int k = 0; k < s.length(); k++){
                if(s.charAt(k)=='*') {
                    chessBoard[count][k] = 1;
                }
                else{
                    chessBoard[count][k] = 0;
                }
            }
            count++;
        }
        
    }

      public boolean doesPass() {
        //checks vertically
        for (int k = 0; k < 8; k++) {
            int sum = 0;
            for (int a = 0; a < 8; a++) {
                sum += chessBoard[k][a];
            }
            if (sum > 1) {
                return false;
            }
        }
        //checks horizantally
        for (int k = 0; k < chessBoard.length; k++) {
            int sum = 0;
            for (int a = 0; a < chessBoard[k].length; a++) {
                sum += chessBoard[a][k];
            }
            if (sum < 1) {
                return false;
            }
        }
        //checks diagonally down and to right
        for (int n = 0; n < 8; n++) {
            for (int m = 0; m < 8; m++) {
                int z = 0;
                int sum = 0;
                while (true) {
                    sum += chessBoard[n + z][m + z];
                    if (m + z + 1 < 8 && n + z + 1 < 8) {
                        z++;
                    } else {
                        break;
                    }
                }
                if (sum > 1) {
                    return false;
                }
            }
        }
        //checks diagonally up and to right
        for (int n = 0; n < 8; n++) {
            for (int m = 0; m < 8; m++) {
                int z = 0;
                int sum = 0;
                while (true) {
                    sum += chessBoard[n + z][m - z];
                    if (m - z - 1 >= 0 && n + z + 1 < 8) {
                        z++;
                    } else {
                        break;
                    }
                }
                if (sum > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
}
