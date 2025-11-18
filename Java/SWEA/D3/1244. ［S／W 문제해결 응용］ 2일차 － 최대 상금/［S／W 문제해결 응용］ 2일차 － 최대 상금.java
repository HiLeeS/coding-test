import java.util.*;
import java.io.*;

public class Solution {
    
    static int change = 0;
    static char[] arr;
    static int answer;
    static HashSet<String>[] visited;
    
    static void dfs(int count){
        if(change == count){
            int value = Integer.parseInt(new String(arr));
            if(value > answer) answer = value;
            return;
        }
    	
        String state = new String(arr);
        if(visited[count].contains(state)) return;
        visited[count].add(state);
        
        int len = arr.length;
        
        for(int i = 0; i < len - 1; i++){
            for(int j =i +1; j < len; j++){
        		char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                
                dfs(count+1);
                
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                
                
            }
        }
        
    
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = st.nextToken().toCharArray();
            change = Integer.parseInt(st.nextToken());
            
            answer = 0;
            visited = new HashSet[change + 1];
            for (int i = 0; i <= change; i++) {
                visited[i] = new HashSet<>();
            }
            
            dfs(0);

            System.out.println("#" + tc + " " + answer);
        }
    }
}
