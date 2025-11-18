import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		StringBuilder sb = new StringBuilder();
        
		for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            
            int[][] arr = new int[N][N];
            boolean[][] visited = new boolean[N][N];
            
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};
            int d = 0;
			int x = 0, y = 0;
            
            for (int i = 1; i <= N * N; i++) {
                arr[x][y] = i;
                visited[x][y] = true;

                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
                    d = (d + 1) % 4;
                    nx = x + dx[d];
                    ny = y + dy[d];
                }

                x = nx;
                y = ny;
            }

            sb.append("#"+test_case).append("\n");
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                   sb.append(arr[i][j]+" ");
                }
                sb.append("\n");
            }

		}
        System.out.print(sb);
	}
}