import java.io.*;
import java.util.*;

public class Main {
    
    static int[] point;
    static int[] result;
    static int[] inDegree;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        point = new int[n+1];
        result = new int[n+1];
        inDegree = new int[n+1];
        
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i<n+1; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i = 1; i<n+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            point[i] = Integer.parseInt(st.nextToken());
            
            while(st.hasMoreTokens()){
                int num = Integer.parseInt(st.nextToken());
                if(num  == -1){
                    break;
                }
                list.get(num).add(i);
                inDegree[i]++;
            }
        }
        
        for(int i = 1; i<n+1; i++){
            result[i] = point[i];
        }
        
        Queue<Integer> queue=  new LinkedList<>();
        for(int i=1; i<n+1;i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            for(int next:list.get(cur)){
                result[next] = Math.max(result[next], result[cur]+point[next]);
                inDegree[next]--;
                if(inDegree[next] == 0){
                    queue.offer(next);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<n+1;i++){
            sb.append(result[i]).append("\n");
        }
        
        System.out.print(sb);
        
    }
}
