import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            int caseNum = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] scores = new int[101];

            while (st.hasMoreTokens()) {
                int score = Integer.parseInt(st.nextToken());
                scores[score]++;
            }

            int maxCount = 0;
            int maxScore = 0;

            for (int i = 0; i <= 100; i++) {
                if (scores[i] >= maxCount) {
                    maxCount = scores[i];
                    maxScore = i;
                }
            }

            sb.append("#").append(caseNum).append(" ").append(maxScore).append("\n");
        }

        System.out.print(sb);
    }
}