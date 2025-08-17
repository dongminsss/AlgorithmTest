import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)right - (int)left + 1];
        
        for(int i = 0; i<answer.length; i++) {
            int x = (int)(left % n) + 1;
            int y = (int)(left / n) + 1;
            answer[i] = max(x, y);
            left++;
        }
        return answer;
    }
    
    public int max(int x, int y) {
        return (x >= y) ? x : y;
    }
}