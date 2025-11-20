import java.io.*; 
import java.util.*; 
public class Main {
    
    static int[] arr = new int[9];
    static List<Integer> selected = new ArrayList<>();
    
    static void dfs(int depth, int start, int sum){
        if(depth == 7){
            if(sum == 100){
                for(int x : selected) System.out.println(x);
                System.exit(0);
            }
            return;
        }
        
        for(int i = start; i < 9; i++){
            selected.add(arr[i]);
            dfs(depth+1, i+1, sum+arr[i]);
            selected.remove(selected.size()-1);
        }
    }
    
     public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);
        
        
        dfs(0, 0, 0);
        
        
        
    }
}
