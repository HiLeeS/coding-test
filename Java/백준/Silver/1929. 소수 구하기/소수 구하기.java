import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N+1];
        
        for(int i =2; i < N+1; i++){
            if(!visited[i]){
                if(i >= M){
                    sb.append(i).append("\n");
                }
            }
            
            for(int j = i+i; j <N+1; j=j+i){
                if(!visited[j]){
                    visited[j] = true;
                }
            }
        }
        
        System.out.print(sb);
    }
}

