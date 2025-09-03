import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int answer = n-lost.length;
        
        for(int i = 0; i<lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] == reserve[j]){
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }    
        }
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i = 0; i < lost.length; i++){
            if(lost[i] == -1) continue;
            int front = lost[i] - 1;
            int back = lost[i]+1;
            
            for(int j = 0; j < reserve.length; j++){
                if(reserve[j] == -1) continue;
                if(front == reserve[j] || back == reserve[j]){
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        
        }
        
        return answer;
    }
}