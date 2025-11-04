import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        int count = 0;
        
        for(int test_case = 0; test_case < T; test_case++){
            boolean[] tr = new boolean[26];
            String str = br.readLine();
            
            char before = ' ';
            boolean cur = true;
            
            for(int i = 0; i < str.length(); i++){
                if(i == 0){
                    before = str.charAt(i);
                    continue;
                }
                
                if(before == str.charAt(i)){
                    continue;
                }
                else{
                    if(tr[str.charAt(i)- 'a']){
                        cur = false;
                        break;
                    }
                    else{
                        tr[before - 'a'] = true;
                        before = str.charAt(i);
                    }
                }
            }
            if(cur) count++;
            
        }
        System.out.print(count);
    }
}
