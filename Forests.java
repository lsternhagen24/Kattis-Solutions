import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Forests {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int t = sc.nextInt(); sc.nextLine();
        int[][] people = new int[p][t];
        //read input
        while(sc.hasNextLine()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            sc.nextLine();
            people[a-1][b-1] = b;
        }
        //add all arrays to set
        Set<String> opinions = new HashSet<String>();
        for(int i = 0; i < p; i++)opinions.add(Arrays.toString(people[i]));
        System.out.println(opinions.size());
    }
}
