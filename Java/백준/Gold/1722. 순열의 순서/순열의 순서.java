import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] F = new long[21];
        int[] S = new int[21];
        boolean[] visited = new boolean[21];

        int N = Integer.parseInt(br.readLine());
        F[0] = 1;
        for (int i = 1; i <= N; i++) {
            F[i] = F[i - 1] * i;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cmd = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        if (cmd == 1) {
            long K = Long.parseLong(st.nextToken());

            for (int i = 1; i <= N; i++) {
                int cnt = 1;
                for (int j = 1; j <= N; j++) {
                    if (visited[j]) continue;

                    if (K <= cnt * F[N - i]) {
                        K -= (cnt - 1) * F[N - i];
                        S[i] = j;
                        visited[j] = true;
                        break;
                    }
                    cnt++;
                }
            }

            for (int i = 1; i <= N; i++) {
                sb.append(S[i]).append(" ");
            }

        } else if (cmd == 2) {
            int[] input = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }

            long K = 1;
            for (int i = 1; i <= N; i++) {
                int cnt = 0;
                for (int j = 1; j < input[i]; j++) {
                    if (!visited[j]) cnt++;
                }
                K += cnt * F[N - i];
                visited[input[i]] = true;
            }
            sb.append(K);
        }

        System.out.print(sb);
    }
}
