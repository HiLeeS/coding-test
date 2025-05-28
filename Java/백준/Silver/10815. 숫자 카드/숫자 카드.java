import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i<n; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<m; i++){
            int num = Integer.parseInt(st.nextToken());
            if(set.contains(num)){
                sb.append("1 ");
            }
            else{
                sb.append("0 ");
            }
        }
        
        System.out.print(sb);
    }
}
