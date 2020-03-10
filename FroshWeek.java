
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem Frosh Week
 https://open.kattis.com/problems/froshweek2
 */
public class FroshWeek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt(); sc.nextLine();
        //read input into two arraylist of integers
        String[] input = sc.nextLine().split(" ");
        ArrayList<Integer> tasks = new ArrayList<Integer>();
        for(String k: input)tasks.add(Integer.parseInt(k));
        input = sc.nextLine().split(" ");
        ArrayList<Integer> times = new ArrayList<Integer>();
        for(String k: input)times.add(Integer.parseInt(k));
        //sort the two arraylists in reverse order
        Collections.sort(times, Collections.reverseOrder());
        Collections.sort(tasks, Collections.reverseOrder());
        //start count at 0, tasks and times both at index 0
        int count = 0;
        int t1 = 0, t2=0;
        //count number of times task is less than time allowed in O(n) time
        while(t1 < times.size()){
            while(t2 < tasks.size() && tasks.get(t2) > times.get(t1))t2++;
            //if we have gone through all tasks move to next time
            if(t2==tasks.size())break;
            count++;
            //increment both tasks and times
            t1++;
            t2++;
        }
        //print output
        System.out.println(count);
    }
}
