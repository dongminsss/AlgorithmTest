import java.util.*;


class Solution {
    static boolean[][] v;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static char[][] map;
    static int W,H;
    public int solution(String[] board) {
        int answer = 0;
        W = board[0].length();
        H = board.length;
        v = new boolean[H][W];
        map = new char[H][W];
        int[] start = new int[2];
        
        for(int i = 0; i<H; i++) {
            map[i] = board[i].toCharArray();
            for(int j = 0; j<W; j++) {
                if(board[i].charAt(j) == 'R') {
                    start[0] = j;
                    start[1] = i;
                }
            }
        }
        
        
        return bfs(start, 0);
    }
    
    private int bfs(int[] start, int count) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{start[0], start[1], count});
        v[start[1]][start[0]] = true;
        
        while(!dq.isEmpty()) {
            int[] current = dq.poll();
            int x = current[0];
            int y = current[1];
            int number = current[2];
            if(map[y][x] == 'G') return number;
            for (int i = 0; i < 4; i++) {
                int nextX = x;
                int nextY = y;
                
                while (isRange(nextX + dx[i], nextY + dy[i]) && map[nextY + dy[i]][nextX + dx[i]] != 'D') {
                    nextX += dx[i];
                    nextY += dy[i];
                }
                
                if (!v[nextY][nextX]) {
                    v[nextY][nextX] = true;
                    dq.offer(new int[]{nextX, nextY, number + 1});
                }
            }
            
        }
        
        return -1;
    }
    
    private boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < W && y < H;
    }
    
}