import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] score = {0, 0, 0};

        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int p1_size = p1.length;
        int p2_size = p2.length;
        int p3_size = p3.length;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == p1[i % p1_size]) score[0]++;
            if (answers[i] == p2[i % p2_size]) score[1]++;
            if (answers[i] == p3[i % p3_size]) score[2]++;
        }

        int max = Math.max(score[0], Math.max(score[1], score[2]));
        
        List<Integer> temp = new ArrayList<>();
        
        for(int i = 0; i < 3; i++){
            if(max == score[i]){
                temp.add(i+1);
            }
        }
        
        int[] res = new int[temp.size()];
        for(int i = 0; i < temp.size(); i++){
            res[i] = temp.get(i);
        }
        
        return res;
        
    }
}