import java.util.*;

class Solution {    
    public int solution(int[][] board) {
        int n = board.length;
        int answer = Integer.MAX_VALUE;
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int[][][] dist = new int[n][n][4];
        for(int[][] a : dist) {
            for(int[] b : a) {
                Arrays.fill(b, Integer.MAX_VALUE);
            }
        }
        for(int i = 0; i<4; i++) dist[0][0][i] = 0;
        for(int i = 0; i<4; i++) pq.offer(new int[]{0,0,0,i});
        while(!pq.isEmpty()){
            int[] c = pq.poll();
            int cost = c[0], x = c[1], y = c[2], d = c[3];
            if(cost > dist[y][x][d]);
            for(int i = 0; i<4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(board[ny][nx] == 1) continue;
                int nextCost = cost+ (d == i ? 100 : 600);
                if(nextCost < dist[ny][nx][i]) {
                    dist[ny][nx][i] = nextCost;
                    pq.offer(new int[]{nextCost,nx,ny,i});
                }
            }
        }
        
        for(int i = 0; i<4; i++) answer = Math.min(dist[n-1][n-1][i], answer);
        
        return answer;
    }
}