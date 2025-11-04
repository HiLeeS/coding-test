import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
        
        int size = c*r;
        
        
        if(size < k){
            System.out.print(0);
            return;
        }
        
        int[][] map = new int[r][c];
        int[] dx = {0, 1, 0, -1}; // 상, 우, 하, 좌 (x방향)
        int[] dy = {1, 0, -1, 0}; // 상, 우, 하, 좌 (y방향)
        
        
        int x = 0;
        int y = 0;
        int cnt = 1; //현재 값
        int dir = 0; //방향
        while(cnt <= k){
            map[y][x] = cnt;
            
            if(cnt == k){
                System.out.print((x+1)+" "+(y+1));
                break;
            }
            
            int nx = x+dx[dir];
            int ny = y+dy[dir];
            
            if(nx < 0 || ny < 0 || nx >= c || ny >= r || map[ny][nx] != 0){
                dir = (dir + 1) % 4; // 시계 방향 전환
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            x = nx;
            y = ny;
            cnt++;
        }
        
    }
}
