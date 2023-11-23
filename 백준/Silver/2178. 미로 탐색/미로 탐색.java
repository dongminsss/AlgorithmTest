import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] square;
    static int width;
    static int height;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        visited = new boolean[height][width];
        square = new int[height][width];
        for(int i = 0; i<height; i++) {
            String str = br.readLine();
            for(int j = 0; j<width; j++) {
                square[i][j] = Integer.parseInt(str.split("")[j]);
            }
        }
        BFS(0,0);
        System.out.println(square[height-1][width-1]);
    }
    static void BFS(int x, int y) {
//        if(x < 0 || y < 0 || x >= width || y >= height) return;
//        if(visited[y][x] || square[y][x] == 0) return;
        visited[y][x] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});

        while (!queue.isEmpty()) {

            int[] now = queue.poll();

            for(int i = 0; i<4; i++) {
                int subY = now[1] + dy[i];
                int subX = now[0] + dx[i];

                if( subX >=0 && subY >=0 && subX < width && subY < height) {

                    if(square[subY][subX] != 0 && !visited[subY][subX]) {

                        visited[subY][subX] = true;
                        square[subY][subX] = square[now[1]][now[0]] + 1;
                        queue.add(new int[] {subX, subY});
                    }
                }
            }
        }

    }

}
