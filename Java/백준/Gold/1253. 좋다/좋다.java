import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[n];
        
        int count = 0;
        for(int i =0; i<n;i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(list);
        int sum = 0;
        for(int k = 0; k < n; k++){
            int find = list[k];
            int i = 0; 
            int j = n-1;
            while(i < j){
                sum = list[i] + list[j];
                if(sum > find){
                    j--;
                }
                else if(sum < find){
                    i++;
                }
                else{
                    if(k != i && k != j){
                        count += 1;
                        break; 
                    }
                    else if(i == k){
                        i++;
                    }
                    else if(j == k){
                        j--;
                    }
                        
                }
            }
        }
        System.out.print(count);
    }
}
