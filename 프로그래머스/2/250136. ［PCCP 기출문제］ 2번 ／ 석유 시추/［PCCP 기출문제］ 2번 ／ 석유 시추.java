import java.util.*;

class Solution {
    int n = 0;
    int m = 0;
    int[] max;
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        max = new int[m];
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(land[i][j] == 1 && !visited[i][j]) searchOil(land, visited, new int[]{j,i});
            }
        }
        for(int c : max) {
            answer = Math.max(answer, c);
        }
        return answer;
    }
    
    void searchOil(int[][] land, boolean[][] visited ,int[] start) {
        int count = 1;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0,0,1,-1};
        boolean[] isColunm = new boolean[m];
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(start);
        visited[start[1]][start[0]] = true;
        isColunm[start[0]] = true;
        while(!dq.isEmpty()) {
            int[] arr = dq.poll();
            int x = arr[0];
            int y = arr[1];
            for(int i = 0; i<4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if(isRange(nextX, nextY) && !visited[nextY][nextX] && land[nextY][nextX] == 1) {
                    dq.offer(new int[]{nextX, nextY});
                    visited[nextY][nextX] = true;
                    isColunm[nextX] = true;
                    count++;
                }
            }
        }
        for(int i = 0; i<m; i++) {
            if(isColunm[i]) max[i] += count;
        }
    }
    
    boolean isRange(int x, int y) {
        return (x >= 0 && y >= 0 && x < m && y < n);
    }
}