import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static private int[] dx = {1, -1, 0, 0};
    static private int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];
        int[] start = new int[2];
        for(int i = 0; i<n; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j<m; j++) {
                if(map[i][j] == 'I') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        System.out.println(bfs(map, start) == 0 ? "TT" : bfs(map, start));

    }

    private static int bfs(char[][] map, int[] start) {
        int W = map[0].length;
        int H = map.length;
        int count = 0;
        boolean[][] visited = new boolean[H][W];
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(start);
        int x = start[1];
        int y = start[0];
        visited[y][x] = true;
        while(!dq.isEmpty()) {
            int[] current = dq.poll();
            int currentX = current[1];
            int currentY = current[0];

            for(int i = 0; i<4; i++) {
                int nextX = dx[i] + currentX;
                int nextY = dy[i] + currentY;
                if(range(nextX, nextY, map) && !visited[nextY][nextX]) {
                    dq.offer(new int[]{nextY, nextX});
                    visited[nextY][nextX] = true;
                    if(map[nextY][nextX] == 'P') count++;
                }
            }
        }
        return count;

    }

    private static boolean range(int x, int y, char[][] map) {
        return x >= 0 && x < map[0].length && y >= 0 && y < map.length && map[y][x] != 'X';
    }
}