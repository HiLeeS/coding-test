import java.io.*;
import java.util.*;

public class Main {
    static Integer count = 0;
    static boolean[][] visited;
    static List<List<Integer>> map;
    static int N;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    
    public static void bfs(int x, int y, int k){
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        
        queue.offer(new int[]{x, y});
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            
            for(int i = 0; i < 4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                
                
                if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                    if(map.get(nx).get(ny) > k && !visited[nx][ny]){
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
    
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new ArrayList<>();
        visited = new boolean[N][N];
        
        StringTokenizer st;
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < N; j++){
                list.add(Integer.parseInt(st.nextToken()));
            }
            map.add(list);
        }
        
        int max_count = 0;
        int max_h = 0;
        for (List<Integer> row : map) {
            for (int height : row) {
                if (height > max_h) max_h = height;
            }
        }
        
        for(int k = 0; k < max_h; k++){
            count = 0;
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(map.get(i).get(j) > k && !visited[i][j]){
                        bfs(i, j, k);
                        count += 1;
                    }
                }
            }
            if(max_count < count){
                 max_count = count;
            }
        }
        
        if(max_count == 0){
            System.out.print(1);
        }
        else{
            System.out.print(max_count);
        }    
    }
   
}