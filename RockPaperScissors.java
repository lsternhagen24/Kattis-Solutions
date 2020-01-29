import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/**
 * @author L-Sternhagen
 */
public class RockPaperScissors {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int u=0;
        while(true){
            String[] line = br.readLine().split(" ");
            int players = Integer.parseInt(line[0]);
            if(players==0)break;
            if(u!=0)System.out.println();
            Player[] allP = new Player[players];
            for(int g = 0; g <players; g++)allP[g]=new Player();
            int games = Integer.parseInt(line[1]);
            
            int lines = (players * games * (players-1))/2;

            for(int a = 0; a<lines; a++){
                String[] game = br.readLine().split(" ");
                if(game[1].equals("rock")&&game[3].equals("scissors")){allP[Integer.parseInt(game[0])-1].wins++;allP[Integer.parseInt(game[2])-1].loses++; }
                if(game[1].equals("scissors")&&game[3].equals("paper")){allP[Integer.parseInt(game[0])-1].wins++;allP[Integer.parseInt(game[2])-1].loses++; }
                if(game[1].equals("paper")&&game[3].equals("rock")){allP[Integer.parseInt(game[0])-1].wins++;allP[Integer.parseInt(game[2])-1].loses++; }
                if(game[1].equals("rock")&&game[3].equals("paper")){allP[Integer.parseInt(game[0])-1].loses++;allP[Integer.parseInt(game[2])-1].wins++; }
                if(game[1].equals("scissors")&&game[3].equals("rock")){allP[Integer.parseInt(game[0])-1].loses++;allP[Integer.parseInt(game[2])-1].wins++; }
                if(game[1].equals("paper")&&game[3].equals("scissors")){allP[Integer.parseInt(game[0])-1].loses++;allP[Integer.parseInt(game[2])-1].wins++; }
            }
            for(int v = 0; v<players; v++){
                double d = allP[v].wins+allP[v].loses;
                if(d==0)System.out.println("-");
                else{
                    double s = ((double)(allP[v].wins))/d;
                    String g = round(s);
                    System.out.println(g);
                }
            }
            u++;
        }
        
    }
    public static String round(double a){
        double roundOff = Math.round(a * 1000.0) / 1000.0;
        String output = roundOff+"";
        int rr = output.length()-output.indexOf(".");
        if(rr<4){for(int r =rr; r<4; r++)output+="0";}
        return output;
    }
    
    static class Player{
        int wins;
        int loses;
        public Player(){
            wins = 0;
            loses = 0;
        }
    
    }
}
