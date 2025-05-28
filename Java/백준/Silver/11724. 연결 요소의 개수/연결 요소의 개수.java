import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 인접 리스트 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1; // 0-based
            int v = Integer.parseInt(st.nextToken()) - 1; // 0-based

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 방문 체크
        boolean[] visited = new boolean[N];
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i);
                count++;
            }
        }

        System.out.print(count);
    }

    static void dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(graph, visited, next);
            }
        }
    }
}
