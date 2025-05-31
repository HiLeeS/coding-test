import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    //도시
        int M = Integer.parseInt(br.readLine());    //버스
        
        List<List<int[]>> A = new ArrayList<>();
        for(int i = 0; i<=N;i++){
            A.add(new ArrayList<>());
        }
        
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            A.get(v).add(new int[]{u, w});
        }
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        pq.offer(new int[]{start, 0});
        
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int node = now[0], cost = now[1];
            
            if(dist[node] < cost){
                continue;
            }
            
            for(int[] edge:A.get(node)){
                int next = edge[0], nextCost = cost + edge[1];
                if(dist[next] > nextCost){
                    dist[next] = nextCost;
                    pq.offer(new int[]{next, nextCost});
                }
            }
        }
        
        System.out.print(dist[end]);
        
        
    }
}
