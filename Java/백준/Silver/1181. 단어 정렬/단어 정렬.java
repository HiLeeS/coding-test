import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < n; i++){
            set.add(br.readLine());
        }
        
        List<String> list = new ArrayList<>(set);
        
        Collections.sort(list, Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
        
        for(String value:list){
            sb.append(value).append("\n");
        }
        System.out.print(sb);
    }
}
