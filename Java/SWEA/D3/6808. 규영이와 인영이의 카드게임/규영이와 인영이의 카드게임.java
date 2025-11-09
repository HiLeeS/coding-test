
import java.util.*;
import java.io.*;

class Solution
{
    static int[] gu = new int[9];
    static int[] in = new int[9];
    static boolean[] check = new boolean[19];
    static int win = 0;
    static int lose = 0;
    static boolean[] used = new boolean[9];
    
    static void dfs(int round, int g_score, int i_score){
        if(round == 9){
        	if(g_score > i_score) win++;
            else lose++;
            return;
        }
        
        for(int i = 0; i < 9; i++){
        	if(used[i]) continue;
            used[i] = true;
            
            int sum = gu[round] + in[i];
            if (gu[round] > in[i]) {
                dfs(round + 1, g_score + sum, i_score);
            } else {
                dfs(round + 1, g_score, i_score + sum);
            }

            used[i] = false;
        }
    
    
    
    }
    
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
		int T = Integer.parseInt(br.readLine());
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
		
            for(int i = 0; i < 9; i++){
            	int num = Integer.parseInt(st.nextToken());
                gu[i] = num;
                check[num] = true;
            }
           
            int idx = 0;
            for(int i = 1; i < 19; i++){
            	if(!check[i]) in[idx++] = i;
            }
            
			win = 0;
    		lose = 0;
            Arrays.fill(check, false);
            dfs(0, 0, 0);
            
            sb.append("#").append(test_case).append(" ").append(win+" "+lose+"\n");
                
		}
        System.out.print(sb);
	}
}