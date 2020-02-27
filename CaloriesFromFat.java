
import java.util.Scanner;

/**
 * @author lucas
 Solution to kattis problem calories from fat.
 https://open.kattis.com/problems/calories
 */
public class CaloriesFromFat {

    public static void main(String[] args) {
        //read input
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        while (true) {
            double sum = 0;
            double fat = 0;
            //while there is more input
            while (line.equals("-") == false) {
                //set all member variables
                String[] array = line.split(" ");
                String faty = array[0];
                String protein = array[1];
                String sugar = array[2];
                String startch = array[3];
                String alcohol = array[4];
                double totalPercent = 0;
                double fatPercent = 0;
                double newSum = 0;
                double fatInItem = Double.parseDouble(faty.substring(0, faty.length() - 1));
                double proteins = Double.parseDouble(protein.substring(0, protein.length() - 1));
                double sugars = Double.parseDouble(sugar.substring(0, sugar.length() - 1));
                double starches = Double.parseDouble(startch.substring(0, startch.length() - 1));
                double alcohols = Double.parseDouble(alcohol.substring(0, alcohol.length() - 1));
                String[] types = {faty, protein, sugar, startch, alcohol};
                //loop through each type
                for (int i = 0; i < 5; i++) {
                    //decision based on which line type it is
                    if (types[i].charAt(types[i].length() - 1) == 'g') {
                        if (i == 0) {
                            fatInItem *= 9;
                        }
                        newSum += (i == 0) ? fatInItem : (i == 1) ? proteins * 4 : (i == 2) ? sugars * 4 : (i == 3) ? starches * 4 : (i == 4) ? alcohols * 7 : 0;
                    } else if (types[i].charAt(types[i].length() - 1) == 'C') {
                        newSum += Integer.parseInt(types[i].substring(0, types[i].length() - 1));
                    } else if (types[i].charAt(types[i].length() - 1) == '%') {
                        if (i == 0) {
                            fatPercent += fatInItem;
                        }
                        totalPercent += Integer.parseInt(types[i].substring(0, types[i].length() - 1));
                    }

                }
                newSum = (totalPercent > 0) ? (newSum / (1 - totalPercent * .01)) : newSum;
                sum += newSum; 
                fatInItem = (fatPercent > 0) ? newSum * (fatPercent * .01) : fatInItem;
                fat += fatInItem; 
                line = sc.nextLine();
            }
            //round the fat to two decimal places
            System.out.println(Math.round(((fat / sum) * 100)) + "%");
            line = sc.nextLine();
            //break if we are at the end of the input
            if (line.equals("-")) {
                break;
            }
        }
    }

}
