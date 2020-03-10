import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem Game Of Throwns
 https://open.kattis.com/problems/throwns
 */
public class GameOfThrowns {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        ArrayList<Integer> al = new ArrayList<Integer>();
        String[] input = sc.nextLine().split(" ");
        //read in commmands
        for(int i = 0; i < input.length; i++){
            //if we get to an 'undo' command then remove that many commands before it
            if(input[i].equals("undo")){
                i++;
                int r = Integer.parseInt(input[i]);
                for(int e =0; e < r; e++)al.remove(al.size()-1);
            } else al.add(Integer.parseInt(input[i]));
        }
        int pos = 0;
        //iterate through list of valid commands
        for(Integer c: al){
            c = c%n;
            pos+=c;
            if(pos < 0)pos = n-(pos*-1);
            if(pos>=n)pos-=n;
        }
        //print output
        System.out.println(pos);
    }
}
