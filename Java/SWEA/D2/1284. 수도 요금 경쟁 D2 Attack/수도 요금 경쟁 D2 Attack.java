
import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T=Integer.parseInt(br.readLine());
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int P = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
		
            int A = P*W;
            
            int B = 0;
            if(W > R){
                int num = W - R;
                B = Q + (num*S);
            }
            else B = Q;
            
            int res = A > B ? B : A;
            
            sb.append("#").append(test_case).append(" ").append(res).append("\n");
		}
        System.out.print(sb);
	}
}