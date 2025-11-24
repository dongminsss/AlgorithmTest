import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int inven = Integer.parseInt(st.nextToken());

        int minH = 256;
        int maxH = 0;
        int resultHeight = 0;
        int[][] map = new int[n][m];
        for(int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                minH = Math.min(minH, map[i][j]);
                maxH = Math.max(maxH, map[i][j]);
            }
        }

        int minT = Integer.MAX_VALUE;

        for(int target = minH; target <= maxH; target++) {
            int time = 0;
            int inventory = inven;

            for(int i = 0; i<n; i++){
                for(int j = 0; j<m; j++) {
                    int diff = map[i][j] - target;
                    if(diff > 0) {
                        time += diff * 2;
                        inventory += diff;
                    } else if(diff < 0){
                        time += Math.abs(diff);
                        inventory -= Math.abs(diff);
                    }
                }

            }
            if(inventory < 0) continue;
            if(time < minT || (time == minT && target > resultHeight)) {
                minT = time;
                resultHeight = target;
            }
        }

        System.out.println(minT + " " + resultHeight);


    }
}