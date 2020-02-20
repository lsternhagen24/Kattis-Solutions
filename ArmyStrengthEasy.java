
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 *
 * @author lucas
 Solution to Kattis Problem Army Strength (Easy)
 https://open.kattis.com/problems/armystrengtheasy
 */
public class ArmyStrengthEasy {
    public static void main(String args[]) throws Exception{
        //read number of test cases
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        //loop through each test case
        for(int i = 0; i < testCases; i++){
            br.readLine();
            br.readLine();
            String line = br.readLine();
            //create PriorityQueue for each Army
            PriorityQueue<Integer> godZilla = new PriorityQueue<>();
            PriorityQueue<Integer> mechaZilla = new PriorityQueue<>();
            //parse input and add all army strengths to each side's army
            String[] gz = line.split(" ");
            for(int a = 0; a< gz.length; a++) godZilla.add(Integer.parseInt(gz[a]));
            line = br.readLine();
            String[] mgz = line.split(" ");
            for(int a = 0; a < mgz.length; a++)mechaZilla.add(Integer.parseInt(mgz[a]));
            //simulate battle
            while(!godZilla.isEmpty() && !mechaZilla.isEmpty()){
                //find stronger of two fighting and remove it
                if(godZilla.peek() < mechaZilla.peek()){
                    godZilla.poll();
                }
                else{
                    mechaZilla.poll();
                }
            }
            //if godzilla lost, print MechaGodzilla                      
            if(godZilla.isEmpty()){
                System.out.println("MechaGodzilla");
            }
            //If MechaZilla lost, print Godzilla
            else if(mechaZilla.isEmpty()){
                System.out.println("Godzilla");
            }
            //else tie, print uncertain
            else{
                System.out.println("uncertain");
            }
       }
    }
}
