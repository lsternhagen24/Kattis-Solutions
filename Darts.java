/**
 * @author L-Sternhagen
 Solution to kattis problem Darts
 https://open.kattis.com/problems/dartscores
 */

import java.util.*;
public class Darts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //read number of testcases and loop through them
        int testCases = sc.nextInt(); sc.nextLine();
        for(int zz = 0; zz < testCases; zz++){
            //find number of throws and set initial score to be 0
            int thro = sc.nextInt(); sc.nextLine();
            int score = 0;
            for(int qq = 0; qq < thro; qq++){
                // read the x y coordinates of the throw
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                sc.nextLine();
                //get the length from the center
                double length = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
                //increment score by which circle the dart landed in.
                if(length <= 20){score+=10;}
                else if(length <=40){score+=9;}
                else if(length <=60){score+=8;}
                else if(length <=80){score+=7;}
                else if(length <=100){score+=6;}
                else if(length <=120){score+=5;}
                else if(length <=140){score+=4;}
                else if(length <=160){score+=3;}
                else if(length <=180){score+=2;}
                else if(length <=200){score+=1;}
                
            }
            //print output
            System.out.println(score);  
        }
    }
}
