
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author L-Sternhagen
 */
public class ClosestSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aaa = 0;
        while(sc.hasNextLine()){
            aaa++;
            System.out.println("Case " + aaa + ":");
            ArrayList<Integer> al = new ArrayList<Integer>();
            int n = sc.nextInt();sc.nextLine();
            for(int w = 0; w < n; w++)al.add(Integer.parseInt(sc.nextLine()));
            Collections.sort(al);
            int q = sc.nextInt();sc.nextLine();
            for(int bbb = 0; bbb < q; bbb++){
                int query = sc.nextInt(); sc.nextLine();
                int min = Integer.MAX_VALUE;
                int out = Integer.MAX_VALUE;
                for(int y = 0; y < al.size(); y++){
                    int i = al.get(y);
                    int index = Collections.binarySearch(al, query-i);
                    if(index<0)index = (index+1)*-1;
                    if(index==al.size())index--;
                    if(index<0)index++;
                    int vv = al.get(index);
                    if(getM(query,i,vv) < min && index!=y){min = getM(query,i,vv); out = getO(query,i,vv);}
                    if(index-1 > 0){
                        vv = al.get(index-1);
                        if(getM(query,i,vv) < min && (index-1!=y)){min = getM(query,i,vv); out = getO(query,i,vv);}
                    }
                    if(index+1 < al.size()){
                        vv = al.get(index+1);
                        if(getM(query,i,vv) < min && index+1!=y){min = getM(query,i,vv); out = getO(query,i,vv);}
                    }
                }
                System.out.println("Closest sum to " + query + " is " + out + ".");
            }
        }
    }
    public static int getO(int query, int i, int j){
        return  i+j;
    }
    public static int getM(int query, int i, int j){
        return (int)Math.abs(query - i - j);
    }
}
