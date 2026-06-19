import java.util.*;

class Solution {
    int[] apeach;
    int[] lion = new int[11];
    int[] answer = {-1};
    int maxDiff = -1;
    
    public int[] solution(int n, int[] info) {
        apeach = info;
        dfs(0, n);
        return answer;
    }
    
    private void dfs(int idx, int arrowsLeft) {
        if(idx == 11) {
            if(arrowsLeft > 0) lion[10] += arrowsLeft;
            
            int diff = getDiff();
            if(diff > 0) {
                if(diff > maxDiff) {
                    maxDiff = diff;
                    answer = lion.clone();
                } else if (diff == maxDiff && isBetter(lion, answer)) {
                    answer = lion.clone();
                }
            } 
            if(arrowsLeft > 0) {
                lion[10] -= arrowsLeft;
            }
            return;
        }
        
        int need = apeach[idx] + 1;
        
        if(need <= arrowsLeft) {
            lion[idx] = need;
            dfs(idx + 1, arrowsLeft - need);
            lion[idx] = 0;
        }
        
        dfs(idx + 1, arrowsLeft);
    }
    
    private int getDiff() {
        int lionScore = 0;
        int apeachScore = 0;
        
        for(int i = 0; i<11; i++) {
            if(lion[i] == 0 && apeach[i] == 0) continue;
            if(lion[i] > apeach[i]) {
                lionScore += 10 - i;
            } else {
                apeachScore += 10 - i;
            }
        }
        return lionScore - apeachScore;
    }
    
    private boolean isBetter(int[] now, int[] prev) {
        for(int i = 10; i>= 0; i--) {
            if(now[i] > prev[i]) return true;
            if(now[i] < prev[i]) return false;
        }
        return false;
    }
}