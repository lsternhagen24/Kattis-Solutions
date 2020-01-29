
import java.util.*;

public class GeneticSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        //run until end of input
        while(!line.equals("0")){
            //get search string S
            String a = line.substring(0,line.indexOf(" "));
            //get string to search in L
            String b = line.substring(line.indexOf(" ") + 1);
            //generate all deletion substrings from A
            Set<String> deletions = getDeletions(a);
            //generate all insertion substrings from A
            Set<String> insertions = getInsertions(a);
            //count for type1, type2 and type3 matches
            int type1 = 0, type2 = 0, type3 = 0;
            //go through every index in b
            for(int w = 0; w < b.length(); w++){
                //if substring is in bounds for type1 then check if it matches
                if(w+a.length() <=b.length()){
                    String c1 = b.substring(w, w + a.length());
                    if(a.equals(c1))type1++;
                }
                //if substring is in bounds for type2, (deletion type), then check if deletion set contains the substring 
                if(w+a.length()-1 <=b.length()){
                    String c2 = b.substring(w, w + a.length()-1);
                    if(deletions.contains(c2))type2++;
                }
                //if substring in in bounds for type3, (insertion type), then check if insertion set contains the substring
                 if(w+a.length()+1 <=b.length()){
                    String c3 = b.substring(w, w + a.length()+1);
                    if(insertions.contains(c3))type3++;
                }
            }
            //print output
            System.out.println(type1 + " "+ type2 + " "+ type3);
            line = sc.nextLine();
        }
    }
    //generate all deletion substrings that can be made by deleting one character from string a and return the set
    static Set<String> getDeletions(String a){
        Set<String> d = new HashSet<String>();
        for(int i = 0; i < a.length(); i++){
            d.add((a.substring(0,i) + a.substring(i+1)));
        }
        return d;
    }
    //generate all insertion substring that can be made by inserting one character to string a and return the set
    static Set<String> getInsertions(String a){
        Set<String> d = new HashSet<String>();
        String[] e = {"A", "C","G", "T"};
        for(int i = 0; i <= a.length(); i++){
            for(String f: e){
                d.add((a.substring(0,i) + f + a.substring(i)));
            }
        }
        return d;
    }
}
