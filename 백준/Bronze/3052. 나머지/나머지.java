import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] list = new int[10];
        
        for(int i = 0; i < 10; i++){
            list[i] = Integer.parseInt(br.readLine()) % 42;
        }
        Arrays.sort(list);
        
        int count = 1;
        
        for(int i = 1; i < 10; i++){
            if(list[i] != list[i-1]){
                count++;
            }
        }
        
        System.out.print(count);
        
    }
}
