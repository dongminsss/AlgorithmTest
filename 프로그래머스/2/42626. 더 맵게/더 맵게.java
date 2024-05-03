import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i<scoville.length; i++) {
            priorityQueue.add(scoville[i]);
        }
        while(!priorityQueue.isEmpty()) {
            if(priorityQueue.peek() >= K) break;
            if(priorityQueue.size() > 1) {
                int sum = priorityQueue.remove() + (priorityQueue.remove() * 2);
                priorityQueue.add(sum);
                answer++;
            } else {
                answer = -1;
                break;
            }
        
        }
        return answer;
    }
}