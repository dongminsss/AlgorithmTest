import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static int map[][];
    static int X[] = {0,0,1,-1,-1,1,1,-1};
    static int Y[] = {1,-1,0,0,1,1,-1,-1};
    static int w, h, nowX, nowY;
    static int count;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[h][w];
            visited = new boolean[h][w];
            int islandCount = 0;
            if( w == 0 && h == 0) {
                break;
            } else {
                for(int i = 0; i<h; i++) {
                    st = new StringTokenizer(br.readLine());
                    for(int j = 0; j<w; j++) {
                        map[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
                for(int i = 0; i<h; i++) {
                    for (int j = 0; j<w; j++) {
                        if(!visited[i][j] && map[i][j] == 1) {
                            islandCount++;
                            dfs(i,j);
                        }
                    }
                }

            }
            System.out.println(islandCount);
        }
    }
    public static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i = 0; i<8; i++) {
            nowX = X[i] + x;
            nowY = Y[i] + y;
            if(rangeCheck() && !visited[nowX][nowY] && map[nowX][nowY] == 1) {
                dfs(nowX, nowY);
            }
        }
    }
    static boolean rangeCheck(){
        return (nowY >=0 && nowX >= 0 && nowY< w && nowX < h);
    }
}
