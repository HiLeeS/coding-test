import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        
        int m = Integer.parseInt(br.readLine());
       
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            int num = Integer.parseInt(st.nextToken());
            if(set.contains(num)){
                sb.append("1\n");
            }
            else{
                sb.append("0\n");
            }
        }
        
        System.out.print(sb);
    }
}
