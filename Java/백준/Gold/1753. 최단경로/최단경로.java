import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        final int INF = Integer.MAX_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        
        List<List<int[]>> A = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            A.add(new ArrayList<>());
        }
        
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            A.get(u).add(new int[]{v, w});
        }
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.offer(new int[]{start, 0});
        
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int node = now[0], cost = now[1];
            
            if(dist[node] < cost) continue;
            
            for(int[] edge:A.get(node)){
                int next = edge[0], nextCost = cost+edge[1];
                if(dist[next] > nextCost){
                    dist[next] = nextCost;
                    pq.offer(new int[]{next, nextCost});
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<V+1;i++){
            if(dist[i] == INF) sb.append("INF\n");
            else sb.append(dist[i]).append("\n");
        }
        System.out.print(sb);
    }
}