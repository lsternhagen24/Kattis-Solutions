/**
 * @author L-Sternhagen
 */

import java.util.*;
public class Darts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int testCases = sc.nextInt(); sc.nextLine();
        for(int zz = 0; zz < testCases; zz++){
            
            int thro = sc.nextInt(); sc.nextLine();
            int score = 0;
            for(int qq = 0; qq < thro; qq++){
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                sc.nextLine();
                
                double length = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
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
            System.out.println(score);
        
        
            
        }
        
        
    }
}
