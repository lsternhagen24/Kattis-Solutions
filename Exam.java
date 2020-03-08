
import java.util.Scanner;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem Exam
 https://open.kattis.com/problems/exam
 */
public class Exam {
    public static void main(String[] args) {
        //read in the correct number of answers on friends exam
        Scanner sc = new Scanner(System.in);
        int correct = sc.nextInt(); sc.nextLine();
        //read in my answers and friends answers
        String myAnswers = sc.nextLine();
        String friendAnswers = sc.nextLine();
        //hold the number of answers the same and answers different than friend
        int same = 0;
        int different = 0;
        //total number of answers the same and different than friends
        for(int i = 0; i < myAnswers.length(); i++){
            if(myAnswers.charAt(i)==friendAnswers.charAt(i))same++;
            else different++;
        }
        //total number of answers
        int total = myAnswers.length();
        //we know we got at least the correct ones the same + this number they had wrong - different.
        int output = Math.min(same, correct) + Math.min(total-correct,different);
        //print output
        System.out.println(output);
    }
}
