import java.io.*;
import java.util.*;

public class Main {
    static int M;
    static int N;
    static int[][] box;
    static int[][] dist;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        box = new int[N][M];
        dist = new int[N][M];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    q.offer(new int[]{i, j}); // 모든 익은 토마토를 한 번에 큐에
                }
                if (box[i][j] == 0) {
                    dist[i][j] = -1; // 아직 안 익은 칸만 -1로 표시 (미방문)
                }
            }
        }
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (box[nx][ny] == -1) continue;      // 빈 칸(없음)
                if (dist[nx][ny] != -1) continue;     // 이미 익었거나 방문됨
                dist[nx][ny] = dist[x][y] + 1;        // 하루 더 걸림
                box[nx][ny] = 1;                      // 익힘
                q.offer(new int[]{nx, ny});
            }
        }
        
        
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dist[i][j] == -1 && box[i][j] == 0) { // 아직 안 익은 토마토 존재
                    System.out.println(-1);
                    return;
                }
                ans = Math.max(ans, dist[i][j]); // 최대 일수
            }
        }
        System.out.println(ans);
    }
}
