import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem Exactly Electrical
 https://open.kattis.com/problems/exactlyelectrical
 */
public class ExactlyElectrical {
    public static void main(String[] args) {
        //read intput starting points
        Scanner sc = new Scanner(System.in);
        int startX = sc.nextInt();
        int startY = sc.nextInt();
        sc.nextLine();
        //read input ending points
        int endX = sc.nextInt();
        int endY = sc.nextInt();
        sc.nextLine();
        //read the charge of electricity you must use
        int charge = sc.nextInt(); sc.nextLine();
        //read the difference in coordinates you have to go to
        int xDiff = Math.abs(startX-endX);
        int yDiff = Math.abs(startY-endY);
        //find the total distance you have to move
        int distance = xDiff+yDiff;
        //if the distance is too far we can't get there
        if(distance>charge)System.out.println("N");
        //else we can get there if the distance is equal
        else if(distance==charge)System.out.println("Y");
        else{
            //if both are even we can get there
            if(distance%2==0&&charge%2==0)System.out.println("Y");
            //if both are odd we can get there
            else if(distance%2!=0&&charge%2!=0)System.out.println("Y");
            //we can't get there
            else System.out.println("N");
        }
    }
}
