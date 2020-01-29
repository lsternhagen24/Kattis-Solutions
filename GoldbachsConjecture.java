import java.util.*;
public class GoldbachsConjecture {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> primes = sieveOfEratosthenes(32010);
        int[] pList = new int[primes.size()];
        int iter = 0;
        for(Integer e: primes)pList[iter++]=e;
        Arrays.sort(pList);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            Set<String> list = new HashSet<String>();
            ArrayList<String> al = new ArrayList<String>();
            int search = sc.nextInt();
            int c = 0;
            while(pList[c] < search){
                int a = pList[c];
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
            System.out.println(search + " has " + al.size() + " representation(s)");
            for(String r: al)System.out.println(r);
            System.out.println("");
        }
    }
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
