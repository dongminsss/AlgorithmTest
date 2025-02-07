import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] steps = new int[n + 1];
        int[] dp = new int[n + 1];
        for(int i = 1; i<=n; i++) {
            steps[i] = Integer.parseInt(br.readLine());
        }
        if(n == 1) {
            System.out.println(steps[1]);
            return;
        }
        if(n == 2) {
            System.out.println(steps[2] + steps[1]);
            return;
        }
        dp[1] = steps[1];
        dp[2] = steps[2] + steps[1];
        dp[3] = Math.max(steps[1], steps[2]) + steps[3];

        for(int i = 4; i<=n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i-3] + steps[i-1]) + steps[i];
        }
        System.out.println(dp[n]);


     }
}
