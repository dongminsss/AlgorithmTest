import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] vistited;
    static int[][] arr;
    static int[] dirX = {1,-1,0,0};
    static int[] dirY = {0,0,-1,1};
    static int nowX, nowY, w, h;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            arr = new int[h][w];
            vistited = new boolean[h][w];
            int result = 0;
            for (int j = 0; j <count; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[y][x] = 1;
            }
            for (int k = 0; k <h ; k++) {
                for (int l = 0; l <w ; l++) {
                    if(vistited[k][l] != true && arr[k][l] == 1) {
                        result++;
                        dfs(l, k);
                    }
                }
            }
            System.out.println(result);
        }


    }
    public static void dfs(int x, int y) {
        if(vistited[y][x] != true && arr[y][x] == 1) {
            vistited[y][x] = true;
            for(int i = 0; i<4; i++) {
                nowX = x + dirX[i];
                nowY = y + dirY[i];
                if(range()) {
                    dfs(nowX, nowY);
                }
            }
        }

    }
    public static boolean range() {
        return (nowY >= 0 && nowX >= 0 && nowY < h && nowX < w);
    }
}
