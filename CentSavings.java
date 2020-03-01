
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * @author L-Sternhagen
 Solution to kattis problem Cent Savings
 https://open.kattis.com/problems/centsavings
 */
public class CentSavings {
    public static int n;
    public static int d;
    public static int[] items;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //read input
        boolean toggleInput = false;
        if(!toggleInput){
            n = sc.nextInt();
            d = sc.nextInt();
            sc.nextLine();
            items = new int[n];
            for(int i = 0; i < n; i++)items[i] = sc.nextInt();
        }
        else {
            generateTestData();
        }      
        //input done
        //hold each state we could be in
        Set<State> currentStates = new HashSet<State>();
        int[][] minForEachDigit;
        //add initial state
        currentStates.add(new State(d,0,0));
        //for each item
        for(int i = 0; i < n; i++){
            Set<State> newStates = new HashSet<State>();
            //set up dynamic programming array
            minForEachDigit = new int[10][d+1]; for(int[] row: minForEachDigit)Arrays.fill(row, Integer.MAX_VALUE);

            for(State g: currentStates){
                //newcost = oldcost + cost of adding divider on current item
                int newCost = g.cost + getCost((g.lastDigit+items[i])%10);
                //if still dividers left add divider and put new state in with newcost and 0 for lastDigit
                if(g.dividersLeft>0){
                    //check if table has better cost already
                    if(minForEachDigit[0][g.dividersLeft-1] > newCost){
                        newStates.add(new State(g.dividersLeft-1,newCost, 0));
                        minForEachDigit[0][g.dividersLeft-1] = newCost;
                    }
                }
                //add state where no divider is added with same cost and new lastdigit
                //check if table has better cost already
                if(minForEachDigit[(g.lastDigit+items[i])%10][g.dividersLeft] > g.cost){
                    newStates.add(new State(g.dividersLeft,g.cost,(g.lastDigit+items[i])%10));
                    minForEachDigit[(g.lastDigit+items[i])%10][g.dividersLeft] = g.cost;
                }
            }
            currentStates = newStates;
        }

        //find minCost
        int minCost = Integer.MAX_VALUE;
        for(State k: currentStates){
            //add cost of after last digit
            k.cost+=getCost(k.lastDigit);
            //if new minimum, update
            if(k.cost < minCost)minCost = k.cost;
        }
        //calculate overall sum
        int sum = 0;
        for(int i = 0; i < n; i++)sum+=items[i];
        //print out sum + minCos value (mincost is negative if lowercost can be generated)
        System.out.println(sum+minCost);
        
        
    }
    public static void generateTestData(){
        n = 2000;
        d = 20;
        items = new int[n];
        Random r = new Random();
        for(int i = 0; i < n; i++){
            items[i] = 1+r.nextInt(9999);
        }
    
    }
    //holds a state we could be in, each state has a last digit from the sum, a total cost of money lost or gained, and the number of dividers left
    public static class State{
        int dividersLeft;
        int cost;
        int lastDigit;
        //constructor for the state
        public State(int dividersUsed, int cost, int lastDigit){
            this.dividersLeft = dividersUsed;
            this.cost = cost;
            this.lastDigit = lastDigit;
        }
        @Override
        public int hashCode(){
            String a = dividersLeft+ " " + cost + " " + lastDigit;
            return a.hashCode();
        }
        @Override
        public String toString(){
            return "Dividers Left = " + dividersLeft  + "\n" + "Cost = " + cost + "\n" + "Last Digit = " +  lastDigit;
        }
    }
    //find the cost for a given integer
    public static int getCost(int i){
        if(i < 5)return i *-1;
        else return 10-i; 
    }
}
