
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author L-Sternhagen
 */
public class Font {
    static String[] words;
    static Set<String> correct = new HashSet<String>();
    static Map<String, Integer> states = new HashMap<String,Integer>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        words = new String[n];
        for(int i = 0; i < n; i++)words[i] = sc.nextLine();
        Map<State,Integer> marked = new HashMap<State,Integer>();
        for(int f = 0; f < n; f++){
            String current_word = words[f];
            int[] cur = new int[26]; Arrays.fill(cur, 0);
            for(int v = 0; v < current_word.length(); v++){
                if(cur[Character.getNumericValue(current_word.charAt(v))-10]==0){
                cur[Character.getNumericValue(current_word.charAt(v))-10]=1;}
            }
            State current_state = new State(cur);

            Map<State, Integer> updates = new HashMap<State,Integer>();
            
            for(State e: marked.keySet()){
                State nn = addState(e,current_state);
                if(updates.containsKey(nn))updates.put(nn,updates.get(nn)+marked.get(e));
                else if(marked.containsKey(nn))updates.put(nn, marked.get(nn)+marked.get(e));
                else updates.put(nn, marked.get(e));
            }
            if(updates.containsKey(current_state))updates.put(current_state, updates.get(current_state)+1);
            else if(marked.containsKey(current_state))updates.put(current_state, marked.get(current_state)+1);
            else updates.put(current_state,1);
            for(State h: updates.keySet())marked.put(h, updates.get(h));
        }
        int total = 0;
        for(State ggg: marked.keySet()){if(getSum(ggg.a)>=26){total+=marked.get(ggg);}}
        System.out.println(total);
        
        
    }
    public static class State{
        int[]a;
        public State(int[] a){
            this.a=a;
        }
    @Override
    public int hashCode(){
        String f = Arrays.toString(a);
        return f.hashCode();
    }
    @Override
    public boolean equals(Object o){
        State g = (State)o;
        boolean eq = true;
        for(int bb = 0; bb < 26; bb++){
            if(this.a[bb]!=g.a[bb]){
                eq = false;
                break;
            }
        }
        return eq;
    }
    @Override
    public String toString(){
        String f = "";
        for(int q = 0; q < 26; q++){
            f += a[q] + " ";
        }
        return f;
    }
    
    }
    public static State addState(State a, State b){
        int[] g = new int[26];
        Arrays.fill(g, 0);
        for(int d = 0; d < 26; d++)if(a.a[d]==1 || b.a[d]==1)g[d]=1;
        return new State(g);
    }
    

   
    
    public static Integer[] subtract_word(Integer[]a, int b){
        String word = words[b];
        Integer[] c = new Integer[a.length];
        for(int gg =0; gg < a.length; gg++)c[gg]=a[gg];
        for(int i = 0; i < word.length(); i++){
            c[Character.getNumericValue(word.charAt(i))-10]--; 
        }
        return c;
    }
    
    

    public static int getSum(int[] a){
            int sum = 0;
            for(int w = 0; w < a.length; w++){
                if(a[w] > 0)sum++;
            }
            return sum;
        }
}
