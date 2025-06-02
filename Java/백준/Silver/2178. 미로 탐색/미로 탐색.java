import java.io.*;
import java.util.*;
public class Main {
    static int[][] graph;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static int[][] visited;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        graph = new int[N][M];
        visited = new int[N][M];
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                graph[i][j] = line.charAt(j)-'0';
            }
        }
        
        bfs(0, 0);
        System.out.print(visited[N-1][M-1]);
        
    }
    
    static void bfs(int a, int b){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{a, b});
        visited[a][b] = 1;
        
        while(!q.isEmpty()){
            int[] c = q.poll();
            int x = c[0];
            int y = c[1];
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                    if(visited[nx][ny] == 0 && graph[nx][ny] == 1){
                        visited[nx][ny] = visited[x][y] + 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
    
}
