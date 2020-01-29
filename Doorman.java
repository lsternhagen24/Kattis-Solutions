
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author L-Sternhagen
 */
public class Doorman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int diff = sc.nextInt(); sc.nextLine();
        
        String a = sc.nextLine();
        
        
        Queue<Character> line = new LinkedList<Character>();
        for(int i = 0; i < a.length(); i++)line.add(a.charAt(i));
        
        int g = 0; 
        int men = 0; 
        int women = 0;
        char current =line.poll();
        while(true){
            boolean added = false;
            
            if(Math.abs(men-women) < diff){men = current=='M' ? men+1: men; women = current=='W' ? women+1:women; g++; if(line.isEmpty())break; current = line.poll(); added=true;}
            else if((Math.abs(men-women) == diff) && ((men>women && current=='W') || (men<women && current=='M'))) {men = current=='M' ? men+1: men; women = current=='W' ? women+1:women; g++; if(line.isEmpty())break; current = line.poll(); added=true;}
            else if((Math.abs(men-women) == diff) && ((men>women && current=='M') || (men<women && current=='W'))) { if(!line.isEmpty()){char h = line.poll(); if((men>women && h=='W') || (men<women && h=='M')){men = h=='M' ? men+1: men; women = h=='W' ? women+1:women; g++;added=true;}   }}
            if(!added && Math.abs(men-women) == diff){break;}
            
        
        
        }
        
        System.out.println(g);
    }
}
