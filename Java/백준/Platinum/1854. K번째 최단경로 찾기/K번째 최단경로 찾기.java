import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args)throws IOException {
        
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        List<List<int[]>> A = new ArrayList<>();
        for(int i =0;i<n+1;i++){
            A.add(new ArrayList<>());
        }
        
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            A.get(v).add(new int[]{u, w});
        }
        
        PriorityQueue<Integer>[] dist = new PriorityQueue[n + 1];
        for (int i = 0; i <= n; i++) {
            dist[i] = new PriorityQueue<>(Comparator.reverseOrder()); // 최대 힙
        }
            
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        
        pq.offer(new int[]{1, 0});
        dist[1].offer(0);
        
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int node = now[0];
            int cost = now[1];
            
            for(int[] edge:A.get(node)){
                int next = edge[0];
                int nextCost = edge[1] + cost;
                
                if(dist[next].size() < k){
                    dist[next].offer(nextCost);
                    pq.offer(new int[]{next, nextCost});
                }
                else if(dist[next].peek() > nextCost){
                    dist[next].poll();
                    dist[next].offer(nextCost);
                    pq.offer(new int[]{next, nextCost});
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i =1; i<n+1; i++){
            if(dist[i].size() < k) sb.append("-1\n");
            else sb.append(dist[i].peek()).append("\n");
        }
        
        System.out.print(sb);
    }
}
