
import java.util.Scanner;

public class Apaxiaa {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                int a = i + 1;
                while (a < input.length() && input.charAt(a) == input.charAt(i)) a++;
                input = input.substring(0,i) + input.substring(a-1);
            }
        }
        System.out.println(input);
    }
}