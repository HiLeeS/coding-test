import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            long profit = 0;

          
            for(int i = N - 1; i >= 0; i--){
                if(arr[i] > max){
                    max = arr[i]; 
                } else {
                    profit += (max - arr[i]); 
                }
            }

            sb.append("#").append(test_case).append(" ")
              .append(profit).append("\n");
        }

        System.out.print(sb);
    }
}
