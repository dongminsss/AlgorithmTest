class Solution {
    public int solution(String[] board) {
        // int answer = 0;
        int oCount = 0;
        int xCount = 0;
        for(String str : board) {
            for(char c : str.toCharArray()) {
                if(c == 'O') oCount++;
                if(c == 'X') xCount++;
            }
        }
        if(oCount == 0 && xCount == 0) return 1;
        
        if(oCount == xCount || oCount == xCount + 1) {
            if(isWin(board,'O') && isWin(board,'X')) return 0;
            if(isWin(board, 'O') && oCount != xCount + 1) return 0; 
            if(isWin(board, 'X') && oCount != xCount) return 0;
            return 1;
        }
        
        return 0;
    }
    
    boolean isWin(String[] board, char c) {
        for(int i = 0; i<3; i++) {
            if(board[i].charAt(0) == c 
              && board[i].charAt(1) == c
              && board[i].charAt(2) == c) return true; 
        }
        
        for(int i = 0; i<3; i++) {
            if(board[0].charAt(i) == c
              && board[1].charAt(i) == c
              && board[2].charAt(i) == c) return true;
        }
        
        if(board[0].charAt(0) == c 
          && board[1].charAt(1) == c
          && board[2].charAt(2) == c) return true;
        
        if(board[0].charAt(2) == c
          && board[1].charAt(1) == c
          && board[2].charAt(0) == c) return true;
        
        return false;
    }
}