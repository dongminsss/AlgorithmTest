import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] steakers = new int[2][n];

            for(int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k = 0; k < n; k++) {
                    steakers[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            if(n == 1) {
                System.out.println(Math.max(steakers[0][0], steakers[1][0]));
                continue;
            }

            int[][] dp = new int[2][n];
            dp[0][0] = steakers[0][0];
            dp[1][0] = steakers[1][0];

            dp[0][1] =dp[1][0] + steakers[0][1];
            dp[1][1] = dp[0][0] + steakers[1][1];

            for(int j = 2; j < n; j++) {
                dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + steakers[0][j];
                dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + steakers[1][j];
            }

            System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));

        }


     }
}
