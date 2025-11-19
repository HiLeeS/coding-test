import java.util.*;
import java.io.*;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            int[][] map = new int[N][N];
            int[][] sum = new int[N][N + 1];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    // sum[i][j+1] = 0~j까지 합
                    sum[i][j + 1] = sum[i][j] + map[i][j];
                }
            }
            
            int max = 0;
            for(int i = 0; i <= N-M; i++){
            	for(int j = 0; j <= N-M; j++){
                    int now = 0;
                    for(int k = i; k < M+i; k++){
                        now += sum[k][j+M] - sum[k][j];
                    
                    }
                    max = Math.max(now, max);
                }
            }
            
            sb.append("#"+test_case+" "+max).append("\n");

		}
        System.out.print(sb);
	}
}