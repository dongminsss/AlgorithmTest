import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long max = (long)times[0] * n;
        Arrays.sort(times);
        
        while (answer <= max) {
            long middle = (max + answer) / 2;
            long count = 0;
            
            for(int time : times) {
                count +=(long)( middle / time);    
            }
            
            if(count >= n) {
                max = middle - 1;
            } else {
                answer = middle + 1;
            }
            
        }
        return answer;
    }
}