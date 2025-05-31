import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[2]));
        for(int i =0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{A,B,C});
        }
        
        parent = new int[V+1];
        for(int i =0; i<V+1; i++){
            parent[i] = i;
        }
        
        int result = 0;
        int count = 0;
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int a = now[0], b=now[1], c=now[2];
            if(find(a) != find(b)){
                union(a, b);
                result += c;
                count += 1;
            }
            if(count == V-1) break;
        }
        
        System.out.print(result);
        
    }
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }

}


