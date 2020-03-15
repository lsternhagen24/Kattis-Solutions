import java.util.*;
/*
Solution to Kattis Problem Treasure Hunt
https://open.kattis.com/problems/treasurehunt
*/
public class TreasureHunt {
    public static void main(String[] args) {
        //scanner for reading input
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        sc.nextLine();
        //character map
        char[][] map = new char[r][c];
        //read in the map
        for(int a = 0; a < r; a++){
            String line = sc.nextLine().trim();
            for(int b = 0; b < line.length(); b++)map[a][b] = line.charAt(b);
        }
        int locX = 0; 
        int locY = 0;
        //set of locations visited
        Set<String> locationsVisited = new HashSet<String>();
        
        int count = 0;
        String output = "";
        //loop until we have gotten to the end or get lost
        while(true){
            //if we already have been to this location return lost
            if(locationsVisited.contains(""+locY+","+locX)){output = "Lost"; break;}
            locationsVisited.add(""+locY+","+locX);
            int cX = locX, cY = locY;
            //follow the map location
            switch(map[cY][cX]){
                case 'N': locY--;break;
                case 'S': locY++; break;
                case 'W': locX--; break;
                case 'E': locX++; break;
                case 'T': output = count+"";break; 
                default: break;
            }
            //increment count
            count++;
            if(locY>=r||locX>=c||locY<0||locX<0)output="Out"; 
            if(!output.equals(""))break;
        }
        //print output
        System.out.println(output);        
    }
}
