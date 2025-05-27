import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        /*
        -1000000 ~ 1000000
        기준점 0 = index 1000000으로 생각
        */
        
        boolean[] arr = new boolean[2000001];
        
        int n = Integer.parseInt(br.readLine());
        
        
        for(int i = 0; i < n; i++){
            arr[Integer.parseInt(br.readLine()) + 1000000] = true;
        }
        
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i]){
                sb.append((i-1000000)).append("\n");
            }
        }
        
        System.out.print(sb);
        
    }
}
