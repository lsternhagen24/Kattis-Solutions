/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author lucas
 */
public class CDs {

    public static void main(String[] args) {
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = br.readLine();
            int count = 0;
            int jack = Integer.parseInt(line.substring(0, line.indexOf(" ")));
            int jill = Integer.parseInt(line.substring(line.indexOf(" ")+1));
            if (jack == 0 && jill == 0) {
                break;
            }
            Set<Integer> jAndJCD = new HashSet<Integer>();
            while (jack > 0) {
                int current = Integer.parseInt(br.readLine());
                jAndJCD.add(current);
                jack--;
            }
            while (jill > 0) {
                int current = Integer.parseInt(br.readLine());
                if (jAndJCD.contains(current)) {
                    count++;
                }
                jill--;
            }
            System.out.println(count);
        }
        }catch(Exception e){
            
        }
    }
}
