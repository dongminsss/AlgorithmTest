import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        score = Arrays.stream(score).boxed().sorted((o1, o2) -> Integer.compare(o2,o1))
            .mapToInt(Integer::intValue).toArray();
        for(int i = m-1; i<score.length; i+=m) {
            answer += (m * score[i]);
        }
        
        return answer;
    }
}