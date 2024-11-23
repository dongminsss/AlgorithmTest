import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int a : B) {
            pq.offer(a);
        }
        int idx = 0;
        while(!pq.isEmpty()) {
            int n = pq.poll();
            if(A[idx] < n) {
                idx++;
                answer++;
            }
        }
        
        
        
        return answer;
    }
}