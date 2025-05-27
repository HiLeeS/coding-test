import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final int OFFSET = 1000000;    // 음수 보정용
        final int SIZE = 2000001;      // 전체 범위 (-1,000,000 ~ 1,000,000)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] isPresent = new boolean[SIZE];

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            isPresent[value + OFFSET] = true;  // 값 등장 표시
        }

        for (int i = 0; i < SIZE; i++) {
            if (isPresent[i]) {
                sb.append(i - OFFSET).append("\n");
            }
        }

        System.out.print(sb);
    }
}