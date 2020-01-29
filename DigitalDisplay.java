
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author L-Sternhagen
 */
public class DigitalDisplay {
    public static void main(String[] args) {
    
        String[][] zero = {{"+---+"},{"|   |"},{"|   |"},{"+   +"},{"|   |"},{"|   |"},{"+---+"}};
        String[][] one = {{"    +"},{"    |"},{"    |"},{"    +"},{"    |"},{"    |"},{"    +"}};
        String[][] two = {{"+---+"},{"    |"},{"    |"},{"+---+"},{"|    "},{"|    "},{"+---+"}};
      String[][] three = {{"+---+"},{"    |"},{"    |"},{"+---+"},{"    |"},{"    |"},{"+---+"}};
       String[][] four = {{"+   +"},{"|   |"},{"|   |"},{"+---+"},{"    |"},{"    |"},{"    +"}};
       String[][] five = {{"+---+"},{"|    "},{"|    "},{"+---+"},{"    |"},{"    |"},{"+---+"}}; 
        String[][] six = {{"+---+"},{"|    "},{"|    "},{"+---+"},{"|   |"},{"|   |"},{"+---+"}}; 
       String[][] seven = {{"+---+"},{"    |"},{"    |"},{"    +"},{"    |"},{"    |"},{"    +"}}; 
    String[][] eight = {{"+---+"},{"|   |"},{"|   |"},{"+---+"},{"|   |"},{"|   |"},{"+---+"}}; 
     String[][] nine = {{"+---+"},{"|   |"},{"|   |"},{"+---+"},{"    |"},{"    |"},{"+---+"}}; 
     String[][] colon = {{" "},{" "},{"o"},{" "},{"o"},{" "},{" "}}; 
    
     ArrayList<String[][]> numbers = new ArrayList<String[][]>();
     numbers.add(zero); numbers.add(one);numbers.add(two);numbers.add(three); numbers.add(four);numbers.add(five);numbers.add(six);numbers.add(seven);numbers.add(eight);numbers.add(nine);numbers.add(colon);
     
     
     Scanner sc = new Scanner(System.in);
     String line = sc.nextLine();
     
     while(!line.equals("end")){
         String[] output = new String[7];
         for(int f = 0; f < 7; f++)output[f]="";
         for(int i = 0; i < line.length(); i++){
             int pos = 0;
             if(line.charAt(i)==':')pos = 10;
             else pos= Integer.parseInt(line.charAt(i)+"");
             String[][] cur = numbers.get(pos);
             for(int w = 0; w < 7; w++){
                 output[w]+=cur[w][0];
             
             }
             for(int w = 0; w < 7; w++){
                 output[w]+="  ";
             
             }
             
         
         }
        for(int w = 0; w < 7; w++){
            output[w]=output[w].substring(0,29);
            System.out.println(output[w]); 
        }
         System.out.println("");
         System.out.println("");
     
     
     
     
     
         line = sc.nextLine();
     }
        System.out.println("end");
     
    }
    
    
    
    
    
}
