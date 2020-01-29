
import java.util.Scanner;

/**
 * @author L-Sternhagen
 */
public class Exam {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int correct = sc.nextInt(); sc.nextLine();
        
        String myAnswers = sc.nextLine();
        String friendAnswers = sc.nextLine();
        
        
        int same = 0;
        int different = 0;
        
        for(int i = 0; i < myAnswers.length(); i++){
            if(myAnswers.charAt(i)==friendAnswers.charAt(i))same++;
            else different++;
        }
        
        int total = myAnswers.length();
        
        int output = Math.min(same, correct) + Math.min(total-correct,different);
        
        System.out.println(output);
        
    }
}
