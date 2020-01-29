
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lucas
 */
public class Base2Palindromes {

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] firstRow = {4, 6, 4};
        int[] secondRow = {12, 6, 12};
        ArrayList<Integer> answers = new ArrayList<Integer>();
        answers.addAll(Arrays.asList(1, 3, 5, 7, 9, 15,17,21,27,31,33,45,51,63));
        boolean rowType = true;
        int current = 63;
        while (answers.size() < 50000) {
            if (rowType == true) {
                current += 2;
                answers.add(current);
                rowType = false;
                int[] temp = new int[firstRow.length * 2 + 1];
                int iterator = 0;
                for (int i : firstRow) {
                    temp[iterator++] = i*2;
                }
                temp[iterator++] = 6;
                for (int i = firstRow.length-1; i >=0; i--) {
                    temp[iterator++] = firstRow[i] * 2;
                }
                for (int i : temp) {
                    current += i;
                    answers.add(current);
                }
                firstRow = temp;
            }
            if (rowType == false) {
                current += 2;
                answers.add(current);
                rowType = true;
                int iterator = 0;
                int[] temp2 = new int[secondRow.length * 2 + 1];
                for (int i : secondRow) {
                    temp2[iterator++] = i*2;
                }
                temp2[iterator++] = 6;
                for (int i = secondRow.length-1; i>=0; i--) {
                    temp2[iterator++] = secondRow[i] * 2;
                }
                for (int i : temp2) {
                    current += i;
                    answers.add(current);
                }
                secondRow = temp2;
            }
        }
        int n = Integer.parseInt(br.readLine())-1;
        System.out.println(answers.get(n));
    }
}
