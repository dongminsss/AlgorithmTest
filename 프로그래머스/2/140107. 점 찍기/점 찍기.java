import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long sum = (long)d * d;
        for(int i = 0; i<=d; i+=k) {
            long ii = (long)i*i;
            answer += (long)(Math.sqrt(sum - ii) / k) + 1;
        }
        return answer;
    }
}