import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        int T = 10;
        
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int test = Integer.parseInt(br.readLine());
			int max = 0;
            int[][] arr = new int[100][100];
            
            int col_max=0;
            int col_sum=0;
            int[] row = new int[100];
            
            int crossA=0;
            int crossB=0;
            
            int j_count = 99;
            for(int i = 0; i < 100; i++){
                col_sum=0;
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++){
                    int num = Integer.parseInt(st.nextToken());
                    arr[i][j] = num;
                    col_sum += num;
                    
                    row[j] += num;
                    
                    if(i == j){
                    	crossA += num;	//대각선 합
                    }
                    
                    if(j == j_count){	//반대 대각선 합
                    	crossB += num;
                        j_count--;
                    }
                }
                col_max = Math.max(col_max, col_sum);	//열의 최대 합
            }
            
            Arrays.sort(row);	//마지막 인덱스가 행의 최대 합
            int row_max = row[99];
            
            int answer = Math.max(Math.max(row_max, col_max), Math.max(crossA, crossB));	//최댓값 찾기
            
            sb.append("#"+test+" ").append(answer).append("\n");
            
		}
        System.out.print(sb);
	}
}