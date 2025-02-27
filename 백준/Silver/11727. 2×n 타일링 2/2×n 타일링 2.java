import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[n + 1];
        dp[1] = 1;
        if( n > 1) {
            dp[2] = 3;
            for(int i = 3; i <= n; i++) {
                dp[i] = dp[i-1] + (2 * dp[i-2]) % 10007 ;
            }
        }
        System.out.println(dp[n] % 10007);

     }
}
