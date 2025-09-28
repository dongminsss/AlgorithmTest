import java.util.*;

class Solution {
    boolean[][] v;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    int W,H;
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        W = maps[0].length();
        H = maps.length;
        char[][] charMaps = new char[H][W];
        v = new boolean[H][W];
        for(int i = 0; i<H; i++) {
            charMaps[i] = maps[i].toCharArray();
        }
        for(int i = 0; i<H; i++) {
            for (int j = 0; j<W; j++) {
                if(!v[i][j] && charMaps[i][j] != 'X') {
                    list.add(bfs(new int[]{j,i}, charMaps));
                }
            }
        }
        list.sort(null);
        if(list.isEmpty()) return new int[]{-1};
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int bfs(int[] start, char[][] maps) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(start);
        v[start[1]][start[0]] = true;
        int count = 0;
        while(!dq.isEmpty()) {
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];
            count += Character.getNumericValue(maps[y][x]);
            for(int i = 0; i<4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if(isRange(nextX,nextY) && !v[nextY][nextX] && maps[nextY][nextX] != 'X' ) {
                    v[nextY][nextX] = true;
                    dq.offer(new int[] {nextX, nextY});
                }
            }
        }
        return count;
    }
    
    private boolean isRange(int x, int y) {
        return x >= 0 && x < W && y >= 0 && y < H;
    }
}