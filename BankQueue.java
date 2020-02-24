/**
 * @author L-Sternhagen
 Katiis Solution to BankQueue Problem
 https://open.kattis.com/problems/bank
 */
import java.util.*;
public class BankQueue {
    //map each time to a priority queue of how much money we make from each customer.
    static Map<Integer, PriorityQueue<Integer>> h = new HashMap<Integer,PriorityQueue<Integer>>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int people = sc.nextInt();
        int maxTime = sc.nextInt();
        //loop through every customer, add them to the priority queue for their time that leave at
        for(int g = 0; g < people; g++){
            int worth = sc.nextInt(); int time = sc.nextInt(); sc.nextLine();
            if(h.containsKey(time)){h.get(time).add(worth);}
            else {h.put(time, new PriorityQueue<Integer>(Collections.reverseOrder())); h.get(time).add(worth);}
        }
        //add 0 for each time that we have no customers leaving at
        for(int i = 0; i < maxTime; i++){if(!h.containsKey(i)){h.put(i, new PriorityQueue<Integer>(Collections.reverseOrder())); h.get(i).add(0);}}
        //hold the maximum amounts we can make at each time period
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        //loop through each priority queue for each time period
        for(int i = 0; i < maxTime; i++){
            //add the top amound for each customer that leaves at that time
            pq.add(h.get(i).poll());
            //make sure no one else that leaves at this time is worth more than someone who already been served
            while(!h.get(i).isEmpty()){
                int cur = h.get(i).poll();
                //if the person we have already served is less than new value, remove them and add the new value
                if(pq.peek() < cur){
                    pq.poll();
                    pq.add(cur);
                }
            }
        }
        //loop through and sum up the final list of customers we served
        int sum = 0; 
        while(!pq.isEmpty())sum+=pq.poll();
        //print output
        System.out.println(sum);
    }
}
