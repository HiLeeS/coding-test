
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
            int Test = Integer.parseInt(br.readLine());
            
            int[][] arr = new int[100][100];
            
            for(int i = 0; i < 100; i++){
            	StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int min_count = 10001;
            int min_i = 0;
            
            for(int i = 0; i < 100; i++){
            	if(arr[0][i] == 0) continue;
                
                int x = i;
                int y = 0;
                int count = 0;
                
                while(y < 99){
                    count++;
                    
                    if(x > 0 && arr[y][x-1] == 1){
                    	while(x > 0 && arr[y][x-1] == 1){
                        	x--;
                            count++;
                        }
                    }
                    else if(x < 99 && arr[y][x+1] == 1){
                    	while(x < 99 && arr[y][x+1] == 1){
                        	x++;
                            count++;
                        }
                    }
                    
                    y++;
                    
                
                }
                if(min_count > count){
                	min_i = i;
                    min_count = count;
                }
            }
		
		System.out.println("#"+test_case+" "+min_i);	
		}
	}
}