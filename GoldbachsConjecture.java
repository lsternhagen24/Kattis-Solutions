import java.util.*;

/*
Solution to Kattis Problem Goldbach's Conjecture
https://open.kattis.com/problems/goldbach2
*/

public class GoldbachsConjecture {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //fast generation of all primes below 32010
        Set<Integer> primes = sieveOfEratosthenes(32010);
        //read primes into list and sort them
        int[] pList = new int[primes.size()];
        int iter = 0;
        for(Integer e: primes)pList[iter++]=e;
        Arrays.sort(pList);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            //set to hold all current ways to add to get number
            Set<String> list = new HashSet<String>();
            //arraylist which holds order of numbers
            ArrayList<String> al = new ArrayList<String>();
            //int we are trying to add to
            int search = sc.nextInt();
            int c = 0;
            //loop through all primes less than search
            while(pList[c] < search){
                int a = pList[c];
                //if the primes contains the other addative, then add to list
                if(primes.contains(search-a)){
                    int left = Math.min(a, search-a);
                    int right = Math.max(a, search-a);
                    String g = left + "+" +right;
                    if(!list.contains(g)){
                       list.add(g);
                       al.add(g);
                    }
                }
                c++;
            }
            //print output
            System.out.println(search + " has " + al.size() + " representation(s)");
            for(String r: al)System.out.println(r);
            System.out.println("");
        }
    }
    //sieve for fast generations of primes
    public static Set<Integer> sieveOfEratosthenes(int n){ 
        boolean prime[] = new boolean[n+1]; 
        for(int i=0;i<n;i++) 
            prime[i] = true; 
        for(int p = 2; p*p <=n; p++){ 
            if(prime[p] == true){ 
                for(int i = p*p; i <= n; i += p)prime[i] = false; 
            } 
        }
        Set<Integer> primes = new HashSet<Integer>();
        for(int i = 2; i < prime.length; i++)if(prime[i])primes.add(i);
        return primes;
    }    
}
