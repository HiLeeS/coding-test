import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static boolean[] used;
    
    
    static void dfs(int depth, int start, List<Integer> list){
        if(depth == M){
            for(int num : list){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i = start; i < N; i++){
            if(used[i]) continue;
            used[i] = true;
            
            //if(!list.isEmpty() && list.get(list.size()-1) > arr[i]) continue;
            list.add(arr[i]);
            dfs(depth+1, i+1, list);
            
            used[i] = false;
            list.remove(list.size()-1);
            
        }
        
        
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i]=i+1;
        }
        
        used = new boolean[N]; 
        
        dfs(0, 0, new ArrayList<>());
        
        System.out.print(sb);
        
        
    }
}
