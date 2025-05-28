import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
    
        
        for(int i = 0; i<n; i++){
             StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            
            if(command.equals("push")){
                stack.push(Integer.parseInt(st.nextToken()));
            }
            
            else if(command.equals("pop")){
                if(stack.empty()){
                    sb.append("-1").append("\n");
                }
                else{
                    sb.append(stack.pop()).append("\n");
                }
            }
            
            else if(command.equals("size")){
                sb.append(stack.size()).append("\n");
            }
            
            else if(command.equals("empty")){
                if(stack.empty()){
                    sb.append("1").append("\n");
                }
                else{
                    sb.append("0").append("\n");
                }
            }
            
            else{
                if(stack.empty()){
                    sb.append("-1").append("\n");
                }
                else{
                    sb.append(stack.peek()).append("\n");
                }
            }
            
        }
        System.out.print(sb);
        
    }
}
