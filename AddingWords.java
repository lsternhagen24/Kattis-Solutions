
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class AddingWords {

    static Map<String, Integer> myMap = new HashMap<String, Integer>();
    static Map<Integer, String> myOtherMap = new HashMap<Integer, String>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        while (line != null) {
            String[] info = line.split(" ");
            if (info[0].equals("def")) {
                if(myMap.containsKey(info[1])){
                    myOtherMap.remove(myMap.get(info[1]));
                }
                myMap.put(info[1], Integer.parseInt(info[2]));
                myOtherMap.put(Integer.parseInt(info[2]), info[1]);
            } else if(info[0].equals("calc")) {
                System.out.println(calculate(info));
            }
            if (line.equals("clear")) {
                myMap.clear();
                myOtherMap.clear();
            }
          line = br.readLine();
        }
    }

    public static String calculate(String[] info) {
        LinkedList<String> queue = new LinkedList<String>();
        String output = "";
        for (int q = 1; q < info.length; q++) {
            output += info[q] + " ";
        }
        for (int i = 1; i < info.length - 1; i++) {
            if (Character.isAlphabetic(info[i].charAt(0)) && !myMap.containsKey(info[i])) {
                return output + "unknown";
            }
            String n = (Character.isAlphabetic(info[i].charAt(0))) ? myMap.get(info[i]) + "" : info[i];
            queue.add(n);
        }
        while (true) {
            String a = queue.pop();
            if (queue.isEmpty()) {
                int y = Integer.parseInt(a);
                if (!myOtherMap.containsKey(y)) {
                    return output + "unknown";
                }
                return output + myOtherMap.get(y);
            }
            String op = queue.pop();
            String b = queue.pop();
            String c = calc(op,a,b);
            queue.push(c);
        }
    }

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
