import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/*
 * @author lucas
 Solution to Kattis Problem 4 Thought
 https://open.kattis.com/problems/4thought
 */
public class Fours {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        //map each solution to a string of how to generate it
        Map<Integer, String> myMap = getAll();
        //loop through all testcases
        for (int i = 0; i < testCases; i++) {
            //read the answer we need to compute an answer for
            int answer = Integer.parseInt(br.readLine());
            //if the solution doesn't exist print 'no solution'
            if (!myMap.containsKey(answer)) {
                System.out.println("no solution");
            }
            //else print out the solution
            else {
                System.out.println(myMap.get(answer) + "= " + answer);
            }
        }
    }
    //find all solutions
    public static Map<Integer, String> getAll(){
        String s = "+++";
        Map<Integer, String> h = new HashMap<Integer, String>();
        //generate all possible combinations of the four operators
        while(!s.equals("///")){
            int num = compute(s);
             String output = "4 " + s.charAt(0) + " 4 " + s.charAt(1) + " 4 " + s.charAt(2) + " 4 ";
             h.put(num, output);
            //iterate to the next solution
             s = iterate(s);
        }
        return h;
    }
    //iterate the operator string to the next solution
    public static String iterate(String s){
        char a = s.charAt(0);
        char b = s.charAt(1);
        char c = s.charAt(2);
       c = move(c);
       if(c == '+'){
         b = move(b);
         if(b=='+'){
             a = move(a);
         }
       }
       return "" +a + b + c + "";
    }
    //move the char to the next possible operator
    public static char move(char a){
        if(a=='+'){
            return '-';
        }
        else if(a=='-'){
            return '*';
        }
        else if(a=='*'){
            return '/';
        }
        else {
            return '+';
        }
    }
    //find the answer for a given operator string
    public static int compute(String s){
        char a = s.charAt(0);
        char b = s.charAt(1);
        char c = s.charAt(2);
        int left = 0;
        int right = 0;
        int middle = 0;
        //first operate on '*' and '/'
        if(b=='/' || b=='*' ){
            if(a=='/' || a=='*'){
                right = operator(a,4,4);
                middle = operator(b,right,4);
                return operator(c,middle,4);
            }
            if(c=='/' || c=='*'){
                middle = operator(b,4,4);
                right = operator(c,middle,4);
                return operator(a,4,right);
            }
            middle = operator(b,4,4);
        left = operator(a,4, middle);
        return operator(c,left,4);
        }
        else if(c=='/' || c=='*'){
            if(a=='/' || a=='*'){
            left = operator(a, 4,4);
            right = operator(c,4,4);
            return operator(b,left,right);   
            }
            left = operator(a, 4,4);
            right = operator(c,4,4);
            return operator(b,left,right);
        }
        else{
            left = operator(a,4,4);
            middle = operator(b, left, 4);
            return operator(c,middle,4);
        }
    }
    //compute an operation
    public static int operator(char e, int a, int b){
        return (e=='/') ? a/b : (e=='*') ? a*b : (e=='+') ? a+b : a-b;
    }
}
