class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n / a != 0) {
            int sum = 0;
            sum += ( n % a );
            sum += ( n / a ) * b;
            answer += (n/a) * b;
            n = sum;
            
        }
        return answer;
    }
}