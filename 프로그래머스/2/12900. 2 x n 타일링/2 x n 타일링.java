import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        if (n == 1) answer = 1;
        if (n > 1) answer = 2;
        int prevNumber = 1;
        for(int i = 3; i<=n; i++) {
            int temp = answer;
            answer = ( answer + prevNumber ) % 1000000007;
            prevNumber = temp;
        }
        
        
        return answer % 1000000007;
    }
}