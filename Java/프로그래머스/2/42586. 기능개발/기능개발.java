import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> q = new LinkedList<>();
        
        for(int n:progresses){
            q.offer(n);
        }
        
        
        while(!q.isEmpty()){
            int count = 0;
            boolean turn = true;
            for(int i =0; i < speeds.length; i++){
                if(speeds[i] == -1) continue;
                
                int now = q.poll();
                now += speeds[i];
                if(now >= 100 && turn){
                    count += 1;
                    turn = true;
                    speeds[i] = -1;
                }
                else{
                    q.offer(now);
                    turn = false;
                }
            }
            if(count > 0){
                ans.add(count);
            }
            
        }
        
        int[] answer = new int[ans.size()];
        for(int i =0 ; i< ans.size(); i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}