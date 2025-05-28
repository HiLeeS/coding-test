import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] string = s.split("-");
        
        int result = sumNum(string[0]);
        
        for(int i=1; i<string.length; i++){
            result -= sumNum(string[i]);
        }
        System.out.print(result);
    }
    
    private static int sumNum(String s){
        String[] string = s.split("\\+");
        int sum = 0;
        for(String num:string){
            sum += Integer.parseInt(num);
        }
        return sum;
        
    }
}
