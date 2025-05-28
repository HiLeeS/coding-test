import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] list = new int[n+1];
        int[] a = new int[n+1];
        list[0] = 0;
        a[0] = 0;
        
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<n+1;i++){
            list[i] = Integer.parseInt(st.nextToken());
            a[i] = a[i-1] + list[i];
        }
        
        StringBuilder sb = new StringBuilder();
        
        
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            sb.append(a[num2] - a[num1-1]).append("\n");
        }
        
        System.out.print(sb);
        
    }
}
