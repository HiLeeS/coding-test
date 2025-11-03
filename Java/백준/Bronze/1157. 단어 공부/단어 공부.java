import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine().toUpperCase();
        int[] alpa = new int[26];
        
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            alpa[c-'A']++;
            
            
        }
        
        
        int max = -1, idx = -1;
        boolean ans = false;
        
        for(int i = 0; i < 26; i++){
            if(max < alpa[i]){
                max = alpa[i];
                idx = i;
                ans = false;
            }
            else if(alpa[i] == max){
                ans = true;
            }
            
        }
        System.out.println(ans ? "?" : String.valueOf((char) ('A' + idx)));
        
    }
}
