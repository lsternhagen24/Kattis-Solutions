/**
 * @author L-Sternhagen
 Solution to Kattis Problem T9 Spelling
 https://open.kattis.com/problems/t9spelling
 */
import java.util.*;
public class TNineSpelling {
    public static void main(String[] args) {
        //Scanner for reading input
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        for(int i = 0; i <n; i++){
            //map each character to the number it coorelates to
            Map<Character, Integer> g = new HashMap<Character, Integer>();
            g.put('a', 2);
            g.put('b',2);
            g.put('c',2);
            g.put('d', 3);
            g.put('e',3);
            g.put('f',3);
            g.put('g', 4);
            g.put('h',4);
            g.put('i',4);
            g.put('j', 5);
            g.put('k',5);
            g.put('l',5);
            g.put('m', 6);
            g.put('n',6);
            g.put('o',6);
            g.put('p', 7);
            g.put('q',7);
            g.put('r',7);
            g.put('s', 7);
            g.put('t',8);
            g.put('u',8);
            g.put('v', 8);
            g.put('w',9);
            g.put('x',9);
            g.put('y', 9);
            g.put('z',9);
            g.put(' ', 0);
            //map each number to the string it can reach
            Map<Integer,String> h = new HashMap<Integer,String>();
            h.put(2, "abc");
            h.put(3, "def");
            h.put(4, "ghi");
            h.put(5, "jkl");
            h.put(6, "mno");
            h.put(7, "pqrs");
            h.put(8, "tuv");
            h.put(9, "wxyz");
            h.put(0, " ");
            
            //reach the message
            String message = sc.nextLine();
            int previous = -1;
            String output = "";
            for(int a = 0; a < message.length(); a++){
                char c = message.charAt(a);
                int j = g.get(c);
                //if we are on the same number insert a pause
                if(j==previous)output+=" ";
                previous = j;
                int k = h.get(j).indexOf(c+"")+1;
                //add number to string
                for(int l = 0; l < k; l++)output+=j+"";
            }
            //print output
            System.out.println("Case #"+(1+i)+": "+output);\
        }
    }
}
