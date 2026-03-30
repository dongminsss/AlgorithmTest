import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> dq = dqOffer(progresses);
        System.out.println(dq);
        List<Integer> list = new ArrayList<>();
        int speedIdx = 0;
        while(!dq.isEmpty()) {
            int progress = dq.poll();
            int amount = 100 - progress;
            int day = amount / speeds[speedIdx];
            if(amount % speeds[speedIdx++] > 0) day++;
            int number = 1;
            while(!dq.isEmpty()) {
                int next = dq.peek();
                if(speeds[speedIdx] * day + next >= 100) {
                    dq.poll();
                    number++;
                    speedIdx++;
                } else {
                    break;
                }
            }
            list.add(number);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public ArrayDeque<Integer> dqOffer(int[] arr) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for( int n : arr) {
            dq.add(n);
        }
        return dq;
    }
}
