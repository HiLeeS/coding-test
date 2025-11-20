import java.io.*;
import java.util.*;

public class Main {
    
    static int M;
    static int N;
    static int max = 0;
    static int[] arr;
    
    static void dfs(int depth, int start, int score){
        if (depth == 3) {
            if (score <= M) max = Math.max(max, score);
            return;
        }
        
        
        if(score > M) return;
        
        for(int i = start; i < N; i++){
            if(score + arr[i] > M) continue;
            dfs(depth+1, i+1, score+arr[i]);
        }
        
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(0, 0, 0);
        
        System.out.print(max);
    }
}
