import java.util.*;
import java.io.*;

class Solution
{
    static int N;
    static int start;
    static boolean[] visited;
    static List<List<Integer>> nodes;
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
            
            visited = new boolean[101];
            nodes = new ArrayList<>();
            for (int i = 0; i <= 100; i++) nodes.add(new ArrayList<>());

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                nodes.get(from).add(to);
            }
            
            int ans = bfs(start);
            
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
        System.out.print(sb);
	}
    
    static int bfs(int node){
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);
        int last = start;

        while(!q.isEmpty()){
            int size = q.size();
            int maxNum = 0; // 이번 레벨의 가장 큰 번호
            
            for(int i = 0; i<size; i++){	//한 턴에 다 처리
				int now = q.poll();
            	maxNum = Math.max(now, maxNum);
                for(int next:nodes.get(now)){
                    if(!visited[next]){
                        q.offer(next);
                        visited[next] = true;
                    }
                }
                
            }
        	last = maxNum;
        }
        return last;
    }
    
}