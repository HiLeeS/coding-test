import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.MIN_VALUE;
        int idx = 0;
        int num = 0;
        for(int i = 0; i < 9; i++){
            num = Integer.parseInt(br.readLine());
            if(num > max){
                max = num;
                idx = i+1;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n");
        sb.append(idx);
        System.out.print(sb);
        
    }
}
