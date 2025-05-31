import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        long [] dist = new long[N+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;
        
        List<Edge> edges = new ArrayList<>();
        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            edges.add(new Edge(from, to, weight));
        }
        
        for(int i = 1; i < N; i++){
            for(Edge e:edges){
                if(dist[e.from] != Long.MAX_VALUE && dist[e.to] > dist[e.from] + e.weight){
                    dist[e.to] = dist[e.from] + e.weight;
                }
            }
        }
        
        boolean minus = false;
        for(Edge e:edges){
            if(dist[e.from] != Long.MAX_VALUE && dist[e.to] > dist[e.from] + e.weight){
                minus = true;
                break;
            }
        }
        
        
        if (minus) {
            System.out.print(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i < N + 1; i++) {
                if (dist[i] != Long.MAX_VALUE) {
                    sb.append(dist[i]).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
            System.out.print(sb);
        }
    }
}

class Edge{
    int from;
    int to;
    int weight;
    
    public Edge(int from, int to, int weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
    
}
