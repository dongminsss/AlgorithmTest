import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        for(int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    dq.add(new int[]{j , i , 0});
                    visited[i][j] = true;
                }
            }
        }
        bfs(dq, map, visited);
        int max = 0;
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(map[i][j] == 0 && !visited[i][j]) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, map[i][j]);
            }
        }
        System.out.println(max);
    }

    private static void bfs(ArrayDeque<int[]> dq, int[][] map ,boolean[][] visited) {
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,-1,1};
        while(!dq.isEmpty()) {
            int[] current = dq.poll();
            int x = current[0];
            int y = current[1];
            map[y][x] = current[2];
            for(int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if(isRange(nextX, nextY, map) && !visited[nextY][nextX]) {
                    dq.offer(new int[] { nextX, nextY, current[2] + 1});
                    visited[nextY][nextX] = true;
                }
            }
        }
    }

    private static boolean isRange(int x , int y, int[][] map) {
        return x >= 0 && y>= 0 && x < map[0].length && y < map.length && map[y][x] == 0;
    }
}