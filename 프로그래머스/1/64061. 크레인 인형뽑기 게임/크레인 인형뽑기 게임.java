import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<moves.length; i++) {
            int number = moves[i] - 1;
            for(int j = 0; j<board.length; j++) {
                
                if( board[j][number] != 0) {
                    if(stack.isEmpty()) {
                        stack.push(board[j][number]);
                        board[j][number] = 0;
                        break;
                    } else {
                        if(stack.peek() == board[j][number]) {
                            stack.pop();
                            answer+=2;
                            board[j][number] = 0;
                            break;
                        } else {
                            stack.push(board[j][number]);
                            board[j][number] = 0;
                            break;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}