import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int count = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        
        for(int[] arr : routes) {
            pq.offer(arr);
        }
        
        while(!pq.isEmpty()) {
            int[] route = pq.poll();
            int end = route[1];
            count++;
            while(!pq.isEmpty() && pq.peek()[0] <= end) {
               pq.poll();
            }
            
        }
        
        int answer = count;
        return answer;
    }
}