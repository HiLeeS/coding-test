import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        
        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(st.nextToken()); 
        }
        
        Arrays.sort(numbers);
        System.out.println(numbers[0]+" "+numbers[N-1]);
        
    }
}
