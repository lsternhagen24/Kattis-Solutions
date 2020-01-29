
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 * @author L-Sternhagen
 */
public class ExactlyElectrical {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int startX = sc.nextInt();
        int startY = sc.nextInt();
        sc.nextLine();
        
        int endX = sc.nextInt();
        int endY = sc.nextInt();
        sc.nextLine();
        
        int charge = sc.nextInt(); sc.nextLine();
        
        
        int xDiff = Math.abs(startX-endX);
        int yDiff = Math.abs(startY-endY);
        
        int distance = xDiff+yDiff;
        
        if(distance>charge)System.out.println("N");
        else if(distance==charge)System.out.println("Y");
        else{
            if(distance%2==0&&charge%2==0)System.out.println("Y");
            else if(distance%2!=0&&charge%2!=0)System.out.println("Y");
            else System.out.println("N");
        }
        
        
        
      /*  Set<String> statesVisited = new HashSet<String>();
        Queue<State> a = new LinkedList<State>();
        a.add(new State(startX,startY,charge));
        boolean found = false;
        while(!a.isEmpty()){
            State current = a.poll();
            if(current.x==endX&&current.y==endY&&current.charge==0){found=true; break;}
            State left = new State(current.x-1, current.y, current.charge-1);
            if(!statesVisited.contains(left.getState())&&left.charge>0){a.add(left); statesVisited.add(left.getState());}
            State right = new State(current.x+1,current.y,current.charge-1);
            if(!statesVisited.contains(right.getState())&&right.charge>0){a.add(right); statesVisited.add(right.getState());}
            State up = new State(current.x,current.y+1,current.charge-1);
            if(!statesVisited.contains(up.getState())&&up.charge>0){a.add(up); statesVisited.add(up.getState());}
            State down = new State(current.x,current.y-1,current.charge-1);
            if(!statesVisited.contains(down.getState())&&down.charge>0){a.add(down); statesVisited.add(down.getState());}
        }
        if(found){System.out.println("Y");}
        else System.out.println("N");
        
        */
    }
    static class State {
        int x; 
        int y;
        int charge;
        
        public State(int x, int y, int charge){
            this.x = x;
            this.y = y;
            this.charge = charge;
        
        }
        
        public String getState(){
            return x + "_" + y + "_" + charge;
        
        }
        
    
    }
}
