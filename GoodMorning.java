
import java.util.*;

/**
 * @author L-Sternhagen
 */
public class GoodMorning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> marked = new HashSet<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        int[][] nbs = {{0},{1,2,3,4,5,6,7,8,9,0},{2,3,5,6,8,9,0},{3,6,9},{4,5,6,7,8,9,0},{5,6,8,9,0},{6,9},{7,8,9,0},{8,9,0},{9}};
        for(int i = 0; i < 10; i++)q.add(i);
        while(!q.isEmpty()){
            int cur = q.poll();
            String s = cur + "";
            if(!marked.contains(cur))marked.add(cur);
            int pos = Integer.parseInt(s.substring(s.length()-1));
            for(Integer j: nbs[pos]){
                String g = s+""+j;
                int h = Integer.parseInt(g);
                if(!marked.contains(h) && h < 500){marked.add(h); q.add(h);}
            }
        }
        int[] num = new int[marked.size()];
        int iter = 0;
        for(Integer r: marked)num[iter++]=r;
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            int f = sc.nextInt();
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < num.length; j++){
                if(Math.abs(f-num[j]) < Math.abs(f-min))min = num[j];
            }
            System.out.println(min);
        }
        
    }
}
