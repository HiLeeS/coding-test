import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String N = br.readLine();
        
        int target = Integer.parseInt(N);
        int len = N.length();
        
        int ans = 0;
        
        int start = target - 9 * len;
        if(start < 1) start = 1;

        for(int i = start; i < target; i++){
            int sum = i;
            int tmp = i;

            while(tmp > 0){
                sum += tmp % 10;
                tmp /= 10;
            }

            if(sum == target){
                ans = i;
                break;
            }
        }
        System.out.print(ans);
        
    }
}
