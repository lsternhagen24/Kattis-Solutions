import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author L-Sternhagen
 Solution to Kattis Problem Foosball Dynasty
 https://open.kattis.com/problems/foosball
 */
public class FoosballDynasty {
    static ArrayList<Dynasty> al;
    static Board board;
    static Queue<String> upnext;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String [] names = sc.nextLine().split(" ");
        //queue to hold upnext order
        upnext = new LinkedList<String>();
        for(String i: names)upnext.add(i);
        //update the board to the first four players in queue
        board = new Board(upnext.poll(), upnext.poll(), upnext.poll(), upnext.poll());
        //list of all dynastys
        al = new ArrayList<Dynasty>();
        String input = sc.nextLine();
        //update board for each character
        for(int q = 0; q < input.length(); q++){updateBoard(input.charAt(q));}
        //find winners
        ArrayList<String> winners = new ArrayList<String>();
        int max = Integer.MIN_VALUE;
        //find the list of all max dynastys in order
        for(Dynasty h: al){
            if(h.wins>max){
                max = h.wins;
                winners.clear();
                winners.add(h.name);
            } else if(h.wins==max){
                winners.add(h.name);
            }
        }
        //print all max dynastys in order
        for(String e: winners)System.out.println(e);   
    }
    //update the board for a new winner
    public static void updateBoard(char winner){
        String winners = board.dynasty=='n' && winner=='B' ? board.bo + " " + board.bd : board.dynasty=='n' ? board.wo + " " + board.wd :  winner == 'B' ? board.bd + " " + board.bo : board.wd + " " + board.wo;
        if(board.dynasty!=winner){
            board.dynasty=winner;
            al.add(new Dynasty(winners, 1));
        }else {
            al.get(al.size()-1).wins++;
        }
        swapBoard(winner);
    }
    //swaps the board for a new winner
    public static void swapBoard(char winner){
        if(winner=='B'){
            String temp = board.bd; board.bd = board.bo; board.bo = temp;
            upnext.add(board.wd);
            board.wd = board.wo;
            board.wo = upnext.poll();
        }
        else {
            String temp = board.wd; board.wd = board.wo; board.wo = temp;
            upnext.add(board.bd);
            board.bd = board.bo;
            board.bo = upnext.poll();
        }
    }
    //holds the information about who is winning a dynasty and for how long
    public static class Dynasty{
        int wins;
        String name;
        public Dynasty(String name, int wins){
            this.name = name;
            this.wins = wins;
        }
    }
    //holds information about the board such as who is on offense, defenece, and for what team
    public static class Board{
        String bo;
        String bd;
        String wo;
        String wd;
        char dynasty;
        int winners = 0;
        //constructor
        public Board(String wo, String bo, String wd, String bd){
            this.bo = bo;
            this. bd = bd;
            this. wo = wo;
            this.wd = wd;
            this.dynasty = 'n';
        }
        //toString for debugging
        @Override
        public String toString(){
            return "Black O: " + bo + " Black d: " + bd + "\nWhite O: " + wo + " White d: " + wd + "\n";
        }
    }
}
