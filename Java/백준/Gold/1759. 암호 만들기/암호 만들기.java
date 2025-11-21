import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static char[] arr;
    static String aeiou = "aeiou";
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    
    static void dfs(int depth, int start, List<Character> list){
        if(depth == L){
            int count1 = 0; //모음 카운트
            int count2 = 0; //자음 카운트
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < L; i++){
                if(aeiou.contains(String.valueOf(list.get(i)))) count1++;
                else count2++;
                
                str.append(list.get(i));
            }
            if(count1 >= 1 && count2 >= 2){
                sb.append(str+"\n");
            }
            return;
        }
        
        
        for(int i = start; i < C; i++){
            if(visited[i]) continue;
            visited[i] = true;
            list.add(arr[i]);
            dfs(depth+1, i+1, list);
            visited[i] = false;
            list.remove(list.size()-1);
            
        }
        
        
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        arr = new char[C];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++){
            arr[i] = st.nextToken().charAt(0);
        }
        
        visited = new boolean[C];
        
        Arrays.sort(arr);
        
        dfs(0, 0, new ArrayList<>());
        
        System.out.print(sb);
    }
}
