import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int a : works) pq.add(a);
        
        while(n > 0) {
            int hour = pq.poll();
            if(hour == 0) break;
            n--;
            pq.add(hour-1);
        }
        for(int i : pq) {
            answer += i * i;
        }
        
        return answer;
    }
}