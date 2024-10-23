import java.util.*;
class Solution {
    static ArrayDeque<int[]> deque = new ArrayDeque<>();
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n, m;
    static int[][] matrix;
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        matrix = maps;
        n = maps.length;
        m = maps[0].length;
        matrix = new int[n][m];
        visited = new boolean[n][m];
        matrix[0][0] = 1;
        int answer = bfs(maps, 0, 0);
        return answer;
    }
    
    private static int bfs(int[][] map,int x, int y) {
        deque.offer(new int[]{x, y});
        visited[x][y] = true;
        
        while(!deque.isEmpty()) {
            int[] current = deque.poll();
            int cx = current[0];
            int cy = current[1];
            if(cx == n-1 && cy == m-1) return matrix[n-1][m-1];
            
            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(range(nx, ny) && map[nx][ny] == 1 && !visited[nx][ny]) {
                    deque.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    matrix[nx][ny] = matrix[cx][cy] + 1;
                }
            }
        }
        return -1;
        
    }
    
    private static boolean range(int x, int y) {
        return ( 0 <= x && x < n && 0<= y && y < m);
    }
}