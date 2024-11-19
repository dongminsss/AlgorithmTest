import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i : works) {
            pq.add(i);
        }
        for(int i = 0; i<n; i++) {
            if(!pq.isEmpty()){
                int number = pq.poll();
                if(number > 0) {
                    pq.add(--number);
                }    
            }
            
        }
        while(!pq.isEmpty()) {
            int number = pq.poll();
            answer += number * number;
        }
        return answer;
    }
}