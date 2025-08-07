import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static boolean[] visited;
    static List<List<long[]>> map;
    static long[] value;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        visited = new boolean[N+1];
        value = new long[N+1];
        
        map = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            map.add(new ArrayList<>());
        }
        
        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            long d = Integer.parseInt(st.nextToken());
                
            map.get(x).add(new long[]{y, d});
            map.get(y).add(new long[]{x, d});
                
        }
        
        dfs(1);

        long max = Arrays.stream(value).max().getAsLong();
        System.out.print(max);
        
    }
    
    static void dfs(int start){
        visited[start] = true;
        
        for(long[] next : map.get(start)){
            int next_node = (int)next[0];
            long next_dist = next[1];
            if (!visited[next_node]) {
                value[next_node] = value[start] + next_dist;
                dfs(next_node);
            }
        }
        
    }
    
}
