
import java.awt.Point;
import java.util.*;
/*
Solution to Kattis Problem Getting Gold
https://open.kattis.com/problems/gold
*/
public class GettingGold {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt(); sc.nextLine();
        char[][] grid = new char[h][w];
        Point start = new Point(0,0);
        //read input and set start point
        for(int q = 0; q < h; q++){
            grid[q] = sc.nextLine().toCharArray();
            //set start point
            for(int i = 0; i < w; i++)
                if(grid[q][i]=='P'){start.x=i;start.y=q;}
        }
        //set of points we have already visited
        Set<Point> marked = new HashSet<Point>();
        //queue for our bfs
        Queue<Point> q = new LinkedList<Point>();
        q.add(start);
        //amount of gold we have reached
        int gold = 0;
        //directions can move
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        //bfs until there are no more locations we can visit
        while(!q.isEmpty()){
            //get current location
            Point cur = q.poll();
            if(marked.contains(cur))continue;
            //add to marked
            marked.add(cur);
            //if at gold update gold else if trap or wall continue
            char c = grid[cur.y][cur.x];
            if(c=='G')gold++;
            else if(c=='T'||c=='#')continue;
            
            //check if trap nearby, if there is continue
            boolean trap = false;
            for(int i = 0; i < 4; i++){
                Point move = new Point(cur.x + directions[i][0], cur.y + directions[i][1]);
                if(grid[move.y][move.x]=='T')trap = true;
            }
            if(trap)continue;
            //move in all four directions, if not marked and inside grid then add to queue
            for(int i = 0; i < 4; i++){
                Point move = new Point(cur.x + directions[i][0], cur.y + directions[i][1]);
                if(move.x >= w || move.x < 0 || move.y >= h || move.y < 0 || marked.contains(move))continue;
                q.add(move); 
            }
        }
        //print output
        System.out.println(gold);
    }
}
