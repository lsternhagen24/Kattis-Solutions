/**
 * @author L-Sternhagen
 */
import java.util.*;
public class Esej {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        String current = "a";
        ArrayList<String> aaa = new ArrayList<String>();
        aaa.add(current);
        for(int h = 0; h < 100000; h++){
            current = increment(current);
            if(current.length()>15){break;}
            aaa.add(current);
            
        }
        String output = "";
        int counter  = 0;
        for(int h = 0; h < b; h++){
            System.out.print(aaa.get(counter) + " ");
            counter++;
            if(counter > aaa.size()-1)counter=0; 
        }
        System.out.println();
        
    }
    
    
    public static String increment(String before){
        String letters = "abcdefghijklmnopqrstuvwxyz";
        int c = before.length()-1;
        String out = "";
        while(c>=0 && before.charAt(c)=='z')c--;
        if(c<0){
            for(int g = 0; g <= before.length(); g++)out+="a";
            
        } else {
            out = before.substring(0,c);
            String v = letters.charAt(letters.indexOf(before.charAt(c) + "")+1)+"";
            out+=v;
            for(int f = c+1; f < before.length(); f++)out+="a";
        
        }
    
        return out;
    }
}
