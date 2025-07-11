import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<String> queue = new ArrayDeque();
        
        for(int i = 0; i< n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            
            if(cmd.equals("push")){
                queue.offerLast(st.nextToken());
            }
            else if(cmd.equals("pop")){
                if(queue.isEmpty()){
                    sb.append("-1\n");
                }
                else{
                    sb.append(queue.pollFirst()).append("\n");
                    queue.remove(0);
                }
            }
            
            else if(cmd.equals("size")){
                sb.append(queue.size()).append("\n");
            }
            else if(cmd.equals("empty")){
                if(queue.isEmpty()){
                    sb.append("1").append("\n");
                }
                else{
                    sb.append(0).append("\n");
                }
            }
            else if(cmd.equals("front")){
                if(queue.isEmpty()){
                    sb.append("-1").append("\n");
                }
                else{
                    sb.append(queue.peekFirst()).append("\n");
                }
            }
            else if(cmd.equals("back")){
                if(queue.isEmpty()){
                    sb.append("-1").append("\n");
                }
                else{
                    sb.append(queue.peekLast()).append("\n");
                }
            }
            
        }
        System.out.print(sb);
        
    }
}
