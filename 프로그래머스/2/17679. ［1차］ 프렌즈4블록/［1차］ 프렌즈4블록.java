import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] matrix = new char[m][n];
        for(int i = 0; i<m; i++) {
            matrix[i] = board[i].toCharArray();
        }
        while(true) {
            int count = find(m,n,matrix);
            if(count == 0) break;
            answer += count;
            arrange(m,n,matrix);
        }
        return answer;
    }
    
    private int find(int m,int n, char[][] board) {
        boolean[][] v = new boolean[m][n];
        
        for(int i = 0; i<m-1; i++){
            for(int j = 0; j<n-1; j++) {
                char block = board[i][j];
                if(isSquare(block, i , j, board)) {
                    v[i][j] = true;
                    v[i+1][j] = true;
                    v[i][j+1] = true;
                    v[i+1][j+1] = true;
                }
            }
        }
        
        return remove(v, m , n, board);
    }
    
    private int remove(boolean[][] v, int m, int n, char[][] board) {
        int count = 0;
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(v[i][j]) {
                    board[i][j] = 'X';
                    count++;
                }
            }
        }
        return count;
    }
    
    private void arrange(int m, int n,char[][] board) {
        List<Character> list = new ArrayList<>();
        for(int i = 0; i<n; i++) {
            for(int j = m-1; j>-1; j--) {
                if(board[j][i] != 'X') {
                    list.add(board[j][i]);
                    board[j][i] = 'X';
                }
            }
            
            for(int j = m-1; j>-1; j--) {
                if(!list.isEmpty()) board[j][i] = list.remove(0);
            }
        }
    }
    
    private boolean isSquare(char c ,int i, int j, char[][] board) {
        return c != 'X' && c == board[i+1][j] && c == board[i][j+1] && c == board[i+1][j+1];
    }
}