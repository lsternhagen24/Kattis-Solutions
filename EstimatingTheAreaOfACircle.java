/**
 * @author L-Sternhagen
 */
import java.util.*;
public class EstimatingTheAreaOfACircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = {};
        while(sc.hasNextLine()){
            line = sc.nextLine().split(" ");
            
           
            
            double trueRadius = Double.parseDouble(line[0]);
            double hitPoints = Double.parseDouble(line[1]);
            double circlePoints = Double.parseDouble(line[2]);
            
            if(trueRadius==0&&hitPoints==0&&circlePoints==0)break;
            
            double cirlceOverHit = circlePoints/hitPoints;
            double rectangleArea = (trueRadius * 2) * (trueRadius * 2);
            
            double estimatedArea = cirlceOverHit * rectangleArea;
            
            double trueArea = Math.PI * (trueRadius * trueRadius);
            
            System.out.println(trueArea + " " + estimatedArea);
        }  
        
    }
}
