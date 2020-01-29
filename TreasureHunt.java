import java.util.*;

public class TreasureHunt {
    public static void main(String[] args) {
        
        
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        sc.nextLine();
        
        char[][] map = new char[r][c];
        
        for(int a = 0; a < r; a++){
            String line = sc.nextLine().trim();
            for(int b = 0; b < line.length(); b++)map[a][b] = line.charAt(b);
        }
        
        
        int locX = 0; 
        int locY = 0;
        
        Set<String> locationsVisited = new HashSet<String>();
        
        int count = 0;
        String output = "";
        while(true){
            if(locationsVisited.contains(""+locY+","+locX)){output = "Lost"; break;}
            locationsVisited.add(""+locY+","+locX);
            int cX = locX, cY = locY;
            switch(map[cY][cX]){
                case 'N': locY--;break;
                case 'S': locY++; break;
                case 'W': locX--; break;
                case 'E': locX++; break;
                case 'T': output = count+"";break; 
                default: break;
            }
            count++;
            if(locY>=r||locX>=c||locY<0||locX<0)output="Out"; 
            if(!output.equals(""))break;
        
        }
        System.out.println(output);
        

        
        
        
        
        
        
    }
}