import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        int max = 0;
        int w = park[0].length;
        int h = park.length;
        boolean hasOne = false;
        int[][] matrix = new int[h][w];
        for(int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if(park[i][j].equals("-1")) {
                    matrix[i][j] = 1;
                    hasOne = true;
                }
            }
        }
        max = hasOne ? 1:0;
        for(int i = 1; i<h; i++) {
            for(int j = 1; j<w; j++) {
                if(matrix[i][j] == 1) {
                    matrix[i][j] = Math.min( Math.min(matrix[i-1][j] + 1 , matrix[i][j-1] + 1) , matrix[i-1][j-1] + 1);
                    max = Math.max(max, matrix[i][j]);
                }
            }
        }
        
        for(int mat : mats) {
            if(mat <= max) answer = Math.max(answer , mat);
        }
        return answer;
    }
}