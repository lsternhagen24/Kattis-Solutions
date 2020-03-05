
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author L-Sternhagen
 Solution to Kattis problem Doorman
 https://open.kattis.com/problems/doorman
 */
public class Doorman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //read maximum difference club can handle
        int diff = sc.nextInt(); sc.nextLine();
        //read input character string
        String a = sc.nextLine();
        //create queue of characters to hold order of who is up next
        Queue<Character> line = new LinkedList<Character>();
        for(int i = 0; i < a.length(); i++)line.add(a.charAt(i));
        //g = total let into club
        int g = 0; 
        //number of women and men let in
        int men = 0; 
        int women = 0;
        //get current character
        char current =line.poll();
        while(true){
            boolean added = false;
            //4 scenarios, let in women, let in man, skip women, skip man, break when we reach end or cannot add anyone else
            if(Math.abs(men-women) < diff){men = current=='M' ? men+1: men; women = current=='W' ? women+1:women; g++; if(line.isEmpty())break; current = line.poll(); added=true;}
            else if((Math.abs(men-women) == diff) && ((men>women && current=='W') || (men<women && current=='M'))) {men = current=='M' ? men+1: men; women = current=='W' ? women+1:women; g++; if(line.isEmpty())break; current = line.poll(); added=true;}
            else if((Math.abs(men-women) == diff) && ((men>women && current=='M') || (men<women && current=='W'))) { if(!line.isEmpty()){char h = line.poll(); if((men>women && h=='W') || (men<women && h=='M')){men = h=='M' ? men+1: men; women = h=='W' ? women+1:women; g++;added=true;}   }}
            if(!added && Math.abs(men-women) == diff){break;}
        }
        //print output
        System.out.println(g);
    }
}
