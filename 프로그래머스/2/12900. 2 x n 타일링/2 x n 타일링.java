class Solution {
    public int solution(int n) {
        int answer = 0;
        if(n == 1) answer = 1;
        if(n == 2) answer = 2;
        int prevPrevNumber = 1;
        int prevNumber = 2;
        for(int i = 2; i<n; i++) {
            answer = ( prevPrevNumber + prevNumber ) % 1000000007;
            prevPrevNumber = prevNumber % 1000000007;
            prevNumber = answer;
        }
        
        return answer;
    }
}