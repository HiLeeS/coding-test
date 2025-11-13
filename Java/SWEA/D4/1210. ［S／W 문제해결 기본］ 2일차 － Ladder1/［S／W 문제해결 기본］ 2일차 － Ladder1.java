
import java.util.*;
import java.io.*;


class Solution
{
    static int[][] map;
    static int start;
    static boolean arrived;
    static int answer;
    
    static void solve(int x, int y){
        
        while(x < 99){
            
            if(y > 0 && map[x][y-1] == 1){
            	while(y > 0 && map[x][y-1] == 1){
                	y--;
                }
            }
            
            else if(y < 99 && map[x][y+1] == 1){
            	while(y < 99 && map[x][y+1] == 1){
                	y++;
                }
            }
            
            x++;
        }
        
        if(map[x][y] == 2){
        	answer = start;
            arrived = true;
            return;
        }
            
    }
    
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		
        StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int test = Integer.parseInt(br.readLine());
            map = new int[100][100];
            
            for(int i = 0; i < 100; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
           		for(int j = 0; j < 100; j++){
                	map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            arrived = false;
            
            for(int i = 0; i < 100; i++){
            	if(map[0][i] == 1 && !arrived){
                    start = i;
                	solve(0, i);
                }
            }
            
            sb.append("#").append(test).append(" ").append(answer).append("\n");

		}
        System.out.print(sb);
	}
}