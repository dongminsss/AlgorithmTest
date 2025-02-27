import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        final int NUM = 10007;
        int[] dp = new int[n + 1];
        if(n == 1) dp[1] = 1;
        if(n == 2) dp[2] = 2;
        if( n > 2) {
            dp[1] = 1;
            dp[2] = 2;
            for(int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] % NUM + dp[i - 2] % NUM;
            }
        }
        System.out.println(dp[n] % NUM);
    }
}
