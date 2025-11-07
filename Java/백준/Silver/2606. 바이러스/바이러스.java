import java.io.*;
import java.util.*;

public class Main {
    
    static boolean[] visited;
    static int[] nodes;
    static List<List<Integer>> map;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());    //컴퓨터 수
        int T = Integer.parseInt(br.readLine());    //연결 수
        
        visited = new boolean[N+1];
        map = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            map.add(new ArrayList<>());
        }
        
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            
            map.get(n1).add(n2);
            map.get(n2).add(n1);
        }
        
        bfs(1);
        
        System.out.print(count);
    }
    
    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int next:map.get(now)){
                if(!visited[next]){
                    count++;
                    q.offer(next);
                    visited[next] = true;
                }
            }
            
            
        }
        
    }
}
