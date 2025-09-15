import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0) {
            int k = storey % 10;
            if( k > 5 ) {
                answer += 10 - k;
                storey += 10;
            } else if (k < 5) {
                answer += k;
            } else {
                answer += k;
                if((storey % 100) / 10  >= 5) storey += 10;
            }
            storey = storey / 10;
        }
        return answer;
    }
    
}