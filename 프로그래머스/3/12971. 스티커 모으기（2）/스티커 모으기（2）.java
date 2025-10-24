import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        if(sticker.length == 1) {
            return sticker[0];
        }
        int[][] dp1 = new int[sticker.length][2];
        int[][] dp2 = new int[sticker.length][2];
        dp1[0][1] = sticker[0];
        
        for(int i = 1; i<sticker.length - 1; i++) {
            dp1[i][0] = Math.max(dp1[i-1][0], dp1[i-1][1]);
            dp1[i][1] = sticker[i] + dp1[i-1][0];
        }
        
        for(int i = 1; i<sticker.length; i++) {
            dp2[i][0] = Math.max(dp2[i-1][0], dp2[i-1][1]);
            dp2[i][1] = sticker[i] + dp2[i-1][0];
        }
        int caseOne = Math.max(dp1[dp1.length-2][0], dp1[dp1.length-2][1]);
        int caseTwo = Math.max(dp2[dp2.length-1][0], dp2[dp2.length-1][1]);
        
        
        return Math.max(caseOne, caseTwo);
    }
}