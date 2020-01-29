
import java.awt.Point;
import java.util.Scanner;

/**
 * @author L-Sternhagen
 */
public class GlitchBot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //read in target endpoint
        Point target = new Point(sc.nextInt(), sc.nextInt());
        int n = sc.nextInt();
        sc.nextLine();
        //hold array of instructions
        String[] instructions = new String[n];
        //read instructions into array
        for(int i = 0; i < n; i++)instructions[i] = sc.nextLine();
        //three possible directions
        String[] options = {"Forward","Right","Left"};
        String changeTo ="";
        int indexChanged = -1;
        
        outerloop:
        for(int i = 0; i < n; i++){
            String cur = instructions[i];
            for(String j: options){
                //don't try to change to same direction
                if(j.equals(cur))continue;
                instructions[i] = j;
                //in changing the direction and simulating with the new instruction list ends at target break
                if(simulate(instructions).equals(target)){
                    changeTo = j; 
                    indexChanged = i+1;
                    break outerloop;
                }
            }
            //set instructions back to original instruction
            instructions[i] = cur;
        }
        System.out.println(indexChanged + " " + changeTo);
        
    }
    //given a set of instructions, simulates the instructions and returns the point the robot finishes on
    public static Point simulate(String[] instructions){
        //left = down = 0, left = 1, up = 2, right = 3
        int dir = 2;
        Point cur = new Point(0,0);
        for(String i: instructions){
            //if forward, update location based on current direction
            if(i.equals("Forward")){
                if(dir==2)cur.y+=1;
                else if(dir==0)cur.y-=1;
                else if(dir==1)cur.x-=1;
                else cur.x+=1;
            }
            //else update direction based on current direction and right or left
            else if(i.equals("Right"))dir = (dir+1)%4;
            else {dir = (dir+3)%4;}
            
        }
        return cur;
    }
}
