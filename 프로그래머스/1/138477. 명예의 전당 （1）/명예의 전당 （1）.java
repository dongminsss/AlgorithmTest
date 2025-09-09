import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int[] board = new int[k];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<answer.length; i++) {
            if(i < k) {
                if(min > score[i]) min = score[i];
                board[i] = score[i];
                answer[i] = min;
            } else {
                
                if(min < score[i]) {
                    Arrays.sort(board);
                    board[0] = score[i];
                    Arrays.sort(board);
                    min = board[0];
                }
                answer[i] = min;
                 
            }
        }
        
        return answer;
    }
}