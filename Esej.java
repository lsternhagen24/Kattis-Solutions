/**
 * @author L-Sternhagen
 Solution to Kattis Problem Esej
 https://open.kattis.com/problems/esej
 */
import java.util.*;
public class Esej {
    public static void main(String[] args) {
        //scanner for reading input
        Scanner sc = new Scanner(System.in);
        //read A and B
        int a = sc.nextInt();
        int b = sc.nextInt();
        //start at string 'a'
        String current = "a";
        //arraylist to contain list of words generated
        ArrayList<String> aaa = new ArrayList<String>();
        //add starting word
        aaa.add(current);
        //create 100,000 words
        for(int h = 0; h < 100000; h++){
            //increment on current word
            current = increment(current);
            //if we have created a string > 15 characters long, break
            if(current.length()>15){break;}
            //add new current word
            aaa.add(current);
            
        }
        int counter  = 0;
        //creat B number of words
        for(int h = 0; h < b; h++){
            //start at start of word list and increment
            System.out.print(aaa.get(counter) + " ");
            counter++;
            //if we have reached the end start over
            if(counter > aaa.size()-1)counter=0; 
        }
        //print line
        System.out.println();
        
    }
    //increments a string, 'a' will become 'b', 'z' will become 'aa', 'az' will become 'ba'
    public static String increment(String before){
        String letters = "abcdefghijklmnopqrstuvwxyz";
        int c = before.length()-1;
        String out = "";
        //find first non-z character position
        while(c>=0 && before.charAt(c)=='z')c--;
        //if all characters are z then increment one to the length and change all letters to be a
        if(c<0){
            for(int g = 0; g <= before.length(); g++)out+="a";
            
        }
        //else increment one to the last non z character and change all letters after it to be a
        else {
            out = before.substring(0,c);
            String v = letters.charAt(letters.indexOf(before.charAt(c) + "")+1)+"";
            out+=v;
            for(int f = c+1; f < before.length(); f++)out+="a";
        }
        //return output
        return out;
    }
}
