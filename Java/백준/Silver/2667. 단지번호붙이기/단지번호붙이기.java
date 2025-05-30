import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int count;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        
        List<Integer> results = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && map[i][j]==1){
                    count = 0;
                    dfs(i, j);
                    results.add(count);
                }
            }
        }
        
        Collections.sort(results);
        System.out.println(results.size());
        for(int num:results){
            System.out.println(num);
        }
        
    }
    
    static void dfs(int x, int y){
        visited[x][y] = true;
        count++;
        
        
        for(int i =0; i < 4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            
            if(ny >= 0 && nx >= 0 && ny < n && nx < n){
                if(!visited[nx][ny] && map[nx][ny] == 1){
                    dfs(nx, ny);
                }
            }

        }
        
    }
    
    
    
}
