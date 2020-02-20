
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
Solution to Kattis Problem Adding Words
https://open.kattis.com/problems/addingwords
*/

public class AddingWords {

    //
    static Map<String, Integer> myMap = new HashMap<String, Integer>();
    static Map<Integer, String> myOtherMap = new HashMap<Integer, String>();

    public static void main(String[] args) throws Exception {
        //read input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        while (line != null) {
            String[] info = line.split(" ");
            //if we are defining a value
            if (info[0].equals("def")) {
                //if we have already defined the value, remove the old value
                if(myMap.containsKey(info[1])){
                    myOtherMap.remove(myMap.get(info[1]));
                }
                //map string to value
                myMap.put(info[1], Integer.parseInt(info[2]));
                //map value to string
                myOtherMap.put(Integer.parseInt(info[2]), info[1]);
            } 
            //calculate on calc keyword and print output
            else if(info[0].equals("calc")) {
                System.out.println(calculate(info));
            }
            //clear maps on clear keyword
            if (line.equals("clear")) {
                myMap.clear();
                myOtherMap.clear();
            }
          //read next input
          line = br.readLine();
        }
    }
    //returns the string representation of calculating the String info array.
    public static String calculate(String[] info) {
        //create a queue of calculations to process
        LinkedList<String> queue = new LinkedList<String>();
        //start with empty output
        String output = "";
        //add calc string
        for (int q = 1; q < info.length; q++) {
            output += info[q] + " ";
        }
        //loop through string array
        for (int i = 1; i < info.length - 1; i++) {
            //if we are on a variable (not +, -, =) and the variable isn't defined (not in map), return unknown
            if (Character.isAlphabetic(info[i].charAt(0)) && !myMap.containsKey(info[i])) {
                return output + "unknown";
            }
            //add integer string cooresponds to in map, or operation if it is one
            String n = (Character.isAlphabetic(info[i].charAt(0))) ? myMap.get(info[i]) + "" : info[i];
            queue.add(n);
        }
        //loop through queue till empty
        while (true) {
            String a = queue.pop();
            //if we are on last element of queue
            if (queue.isEmpty()) {
                int y = Integer.parseInt(a);
                //if the answer isn't a defined number, then return unknown
                if (!myOtherMap.containsKey(y)) {
                    return output + "unknown";
                }
                //else return the defined value
                return output + myOtherMap.get(y);
            }
            //get the operator, and two values, then calculate
            String op = queue.pop();
            String b = queue.pop();
            String c = calc(op,a,b);
            //add the value returned
            queue.push(c);
        }
    }
    //calculates the value given an operator, and two values to use the operator with
    public static String calc(String op, String a, String b) {
        int x = Integer.parseInt(a);
        int z = Integer.parseInt(b);
        if (op.equals("+")) {
            int y = x + z;
            return y + "";
        } else {
            int y = x - z;
            return y + "";
        }

    }
}
