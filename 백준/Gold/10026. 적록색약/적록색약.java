import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] matrix1 = new char[n][n];
        char[][] matrix2 = new char[n][n];

        for(int i = 0; i<n; i++) {
            String str = br.readLine();
            for(int j = 0; j<n; j++) {
                matrix1[i][j] = str.charAt(j);
                matrix2[i][j] = str.charAt(j);
                if(str.charAt(j) == 'G') matrix2[i][j] = 'R';
            }
        }

        boolean[][] visited1 = new boolean[n][n], visited2 = new boolean[n][n];
        int count1 = 0, count2 = 0;
        for (int i = 0; i < visited1.length; i++) {
            for (int j = 0; j < visited1.length; j++) {
                if(!visited1[i][j]) {
                    count1++;
                    bfs(new int[]{j, i}, matrix1, visited1, matrix1[i][j]);
                }
                if(!visited2[i][j]) {
                    count2++;
                    bfs(new int[]{j, i} , matrix2, visited2, matrix2[i][j]);
                }
            }
        }
        System.out.println(count1 + " " + count2);

    }

    private static void bfs(int[] start, char[][] matrix, boolean[][] vistied ,char target) {
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(start);
        vistied[start[1]][start[0]] = true;
        while(!dq.isEmpty()) {
            int[] current = dq.poll();
            int x = current[0];
            int y = current[1];
            for(int i = 0; i<4; i++) {
                int nextX = x + dx[i];
                int nextY = y+ dy[i];
                if(isRange(nextX, nextY, matrix.length) && !vistied[nextY][nextX] && matrix[nextY][nextX] == target) {
                    vistied[nextY][nextX] = true;
                    dq.offer(new int[] {nextX, nextY});
                }
            }
        }
    }
    private static boolean isRange(int x , int y, int n) {
        return x >=0 && y >= 0 && x <n && y <n ;
    }
}