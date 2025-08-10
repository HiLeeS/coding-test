import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String pattern = br.readLine();

        int starIndex = pattern.indexOf('*');
        String prefix = pattern.substring(0, starIndex);
        String suffix = pattern.substring(starIndex + 1);

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() < prefix.length() + suffix.length()) {
                System.out.println("NE");
                continue;
            }
            if (word.startsWith(prefix) && word.endsWith(suffix)) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}