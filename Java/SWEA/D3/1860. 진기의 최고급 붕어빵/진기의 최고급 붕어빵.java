
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
		int T = Integer.parseInt(br.readLine());
		
        StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            int[] arr= new int[N];
            for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
            
            Arrays.sort(arr);
            
            int time = 0;
            int boong = 0;
            String ans = "Possible";
            int i = 0;
            while(time <= arr[N-1]){
                time++;	//1초 증가
                
                if(time % M == 0) boong += K;	//붕어빵 제작
                
                while(i < N && time == arr[i]){	//손님 도착
                	if(boong > 0){
                        boong--;
                        i++;
                    }
                    else{	//재고 소진시
                        ans="Impossible";	
                        break;
                    }
                }
                if (ans.equals("Impossible") || i == N) break; // 조기 종료
            }
            if(i != N) ans = "Impossible";	//모든 손님 주문을 처리하지 못했을 경우
            
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
        System.out.print(sb);
        
	}
}