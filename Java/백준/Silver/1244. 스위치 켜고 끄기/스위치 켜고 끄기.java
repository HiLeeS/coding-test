import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] state = new int[N];
        for(int i = 0; i < N; i++) state[i] =  Integer.parseInt(st.nextToken());
        
        int M = Integer.parseInt(br.readLine());
        
        int[][] students = new int[M][2];
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            students[i][0] = Integer.parseInt(st.nextToken());
            students[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for(int[] student : students){
            int gen = student[0];
            int pos = student[1]-1;
            
            if(gen == 1){   //남자
                for(int i = pos; i < N; i += pos+1){
                    state[i] = state[i]==1 ? 0:1;
                }
            }
            
            else{   //여자
                int pointer1 = pos - 1;
                int pointer2 = pos + 1;
                
                state[pos] = state[pos]==1 ? 0:1;
                
                while(pointer1 >= 0 && pointer2 < N && state[pointer1] == state[pointer2]){
                    state[pointer1] = state[pointer1]==1 ? 0:1;
                    state[pointer2] = state[pointer2]==1 ? 0:1;
                    pointer1--;
                    pointer2++;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        int count = 0;
        for (int ans : state) {
            sb.append(ans).append(" ");
            count++;
            if (count == 20) {
                sb.append("\n");
                count = 0;
            }
        }
        
        System.out.print(sb);
        
    }
}
