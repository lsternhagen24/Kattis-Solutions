/**
 * @author L-Sternhagen
 */
import java.util.*;
public class BankQueue {
    static Map<Integer, PriorityQueue<Integer>> h = new HashMap<Integer,PriorityQueue<Integer>>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int people = sc.nextInt();
        int maxTime = sc.nextInt();
        
        for(int g = 0; g < people; g++){
            int worth = sc.nextInt(); int time = sc.nextInt(); sc.nextLine();
            if(h.containsKey(time)){h.get(time).add(worth);}
            else {h.put(time, new PriorityQueue<Integer>(Collections.reverseOrder())); h.get(time).add(worth);}
        }
        for(int i = 0; i < maxTime; i++){if(!h.containsKey(i)){h.put(i, new PriorityQueue<Integer>(Collections.reverseOrder())); h.get(i).add(0);}}
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 0; i < maxTime; i++){
            pq.add(h.get(i).poll());
            while(!h.get(i).isEmpty()){
                int cur = h.get(i).poll();
                if(pq.peek() < cur){
                    pq.poll();
                    pq.add(cur);
                }
            }
        }
        int sum = 0; 
        while(!pq.isEmpty())sum+=pq.poll();
        System.out.println(sum);
    }
}
