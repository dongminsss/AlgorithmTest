import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int length = numbers.length;
        int[] answer = new int[length];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i = length-1; i >= 0; i--) {
            
            while(!deque.isEmpty() && deque.peek() <= numbers[i]) {
                deque.pop();
            }
            
            if(!deque.isEmpty()) {
                answer[i] = deque.peek();
            } else {
                answer[i] = -1;
            }
            
            deque.push(numbers[i]);
        }
        return answer;
    }
}