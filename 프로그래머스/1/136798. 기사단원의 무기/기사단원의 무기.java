import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] dp = new int[number+1];
        Arrays.fill(dp, 1);
        for(int i = 2; i<=number; i++) {
            int n = i;
            while(n <= number) {
                dp[n]++;
                n += i;
            } 
        }
        for(int i = 1; i<=number; i++) {
            if(dp[i] <= limit) {
                answer += dp[i];
            } else {
                answer += power;
            }
        }
        return answer;
    }
}