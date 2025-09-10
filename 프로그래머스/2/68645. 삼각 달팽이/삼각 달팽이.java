import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] board = new int[n][n];
        int x = -1;
        int y = 0;
        int count = 1;
        
        for(int i = 0; i<n; i++) {
            
            for(int j = i; j<n; j++) {
                if(i % 3 == 0) {
                    x++; 
                } else if ( i % 3 == 1) {
                    y++;
                } else {
                    x--;
                    y--;
                }
                board[x][y] = count++;
            }
        }
        int[] answer = new int[count-1];
        int idx = 0;
        
        for(int[] arr: board) {
            for(int number : arr) {
                if(number != 0) answer[idx++] = number;
            }
        }
        
        
        return answer;
    }
}