import java.util.*;

class Solution {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static char[][] matrixMap;
    static int H, W;
    
    public int solution(String[] maps) {
        int answer = 0;
        H = maps.length;
        W = maps[0].length();
        matrixMap = new char[H][W];
        
        int[] start = null;
        int[] lever = null;
        int[] exit = null; 
        
        for(int i = 0; i<H; i++) {
            for(int j = 0; j<W; j++) {
                if(maps[i].charAt(j) == 'S') start = new int[]{j , i};
                if(maps[i].charAt(j) == 'L') lever = new int[]{j, i};
                if(maps[i].charAt(j) == 'E') exit = new int[]{j, i};
                matrixMap[i][j] = maps[i].charAt(j);
            }
        }
        
        int a = bfs(start, lever);
        int b = bfs(lever, exit);
        
        if(a == -1|| b == -1) {
            answer = -1;
        } else {
            answer = a + b;
        }
        
        return answer;
    }
    
    private int bfs(int[] start, int[] end) {
        boolean[][] v = new boolean[H][W];
        int[][] matrix = new int[H][W];
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        
        dq.offer(start);
        v[start[1]][start[0]] = true;
        
        while(!dq.isEmpty()) {
            int[] current = dq.poll();
            int x = current[0];
            int y = current[1];
            if(x == end[0] && y == end[1]) return matrix[y][x];
            
            for(int i = 0; i<4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                
                if(isRange(nextX, nextY) && !v[nextY][nextX] && matrixMap[nextY][nextX] != 'X') {
                    dq.offer(new int[] {nextX, nextY});
                    v[nextY][nextX] = true;
                    matrix[nextY][nextX] = matrix[y][x] + 1;
                }
            }
        }
        
        return -1;
    }
    
    private boolean isRange(int x, int y) {
        return x >= 0 && x < W && y >= 0 && y < H;
    }
}