
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author L-Sternhagen
 */
public class Godzilla {
    static char[][] grid;
    static Set<Point> gzMarked;
    static int count;
    static int l;
    static int w;
    //static boolean debug = false;
    static final Point[] move = {new Point(0,-1), new Point(1,0), new Point(0,1), new Point(-1,0)};
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int ww = 0; ww < t; ww++){

            Set<Point> marked = new HashSet<Point>();
            gzMarked = new HashSet<Point>();
            String[] gg = br.readLine().split(" ");
            l = Integer.parseInt(gg[0]);
            w = Integer.parseInt(gg[1]);

            grid = new char[w][l];
            Point godzilla = new Point(0,0);
            ArrayList<Point> currentRobots = new ArrayList<Point>();
            for(int e = 0; e < w; e++){
                char[] line = br.readLine().toCharArray();
                for(int s = 0; s < line.length; s++){
                    if(line[s]=='G'){godzilla = new Point(s,e);line[s] = '.';}
                    else {
                        if(line[s]=='M'){
                            Point mecha = new Point(s,e);
                            currentRobots.add(mecha);
                            marked.add(mecha);
                        }
                    }
                }
                grid[e] = line;
            }
            gzMarked.add(godzilla);
            count = 0;
            

            while(true){
                Point old = godzilla;
                godzilla = updateGodzilla(godzilla);
               
                gzMarked.add(godzilla);      
                ArrayList<Point> updates= new ArrayList<Point>();
                for(Point a: currentRobots){
                    for(Point b: move){
                        Point c = addPoint(a,b);
                        if(c.y >= grid.length || c.x >= grid[0].length || c.y < 0 || c.x < 0)continue;
                        if(!marked.contains(c) && grid[c.y][c.x]=='.'){
                            updates.add(c);marked.add(c);
                            grid[c.y][c.x]='M';
                        } 
                    }
                }
                currentRobots = updates;
                 boolean found = false;
                for(int q = godzilla.y; q < w; q++){
                    if(grid[q][godzilla.x]=='R')break;
                    else if(grid[q][godzilla.x]=='M')found=true;
                }
                for(int q = godzilla.y; q >=0; q--){
                    if(grid[q][godzilla.x]=='R')break;
                    else if(grid[q][godzilla.x]=='M')found=true;
                }
                for(int y = godzilla.x; y < l; y++){
                    if(grid[godzilla.y][y]=='R')break;
                    else if(grid[godzilla.y][y] == 'M')found=true;
                }
                 for(int y = godzilla.x; y >=0; y--){
                    if(grid[godzilla.y][y]=='R')break;
                    else if(grid[godzilla.y][y] == 'M')found=true;
                }
                if(old.equals(godzilla)||found)break;
            }
           
            System.out.println(count);
        }
        
    }
    public static void printGrid(Point g){

        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){if(r==g.y && c==g.x)System.out.print("G "); else System.out.print(grid[r][c] + " ");}
            System.out.println("");
        }
        System.out.println("-----------------");
    
    }
    public static void printByGZilla(Point g){
        int r = Math.max(0, g.y-10);
        int r2 = Math.min(grid.length-1, g.y+10);
        int c = Math.max(0,g.x-10);
        int c2 = Math.min(grid[0].length-1, g.x+10);
        for(int ss = r; ss <= r2; ss++){
            for(int s2 = c; s2 <= c2; s2++){if(ss==g.y && s2==g.x)System.out.print("G "); else System.out.print(grid[ss][s2] + " ");}
            System.out.println("");
        }
        System.out.println("-----------------");
    }
    
    static Point updateGodzilla(Point cur){
        for(Point i: move){
            Point newP = addPoint(i,cur);
            if(gzMarked.contains(newP)){continue;}
            if(newP.y >= grid.length || newP.x >= grid[0].length || newP.y < 0 || newP.x < 0)continue;
            if(grid[newP.y][newP.x]=='R'){
                grid[newP.y][newP.x] = '.';
                count++;
                return newP;
            } 
        }
        for(Point i: move){
            Point newP = addPoint(i,cur);
            if(gzMarked.contains(newP))continue;
            if(newP.x >= grid[0].length || newP.y >= grid.length || newP.y < 0 || newP.x < 0)continue;
            grid[newP.y][newP.x] = '.';
            return newP;
        }
        
        return cur;
    }
    public static Point addPoint(Point a, Point b){
        Point c = new Point(a.x+b.x, a.y+b.y);
        return c;
    }
    static class TreePoint implements Comparable<TreePoint>{
        int index; 
        char type;
        public TreePoint(int index, char type){
            this.index = index; 
            this.type = type;
        }
        @Override
        public boolean equals(Object o){
            TreePoint a = (TreePoint)o;
            return this.index==a.index;
        }
        @Override
        public int hashCode(){
            String f = index + " : " + type;
            return f.hashCode();
        }
        @Override 
        public int compareTo(TreePoint o){
            return this.index-o.index;
        }
        @Override
        public String toString(){
            return index + " "+ type;
        }
    }
    public static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o){
            Point a = (Point)o;
            return this.x==a.x && this.y==a.y;
        }
        @Override
        public int hashCode(){
            String f = x + " , " + y;
            return f.hashCode();
        }
        @Override
        public String toString(){
            return "y = " + this.y + " x = " + this.x;
        }
        
    }
}
