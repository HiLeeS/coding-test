import java.io.*;
import java.util.*;

public class Main {
    static int w, h;
    static boolean[][] visited;
    static List<List<Integer>> map;
    static int count;
    static int[] dx = new int[]{0, 0, -1, 1, 1, 1, -1, -1};
    static int[] dy = new int[]{1, -1, 0, 0, 1, -1, 1, -1};
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        while(true){
            st = new StringTokenizer(br.readLine());
            
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            
            if(w == 0 && h == 0) break;
            
            map = new ArrayList<>(h);
            visited = new boolean[h][w];
            count = 0;
            
            for(int i = 0; i < h; i++){
                map.add(new ArrayList<>());
            }
            
            
            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    map.get(i).add(Integer.parseInt(st.nextToken()));
                }
            }
            
            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(!visited[i][j] && map.get(i).get(j) == 1){
                        bfs(i, j);
                        count += 1;
                    }
                }
            }
            
            sb.append(count).append("\n");
        }
        System.out.print(sb);
        
    }
    static void bfs(int x, int y){
        visited[x][y] = true;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[]{x, y});
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nx = now[0];
            int ny = now[1];
            
            for(int i = 0; i < 8; i++){
                int next_x = nx + dx[i];
                int next_y = ny + dy[i];
                
                if(next_x >= 0 && next_x < h && next_y >= 0 && next_y < w && map.get(next_x).get(next_y) == 1 && !visited[next_x][next_y]){
                    queue.offer(new int[]{next_x, next_y});
                    visited[next_x][next_y] = true;
                }
            }
        }
    }
}
