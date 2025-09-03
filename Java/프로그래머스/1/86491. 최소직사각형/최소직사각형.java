import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        int maxh = 0;
        int maxw = 0;
        
        for(int i = 0; i < sizes.length; i++){
            int x = sizes[i][0];
            int y = sizes[i][1];
            
            if(x > y){
                if(maxh < x){
                    maxh = x;
                }
                if(maxw < y){
                    maxw = y;
                }   
            }
            else{
                if(maxh < y){
                    maxh = y;
                }
                if(maxw < x){
                    maxw = x;
                }  
            }
            
        }
        
        
        
        int answer = maxh * maxw;
        return answer;
    }
}