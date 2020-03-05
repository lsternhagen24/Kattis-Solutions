
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author L-Sternhagen
 Solution to kattis problem Digital Display
 https://open.kattis.com/problems/display
 */
public class DigitalDisplay {
    public static void main(String[] args) {
    //hold each number as a 2 dimensional string array
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

     //add all individual numbers to numbers arraylist.   
     ArrayList<String[][]> numbers = new ArrayList<String[][]>();
     numbers.add(zero); numbers.add(one);numbers.add(two);numbers.add(three); numbers.add(four);numbers.add(five);numbers.add(six);numbers.add(seven);numbers.add(eight);numbers.add(nine);numbers.add(colon);
    //read input
     Scanner sc = new Scanner(System.in);
     String line = sc.nextLine();
     //loop until at end of input
     while(!line.equals("end")){
         String[] output = new String[7];
         //initialize output to be empty string
         for(int f = 0; f < 7; f++)output[f]="";
         //read numbers and convert them
         for(int i = 0; i < line.length(); i++){
             int pos = 0;
             //if we are at a colon them move to 10 position
             if(line.charAt(i)==':')pos = 10;
             else pos= Integer.parseInt(line.charAt(i)+"");
             String[][] cur = numbers.get(pos);
             for(int w = 0; w < 7; w++){
                 output[w]+=cur[w][0];
             }
             //add spaces
             for(int w = 0; w < 7; w++){
                 output[w]+="  ";
             }
         }
         //add each layer of each number and print
        for(int w = 0; w < 7; w++){
            output[w]=output[w].substring(0,29);
            System.out.println(output[w]); 
        }
         //print ending blank lines
         System.out.println("");
         System.out.println("");  
         //read in next line
         line = sc.nextLine();
     }
        //print ending output
        System.out.println("end");
     
    }
}
