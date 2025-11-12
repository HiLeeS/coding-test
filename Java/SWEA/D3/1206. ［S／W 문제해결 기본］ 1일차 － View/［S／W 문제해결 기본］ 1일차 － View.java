
import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		
        StringBuilder sb = new StringBuilder();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
            int[] buildings = new int[N];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int i = 0; i < N; i++){
            	buildings[i] = Integer.parseInt(st.nextToken());
            }
            
            int sum = 0;
             for(int i = 2; i < N-2; i++){
            	int now = buildings[i];
                 
                 if(now > buildings[i-1] && now > buildings[i-2] && now > buildings[i+1] && now > buildings[i+2]){
                     int right = Math.max(buildings[i+1], buildings[i+2]);
                     int left = Math.max(buildings[i-1], buildings[i-2]);
                     left = Math.max(right, left);
                     
                     sum += now-left;
                     
                 }
            }
            
            sb.append("#"+test_case+" "+sum+"\n");
		}
	System.out.print(sb);
	}
}