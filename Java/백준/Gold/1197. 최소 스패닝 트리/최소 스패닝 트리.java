import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        List<Edge> edges = new ArrayList<>();
        for(int i =0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edges.add(new Edge(A,B,C));
        }
        
        Collections.sort(edges);
        parent = new int[V+1];
        for(int i =0; i<V+1; i++){
            parent[i] = i;
        }
        
        int count = 0;
        int result = 0;
        while(count < V-1){
            for(Edge e:edges){
                if(find(e.from) != find(e.to)){
                    union(e.from, e.to);
                    result += e.weight;
                    count += 1;
                }
            }
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


class Edge implements Comparable<Edge> {
    int from, to, weight;

    Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

