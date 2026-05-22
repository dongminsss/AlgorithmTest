class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        boolean[] isSelected = new boolean[n+1];
        
        return dfs(1, 0, q, ans, isSelected);
    }
    
    int dfs(int start, int depth, int[][] q, int[] ans, boolean[] isSelected) {
        if(depth == 5) {
            for(int i = 0; i<ans.length; i++) {
                int matchCount = 0;
                
                for(int j = 0; j<q[i].length; j++) {
                    if(isSelected[q[i][j]]) matchCount++;
                }
                if(matchCount != ans[i]) return 0;
                
            }
            return 1;
        }
        int count = 0;
        for(int i = start; i<=isSelected.length-1; i++) {
            isSelected[i] = true;
            count += dfs(i + 1, depth + 1, q, ans, isSelected);
            isSelected[i] = false;
        }
        
        return count;
    }
}