/**
 * @author L-Sternhagen
 Kattis solution to Estimating Area of a Circle
 https://open.kattis.com/problems/estimatingtheareaofacircle
 */
import java.util.*;
public class EstimatingTheAreaOfACircle {
    public static void main(String[] args) {
        //scanner to read input
        Scanner sc = new Scanner(System.in);
        String[] line = {};
        while(sc.hasNextLine()){
            //read input
            line = sc.nextLine().split(" ");
            //true radius of the circle
            double trueRadius = Double.parseDouble(line[0]);
            //the number of hit points total
            double hitPoints = Double.parseDouble(line[1]);
            //number of hit points that landed in the circle
            double circlePoints = Double.parseDouble(line[2]);
            //if we ahve reached the end of input then break
            if(trueRadius==0&&hitPoints==0&&circlePoints==0)break;
            //number of circle hits over total hits
            double cirlceOverHit = circlePoints/hitPoints;
            //rectange are is (radius * 2) squared
            double rectangleArea = (trueRadius * 2) * (trueRadius * 2);
            //elstimated area is circlehit ration * rectangle area
            double estimatedArea = cirlceOverHit * rectangleArea;
            //true area is r^2 * PI
            double trueArea = Math.PI * (trueRadius * trueRadius);
            //print output
            System.out.println(trueArea + " " + estimatedArea);
        }  
        
    }
}
