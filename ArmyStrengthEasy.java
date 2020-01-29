
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucas
 */
public class ArmyStrengthEasy {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for(int i = 0; i < testCases; i++){
            br.readLine();
            br.readLine();
            String line = br.readLine();
        PriorityQueue<Integer> godZilla = new PriorityQueue<>();
        PriorityQueue<Integer> mechaZilla = new PriorityQueue<>();
            String[] gz = line.split(" ");
            for(int a = 0; a< gz.length; a++) godZilla.add(Integer.parseInt(gz[a]));
            line = br.readLine();
            String[] mgz = line.split(" ");
            for(int a = 0; a < mgz.length; a++)mechaZilla.add(Integer.parseInt(mgz[a]));
            while(!godZilla.isEmpty() && !mechaZilla.isEmpty()){
                if(godZilla.peek() < mechaZilla.peek()){
                    godZilla.poll();
                }
                else{
                    mechaZilla.poll();
                }
            }
                        if(godZilla.isEmpty()){
                            System.out.println("MechaGodzilla");
                        }
                        else if(mechaZilla.isEmpty()){
                            System.out.println("Godzilla");
                        }
                        else{
                            System.out.println("uncertain");
                        }
       }
    }
}
