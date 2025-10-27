import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nums = br.readLine();
        
        int[] ans = new int[10];
        for(int i = 0; i < nums.length(); i++){
            char c = nums.charAt(i);
            int n = c - '0';
            ans[n]++;
        }
        
        int max = 0;
        ans[6] = ans[6] + ans[9];
        for(int i = 0; i < 9; i++){
            if(i == 6){
                ans[6] = ans[6]%2==0 ? ans[6]/2 : ans[6]/2+1;
            }
            if(ans[i] > max) max = ans[i];
            
        }
        
        System.out.print(max);
        
    }
}
