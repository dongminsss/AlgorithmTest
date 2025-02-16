import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        final int MOD = 1000000000;

        int[][] dp = new int[n+1][10];

        dp[1][0] = 0;
        for(int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }
        if(n > 1) {
            for(int i = 2; i <= n; i++) {
                for(int j = 0; j < 10; j++) {
                    if(j == 0) {
                        dp[i][j] = dp[i-1][j+1] % MOD;
                    } else if( j == 9) {
                        dp[i][j] = dp[i-1][j-1]  % MOD;
                    } else {
                        dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % MOD;
                    }
                }
            }
        }
        int answer = 0;
        for(int i : dp[n]) {
            answer = (answer + i) % MOD;
        }
        System.out.println(answer);

    }
}
