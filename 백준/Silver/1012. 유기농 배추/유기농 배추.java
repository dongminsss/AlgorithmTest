
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] matrix = new int[m][n];
            for(int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                matrix[y][x] = 1;
            }

            System.out.println(bfs(matrix));


        }

    }

    private static int bfs(int[][] matrix) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int count = 0;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(visited[i][j] == false && matrix[i][j] == 1) {
                    queue.add(new int[] {i, j});
                    count++;
                    visited[i][j] = true;
                    while(!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        for(int k = 0; k < 4; k++) {
                            int x = curr[0] + dx[k];
                            int y = curr[1] + dy[k];
                            if(range(x,y,matrix.length, matrix[i].length) && visited[x][y] == false && matrix[x][y] == 1) {
                                queue.add(new int[] {x, y});
                                visited[x][y] = true;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    private static boolean range(int x, int y, int xLength, int yLength) {
        return x >= 0 && y >= 0 && x < xLength && y < yLength;
    }

}