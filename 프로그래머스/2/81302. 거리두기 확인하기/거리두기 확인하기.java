import java.util.*;

class Solution {
    private final static int[] dx = {1,-1,0,0};
    private final static int[] dy = {0,0,1,-1};
    
    public int[] solution(String[][] places) {
        int n = places.length;
        int[] answer = new int[n];
        for(int i = 0; i<n; i++) {
            if(bfs(places[i], n)) answer[i] = 1;
        }
        return answer;
    }
    
    private boolean bfs(String[] place, int length) {
        char[][] placeCharArray = new char[length][length];
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        for(int i = 0; i<length; i++) {
            placeCharArray[i] = place[i].toCharArray();
        }
        for(int i = 0; i<length; i++) {
            for(int j = 0; j<length; j++) {
                if(placeCharArray[i][j] == 'P') {
                    if(!underManhatten(j,i,placeCharArray)) return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isRange(int x, int y, int length, int dist) {
        return x < length && x >= 0 && y < length && y >= 0 && dist < 3;
    }
    
    private boolean underManhatten(int x, int y, char[][] matrix) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        int length = matrix.length;
        dq.offer(new int[]{x,y,1});
        boolean[][] visited = new boolean[length][length];
        visited[y][x] = true;
        while(!dq.isEmpty()) {
            int[] start = dq.poll();
            int currentX = start[0];
            int currentY = start[1];
            int dist = start[2];
            char current = matrix[currentY][currentX];
            for(int i = 0; i<4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                if(isRange(nextX, nextY, length, dist) && !visited[nextY][nextX] && matrix[nextY][nextX] != 'X') {
                    char next = matrix[nextY][nextX];
                    if(next == 'P') return false;
                    visited[nextY][nextX] = true;
                    dq.offer(new int[]{nextX, nextY, dist + 1});
                }
            }
        }
        return true;
    }
    
}