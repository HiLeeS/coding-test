import java.util.*;
import java.io.*;


class Solution
{
    static int[][] map = new int[16][16];
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int x;
    static int y;
    static int fx;
    static int fy;
    static int ans = 0;
    static boolean[][] visited = new boolean[16][16];
	public static void main(String args[]) throws Exception
	{
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int game = Integer.parseInt(br.readLine());
            x = 0;
            y = 0;
            ans = 0;
            map = new int[16][16];
			visited = new boolean[16][16];
            
            for(int i = 0; i < 16; i++){	//map 입력받기
				String str = br.readLine();
                for(int j = 0; j < 16; j++){
                	map[i][j] = str.charAt(j) - '0';
                    if(map[i][j] == 2){	//시작점
                    	x = i;
                        y = j;
                    }
                    else if(map[i][j] == 3){	//도착점
                    	fx = i;
                        fy = j;
                    }
                }
            }
            dfs(x, y);
            ans = visited[fx][fy] ? 1:0;
            sb.append("#").append(game).append(" ").append(ans).append("\n");
		}
        System.out.print(sb);

	}
     
    static void dfs(int x, int y){
        visited[x][y] = true;
        
        for(int i = 0; i < 4; i++){
        	int nx = x+dy[i];
        	int ny = y+dx[i];
            
            if(nx > 0 && nx < 16 && ny > 0 && ny < 16 && map[nx][ny] != 1){
            	if(!visited[nx][ny]){
                	if(map[nx][ny] == 3){
                    	visited[nx][ny] = true;
                        return;
                    }
                    dfs(nx, ny);
                }
            }
        }
        return;
    }
       
}