import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] visited = new boolean[n][m];
        int[][] map = new int[n][m];
        int[] start = new int[2];
        for(int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    start[0] = j;
                    start[1] = i;
                }
            }
        }
        bfs(start, map, visited);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    map[i][j] = -1;
                }
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    private static void bfs(int[] start, int[][] map, boolean[][] visited) {
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,-1,1};
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {start[0], start[1], 0 });
        visited[start[1]][start[0]] = true;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];
            map[y][x] = cur[2];
            for(int i = 0; i<4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if(isRange(nextX, nextY, map) && !visited[nextY][nextX]) {
                    dq.offer(new int[] {nextX, nextY, cur[2] + 1});
                    visited[nextY][nextX] = true;
                }
            }
        }
    }

    private static boolean isRange(int x , int y, int[][] map) {
        return x >= 0 && y >= 0 && x < map[0].length && y < map.length && map[y][x] == 1;
    }
}