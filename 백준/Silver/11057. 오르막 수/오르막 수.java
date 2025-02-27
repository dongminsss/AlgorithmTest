import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][10];
        final int MOD = 10007;

        for(int i = 0; i < 10; i++) dp[1][i] = 1;

        for(int i = 2; i<=n; i++){
            dp[i][0] = dp[i-1][0];
            for(int j = 1; j<10; j++){
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
            }
        }

        int answer = 0;
        for(int i = 0; i < 10; i++) {
            answer = (answer + dp[n][i]) % MOD;
        }
        System.out.println(answer);
     }
}
