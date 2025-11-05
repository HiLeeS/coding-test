
import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		
        StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dump = Integer.parseInt(st.nextToken());
            
            int[] arr = new int[100];
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < 100; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            int ans = 0;
            for(int i = 0; i < dump; i++){
            	Arrays.sort(arr);
                if(arr[0] == arr[99]) break;
                arr[0]++;
                arr[99]--;
            }
            Arrays.sort(arr);
            ans = arr[99]-arr[0];
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
        System.out.print(sb);
        
	}
}