import java.util.*;
class Solution {
    
    public int solution(int x, int y, int n) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        
        deque.offer(new int[] {y, 0});
        int answer = 0;
        while(!deque.isEmpty()) {
            int[] arr = deque.poll();
            int number = arr[0];
            int depth = arr[1];
            if(number == x) {
                answer = depth;
                break;
            }
            if(number < x) answer = -1;
            if(number > x) {
                deque.offer(new int[] {number - n, depth + 1});
                if(number % 2 == 0) deque.offer(new int[] {number / 2, depth + 1});
                if(number % 3 == 0) deque.offer(new int[] {number / 3, depth + 1});
            }
            
        }
        
        
        return answer;
    }
    
    
}