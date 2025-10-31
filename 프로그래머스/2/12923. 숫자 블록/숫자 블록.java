import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        int e = (int)end;
        int b = (int)begin;
        int[] answer = new int[e - b + 1];
        if(b == 1) answer[0] = 0;
        for(int i = b; i<=e; i++) {
            answer[i-b] = getBlockNumber(i);
        }
        return answer;
    }
    
    private int getBlockNumber(int n) {
        if(n == 1) return 0;
        int max = 1;
        for(int i = 2; i<= Math.sqrt(n); i++) {
            if( n % i == 0) {
                if(n / i <= 10000000) return n / i;
                max = i;
            }
        }
        return max;
    }
}