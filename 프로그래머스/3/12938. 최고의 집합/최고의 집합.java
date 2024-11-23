import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        
        int[] answer = new int[n];
        
        int r = (int)Math.floor( s / n );
        int d = s % n;
        if(r == 0) return new int[]{-1};
        
        for(int i = n-1; i>=0; i--) {
            if(d > 0) {
                answer[i] = r + 1;
                d--;
            } else {
                answer[i] = r;
            }
            
        }
        return answer;
    }
}