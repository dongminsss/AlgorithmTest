import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<N; i++) {
            String str = br.readLine();
            for(int j = 0; j<N; j++) {
                map[i][j] = str.charAt(j) - 48;
            }
        }

        for(int i = 0; i<N; i++) {
            for(int j = 0; j<N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    int total = bfs(j,i,map,visited);
                    if(total > 0) list.add(total);
                }
            }
        }
        list.sort(null);
        System.out.println(list.size());
//        System.out.println(Arrays.deepToString(map));
        list.forEach(System.out::println);


    }

    private static int bfs(int x, int y, int[][] map, boolean[][] visited) {
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,-1,1};
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{x, y});
        visited[y][x] = true;
        int count = 1;
        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int curX = cur[0];
            int curY = cur[1];
            for(int i = 0; i<4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(isRange(nextX, nextY, map) && !visited[nextY][nextX]) {
                    deque.offer(new int[]{nextX, nextY});
                    count++;
                    visited[nextY][nextX] = true;
                }
            }
        }
        return count;
    }

    private static boolean isRange(int x, int y, int[][] map) {
        return x >= 0 && y>=0 && x < map[0].length && y < map.length && map[y][x] == 1;
    }
}