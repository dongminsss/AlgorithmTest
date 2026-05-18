class Solution {
    public long solution(int[] sequence) {
        long answer = -100_0001;
        long dp[][] = new long[sequence.length][2];
        dp[0][0] = sequence[0];
        dp[0][1] = -sequence[0];
        answer = Math.max(dp[0][1], dp[0][0]);
        
        for(int i = 1; i<sequence.length; i++) {
            dp[i][0] = Math.max(sequence[i], dp[i-1][1] + sequence[i]);
            dp[i][1] = Math.max(-sequence[i], dp[i-1][0] - sequence[i]);
            answer = Math.max(answer, Math.max(dp[i][1], dp[i][0]));
        }
        return answer;
    }
}