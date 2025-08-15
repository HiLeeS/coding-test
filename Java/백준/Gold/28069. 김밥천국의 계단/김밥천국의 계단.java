import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE); // INF 대신 사용
        dp[0] = 0;

        for (int i = 0; i <= N; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;

            if (i + 1 <= N && dp[i + 1] > dp[i] + 1)
                dp[i + 1] = dp[i] + 1;

            int j = i + (i / 2);
            if (j <= N && dp[j] > dp[i] + 1)
                dp[j] = dp[i] + 1;
        }

        System.out.print(dp[N] <= K ? "minigimbob" : "water");
    }
}
