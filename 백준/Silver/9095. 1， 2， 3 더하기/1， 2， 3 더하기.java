import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n];
        for(int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            int[] dp = new int[m + 1];
            if( m == 1) dp[1] = 1;
            if( m == 2) dp[2] = 2;
            if( m == 3) dp[3] = 4;
            if(m > 3) {
                dp[1] = 1;
                dp[2] = 2;
                dp[3] = 4;
                for(int j = 4; j <= m; j++) {
                    dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
                }
            }
            answer[i] = dp[m];
        }
        for(int a : answer) System.out.println(a);
     }
}
