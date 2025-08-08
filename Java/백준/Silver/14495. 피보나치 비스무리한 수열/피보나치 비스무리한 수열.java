import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        long[] arr = new long[n];
        
        for(int i = 0; i < n; i++){
            if(i < 3){
                arr[i] = 1;
            }
            else arr[i] = arr[i-1] + arr[i-3];
        }
        System.out.print(arr[n-1]);
    }
}
