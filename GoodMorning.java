
import java.util.*;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem Good Morning
 https://open.kattis.com/problems/goodmorning
 */
public class GoodMorning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //marked integers we can reach
        Set<Integer> marked = new HashSet<Integer>();
        //q for bfs
        Queue<Integer> q = new LinkedList<Integer>();
        //list of integers we can reach from each integer. (0 can only reach 0), (1 can reach every number)
        int[][] nbs = {{0},{1,2,3,4,5,6,7,8,9,0},{2,3,5,6,8,9,0},{3,6,9},{4,5,6,7,8,9,0},{5,6,8,9,0},{6,9},{7,8,9,0},{8,9,0},{9}};
        //we can bfs from every number
        for(int i = 0; i < 10; i++)q.add(i);
        while(!q.isEmpty()){
            int cur = q.poll();
            String s = cur + "";
            //if we haven't been here before add it to the locations we have now been to
            if(!marked.contains(cur))marked.add(cur);
            //find the last position we were at
            int pos = Integer.parseInt(s.substring(s.length()-1));
            //loop through all numbers we can get to from this position
            for(Integer j: nbs[pos]){
                String g = s+""+j;
                int h = Integer.parseInt(g);
                //if we haven't marked the new position, then mark it and it to the bfs queue
                if(!marked.contains(h) && h < 500){marked.add(h); q.add(h);}
            }
        }
        //read set of integers into num array
        int[] num = new int[marked.size()];
        int iter = 0;
        for(Integer r: marked)num[iter++]=r;
        int t = sc.nextInt();
        //find closest value to the integer we are trying to get to
        for(int i = 0; i < t; i++){
            int f = sc.nextInt();
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < num.length; j++){
                if(Math.abs(f-num[j]) < Math.abs(f-min))min = num[j];
            }
            //print output
            System.out.println(min);
        }
    }
}
