import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] used;
    static StringBuilder sb = new StringBuilder();
    
    
    static void dfs(int depth, List<Integer> list) {
        if (depth == M) {
            for (int num : list) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (used[i]) continue;
            used[i] = true;
            list.add(arr[i]);

            dfs(depth + 1, list);

            used[i] = false;
            list.remove(list.size() - 1); // 백트래킹
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        used = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        dfs(0, new ArrayList<>());

        System.out.print(sb);
    }
}
