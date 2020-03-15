/**
 * @author L-Sternhagen
 Solution to Kattis Problem Tru
 https://open.kattis.com/problems/tri
 */
import java.util.*;
public class Tri {
    
    public static void main(String[] args) {
        //scanner for reading input
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        //calculate output and print
        if(a+b==c)System.out.println(a+"+"+b+"="+c);
        else if(c+b==a)System.out.println(a+"="+b+"+"+c);
        else if(a*b==c)System.out.println(a+"*"+b+"="+c);
        else if(b*c==a)System.out.println(a+"="+b+"*"+c);
        else if(a-b==c)System.out.println(a+"-"+b+"="+c);
        else if(b-c==a)System.out.println(a+"="+b+"-"+c);
        else if(a/b==c)System.out.println(a+"/"+b+"="+c);
        else if(b/c==a)System.out.println(a+"="+b+"/"+c);
    }
}
