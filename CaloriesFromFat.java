
import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class CaloriesFromFat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        while (true) {
            double sum = 0;
            double fat = 0;

            while (line.equals("-") == false) {
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
                for (int i = 0; i < 5; i++) {
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
            System.out.println(Math.round(((fat / sum) * 100)) + "%");
            line = sc.nextLine();
            if (line.equals("-")) {
                break;
            }
        }
    }

}
