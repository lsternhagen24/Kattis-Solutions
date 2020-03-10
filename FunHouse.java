
import java.util.Scanner;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem Fun House
 https://open.kattis.com/problems/funhouse
 */
public class FunHouse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int width, length;
        int case_number = 0;
        //loop until we reach end of input
        while(true){
            case_number++;
            width = sc.nextInt();
            length = sc.nextInt();
            sc.nextLine();
            if(width==0&&length==0)break;
            //read in grid
            String[] grid = new String[length];
            for(int r = 0; r < length; r++)grid[r]=sc.nextLine();
            
            //startX, startY
            //direcion left=-1, right=1, up=2, down=0
            int startX=0, startY=0, direction = 0; 
            //find starting * and set the direction
            for(int i = 0; i < length; i++){
                String j = grid[i];
                if(j.contains("*")){
                    if(i==0){direction=0;}
                    else if(i==length-1)direction=2;
                    else if(j.indexOf("*")==0)direction=1;
                    else direction = -1;
                    startX = j.indexOf("*");
                    startY=i;
                    break;
                }
            }
            //set starting point
            Point current_location = new Point(startX, startY);
            //simulate while not on an edge
            while(true){
                //update the location based on current location and direction
                current_location = update(current_location, direction);
                //if on an edge update and grid and break
                if(grid[current_location.y].charAt(current_location.x)=='x'){grid[current_location.y] = grid[current_location.y].substring(0,current_location.x) + "&"+ grid[current_location.y].substring(current_location.x+1);break;}
                //else update the direction if needed
                else {direction = updateDirection(direction, grid[current_location.y].charAt(current_location.x));}
            }
            //print output
            System.out.println("HOUSE " + case_number);
            for(int i=0; i < length; i++)System.out.println(grid[i]);
        }
    }
    //updates direction based on character and old direction
    public static int updateDirection(int direction, char cur){
        if(cur=='.')return direction;
        else if(cur=='\\'){
            if(direction == 0)return 1;
            if(direction == 1)return 0;
            if(direction == 2)return -1;
            if(direction == -1)return 2;
        }
        else if(cur=='/') {
            if(direction == 0)return -1;
            if(direction == 1)return 2;
            if(direction == 2)return 1;
            if(direction == -1)return 0;
        }
        return direction;
    }
    //update the point based on direction and current point
    public static Point update(Point current, int direction){
            if(direction==-1)current.x-=1;
            if(direction==1)current.x+=1;
            if(direction==2)current.y-=1;
            if(direction==0)current.y+=1;
            return current;
        }
    //hold an x and y value
    public static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString(){
            return "Row = " + this.y + " Column = "  + this.x;
        }
    }
}
