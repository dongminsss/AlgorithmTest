import java.util.*;

class Solution {
    public int solution(int [][]board) {
        int x = board[0].length;
        int y = board.length;
        int max = 0;
        for(int i = 1; i<y; i++) {
            for(int j = 1; j< x; j++) {
                if(board[i][j] == 1) {
                     board[i][j] = 1 + Math.min(Math.min(board[i-1][j-1], board[i][j-1]), board[i-1][j]);
                    max = Math.max(board[i][j], max);   
                }
            }
        }
        if(max == 0) {
            return hasOne(board) ? 1:0; 
        }
        
        return max * max;
    }
    private boolean hasOne(int[][] board) {
        for(int[] nums : board) {
            for(int n: nums) {
                if (n == 1) return true;
            }
        }
        return false;
    }
}