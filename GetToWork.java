import java.util.*;
public class GetToWork {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //test case number and loop
        int t = sc.nextInt();
        for(int ww=0; ww<t; ww++){
            //n = number of towns, f = end town, e = number of employees
            int n = sc.nextInt();
            int f = sc.nextInt();
            int e = sc.nextInt();
            //array of arraylist, each arraylist holds all employees in each town
            ArrayList<Integer>[] towns = new ArrayList[n];
            //array of employee count for each town
            int[] eCount = new int[n];
            //initialize each arraylist
            for(int i = 0; i < n; i++)towns[i] = new ArrayList<Integer>();
            //read in all employees, keep track of how many employees in each town, and add number passengers to arraylist for town
            for(int i = 0; i < e; i++){
                int h = sc.nextInt();
                int p = sc.nextInt();
                //number of passengers in each town
                towns[h-1].add(p);
                //number of employees in each town
                eCount[h-1]++;
                
            }
            //sort passengers by descending order in each town
            for(int i = 0; i < n; i++){Collections.sort(towns[i],Collections.reverseOrder());}
            String output = "Case #" + (ww+1) + ": ";
            boolean impossible = false;
            for(int i = 0; i < n; i++){
                //if already at end town no cars needed
                if(i==f-1){output+="0 ";continue;}
                int cars = 0;
                int iter = 0;
                //while there are more employees left, use largest car available at that town
                while(eCount[i]>0){
                    //if no more cars left, then set impossible flag and break
                    if(iter>=towns[i].size()){impossible = true;break;}
                    //subtract number of employees left by amount current car can take
                    eCount[i]-=towns[i].get(iter++);
                    //increment car total
                    cars++;
                }
                output+=cars + " ";
                if(impossible){output = "Case #" + (ww+1) + ": IMPOSSIBLE";break;}
            }
            System.out.println(output.trim());
        }
        
    }
}
