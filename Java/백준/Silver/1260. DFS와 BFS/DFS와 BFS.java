import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        
        boolean[] visited = new boolean[N+1];
        List<List<Integer>> graph = new ArrayList<>(N+1);
        
        for(int i = 0; i<=N;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i<M;i++){
            st = new StringTokenizer(br.readLine());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(e).add(v);
            graph.get(v).add(e);
        }
        
        // 작은 번호부터 방문 보장
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }
        
        dfs(graph, V, visited, sb);
        sb.append("\n");
        
        visited = new boolean[N+1];
        bfs(graph, V, visited, sb);
        
        System.out.print(sb);
    }
    
    static void dfs(List<List<Integer>> graph, int node, boolean[] visited, StringBuilder sb){
        visited[node] = true;
        sb.append(node).append(" ");
        for(int next:graph.get(node)){
            if(!visited[next]){
                dfs(graph, next, visited, sb);
            }
        }
    }
    
    static void bfs(List<List<Integer>> graph, int node, boolean[] visited, StringBuilder sb){
        visited[node] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        sb.append(node).append(" ");
        while(!q.isEmpty()){
            int now = q.poll();
            for(int next:graph.get(now)){
                if(!visited[next]){
                    q.offer(next);
                    visited[next] = true;
                    sb.append(next).append(" ");
                }
            }
        }
    }
}