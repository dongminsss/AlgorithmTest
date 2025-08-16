import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        ArrayDeque<Integer> deque1 = convertDeque(queue1);
        ArrayDeque<Integer> deque2 = convertDeque(queue2);
        int answer = 0;
        long oneSum = deque1.stream().mapToInt(Integer::intValue).sum();
        long twoSum = deque2.stream().mapToInt(Integer::intValue).sum();
        long half = (oneSum + twoSum) / 2;
        int i = 0;
        while(i <= queue1.length * 3) {
            if(oneSum < half) {
                int o2 = deque2.poll();
                deque1.offer(o2);
                oneSum += o2;
            } else if (oneSum > half) {
                int o1 = deque1.poll();
                deque2.offer(o1);
                oneSum -= o1;
            } else {
                break;
            }
            answer++;
            i++;
        }
        if(i >= queue1.length * 3) answer = -1;
        return answer;
    }
    
    public ArrayDeque<Integer> convertDeque(int[] arr) {
        ArrayDeque<Integer> result = new ArrayDeque<>();
        for(int a : arr) {
            result.add(a);    
        }
        return result;
    }
}