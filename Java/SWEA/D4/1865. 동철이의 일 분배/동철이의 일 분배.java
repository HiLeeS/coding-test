
import java.util.*;
import java.io.*;


class Solution
{
    static int N;
    static double[][] works;
    static double max;
    static boolean[] used;
    
    static void dfs(int index, double current){
        if(index == N){
            if (current > max) {
                max = current;
            }
        	return;
        }
        
        for(int j = 0; j < N; j++){
        	if(used[j]) continue;
            double nextWork = current * works[index][j];
            if (nextWork <= max) continue;  // 가지치기
            used[j] = true;
            dfs(index + 1, nextWork);
            used[j] = false;
        
        }
    }
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
        StringBuilder sb = new StringBuilder();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = Integer.parseInt(br.readLine());
            works = new double[N][N];
            
            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
            	for(int j = 0; j < N; j++){
                    works[i][j] = Integer.parseInt(st.nextToken()) / 100.0;
                	
                }
            }
			
            used = new boolean[N];
            max = 0.0;
			dfs(0, 1.0);
            
            sb.append("#").append(test_case).append(" ").append(String.format("%.6f", max * 100)).append("\n");
		}
        System.out.print(sb);
	}
}