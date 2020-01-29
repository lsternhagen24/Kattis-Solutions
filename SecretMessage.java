
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author L-Sternhagen
 */
public class SecretMessage {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for(int i = 0; i < num; i++){
            String precode = br.readLine();
            int length = precode.length();
            int square2 = findSquare(length);
            //System.out.println(square2);
            int square = (int)(Math.sqrt((double)square2));
            for(int j = length; j < square2; j++)precode+="*";
            //System.out.println(precode);
            char[][] a = new char[square][square]; int pos = 0;
            for(int k = 0; k < square;k++){
                for(int l = 0; l < square; l++){
                    a[k][l] = precode.charAt(pos++);
                }
            }
            String output = "";
            for(int row = 0; row <square; row++){
                for(int column = square-1; column >=0; column--){
                    output+=a[column][row];
                }
            }
            System.out.println(output.replaceAll("\\*",""));
        }
    }
   public static int findSquare(int length){
       double cur = length+0;
       while(Math.sqrt(cur) %1 !=0)cur++;
     return (int)cur;
   }
}
