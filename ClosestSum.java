
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author L-Sternhagen
 */
public class ClosestSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //read testcases
        int aaa = 0;
        //loop through while there is still input
        while(sc.hasNextLine()){
            aaa++;
            System.out.println("Case " + aaa + ":");
            //put all numbers into an arraylist and sort
            ArrayList<Integer> al = new ArrayList<Integer>();
            int n = sc.nextInt();sc.nextLine();
            for(int w = 0; w < n; w++)al.add(Integer.parseInt(sc.nextLine()));
            Collections.sort(al);
            int q = sc.nextInt();sc.nextLine();
            //loop through each query
            for(int bbb = 0; bbb < q; bbb++){
                //read query
                int query = sc.nextInt(); sc.nextLine();
                int min = Integer.MAX_VALUE;
                int out = Integer.MAX_VALUE;
                //check each number in arraylist
                for(int y = 0; y < al.size(); y++){
                    int i = al.get(y);
                    //get index of closest value that sum's to query
                    int index = Collections.binarySearch(al, query-i);
                    if(index<0)index = (index+1)*-1;
                    //if we are at at the last index decrease by one
                    if(index==al.size())index--;
                    //if we are before the first index move to the first index
                    if(index<0)index++;
                    //find the closest sum
                    int vv = al.get(index);
                    //update out if we are at a new best
                    if(getM(query,i,vv) < min && index!=y){min = getM(query,i,vv); out = getO(query,i,vv);}
                    //check location on the left side incase we are at the same index we started at.
                    if(index-1 > 0){
                        vv = al.get(index-1);
                        if(getM(query,i,vv) < min && (index-1!=y)){min = getM(query,i,vv); out = getO(query,i,vv);}
                    }
                    //check location on right side incase we are at the same index we started at.
                    if(index+1 < al.size()){
                        vv = al.get(index+1);
                        if(getM(query,i,vv) < min && index+1!=y){min = getM(query,i,vv); out = getO(query,i,vv);}
                    }
                }
                //print output
                System.out.println("Closest sum to " + query + " is " + out + ".");
            }
        }
    }
    //get the output sum
    public static int getO(int query, int i, int j){
        return  i+j;
    }
    //get the absolute value distance from the query these two int's i and j sum to.
    public static int getM(int query, int i, int j){
        return (int)Math.abs(query - i - j);
    }
}
