import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] matrix = new int[rows][columns];
        int count = 1;
        for(int i = 0; i<rows; i++) {
            for(int j = 0; j<columns; j++) {
                matrix[i][j] = count++;
            }
        }
        
        for(int i = 0; i<queries.length; i++) {
            int r1 = queries[i][0]-1;
            int r2 = queries[i][2]-1;
            int c1 = queries[i][1]-1;
            int c2 = queries[i][3]-1;
            int temp = matrix[r1][c1];
            int minValue = temp;
            for(int r = r1; r<r2; r++) {
                int value = matrix[r + 1][c1];
                matrix[r][c1] = value;
                minValue = Math.min(value, minValue);
            }
            for(int c = c1; c<c2; c++) {
                int val = matrix[r2][c+1];
                matrix[r2][c] = val;
                minValue = Math.min(val, minValue);
            }
            for(int r = r2; r > r1; r--) {
                int val = matrix[r-1][c2];
                matrix[r][c2] = val;
                minValue = Math.min(val, minValue);
            }
            for(int c = c2; c> c1; c--) {
                int val = matrix[r1][c-1];
                matrix[r1][c] = val;
                minValue = Math.min(val, minValue);
            }
            
            matrix[r1][c1+1] = temp;
            answer[i] = minValue;
        }
        return answer;
    }
}