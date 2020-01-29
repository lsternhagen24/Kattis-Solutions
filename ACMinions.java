
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lucas
 */
public class ACMinions {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<Integer>[] rooms = new HashSet[2*n];
        for(int i = 0; i< rooms.length; i++){
            rooms[i] = new HashSet<Integer>();
        }
        for(int m = 0; m < n; m++){
            String[] line = br.readLine().split(" ");
            rooms[Integer.parseInt(line[0])-1].add(Integer.parseInt(line[1])-1);
        }
        int min = Integer.MAX_VALUE, count = 0;
        for(int i = 0; i < rooms.length; i++){
            if(min < i){ min = Integer.MAX_VALUE; count++;}
            for(int e : rooms[i]) if(min > e) min = e;
        }
        if(min < rooms.length) count++;
        System.out.println(count);
    }
}
