class Solution {
    int len;
    int count = 0;
    int[] col;
    public int solution(int n) {
        len = n;
        col = new int[n];
        dfs(0);
        return count;
    }
    
    void dfs(int row) {
        if(row == len) {
            count++;
            return;
        }
        for(int i = 0; i<len; i++) {
            if(canMark(row, i)) {
                col[row] = i;
                dfs(row + 1);
            }
        }
    }
    
    boolean canMark(int row, int column) {
        for(int i = 0; i<row; i++) {
            if(col[i] == column) return false;
            if(Math.abs(row - i) == Math.abs(column - col[i])) return false;
        }
        return true;
    }
}