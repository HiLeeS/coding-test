import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] parent = new int[n+1];
        
        for(int i = 0; i < n+1; i++){
            parent[i] = i;
        }
        
        for(int i =0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(c == 0){
                union(parent, a, b);
            }
            
            else{
                if(checkSame(parent, a, b)){
                    sb.append("YES\n");
                }
                else{
                    sb.append("NO\n");
                }
            }    
        }
        
        System.out.print(sb);
    }
    
    static int find(int a, int[] parent){
        if(a == parent[a]){
            return a;
        }
        else{
            parent[a] = find(parent[a], parent);
            return parent[a];
        }
        
    }
    
    static void union(int[] parent, int a, int b){
        a = find(a, parent);
        b = find(b, parent);
        
        if(a != b){
            parent[b] = a;
        }
        
    }
    
    static boolean checkSame(int[] parent, int a, int b){
        a = find(a, parent);
        b = find(b, parent);
        
        if(a != b){
            return false;
        }
        else return true;
        
    }
}
