import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        long a = 0, b = 1;
        
        for(int i = 2; i<=n; i++){
            long temp = a+b;
            a = b;
            b = temp;
        }
        
        System.out.print(b);
        
    }
}
