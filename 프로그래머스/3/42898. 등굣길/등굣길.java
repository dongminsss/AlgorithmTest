import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        long[][] matrix = new long[n][m];
        matrix[0][0] = 1;
        boolean[][] notVisit = new boolean[n][m];
        for(int[] puddle : puddles) {
            int x = puddle[0] - 1;
            int y = puddle[1] - 1;
            notVisit[y][x] = true;
        }
        
        for(int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                long up = 0;
                long left = 0;
                if(i == 0 && j==0 ) {
                    continue;
                } else {
                    if(i - 1 >= 0 && !notVisit[i-1][j]) up = matrix[i-1][j]  % 1000000007;
                    if(j - 1 >= 0 && !notVisit[i][j-1]) left = matrix[i][j-1]  % 1000000007;
                    if(!notVisit[i][j]) matrix[i][j] = up+left;
                }
            }
        }
        int answer =(int) (matrix[n-1][m-1]% 1000000007);
        return answer;
    }
}