import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] houseCount = new int[n][3];
        int[][] dp = new int[n][3];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            houseCount[i][0] = Integer.parseInt(st.nextToken());
            houseCount[i][1] = Integer.parseInt(st.nextToken());
            houseCount[i][2] = Integer.parseInt(st.nextToken());
        }
        dp[0][0] = houseCount[0][0];
        dp[0][1] = houseCount[0][1];
        dp[0][2] = houseCount[0][2];

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                if(j==0) dp[i][j] = Math.min(dp[i-1][j+1], dp[i-1][j+2]) + houseCount[i][j];
                if(j==1) dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j+1]) + houseCount[i][j];
                if(j==2) dp[i][j] = Math.min(dp[i-1][j-2], dp[i-1][j-1]) + houseCount[i][j];
            }
        }
        System.out.println(Arrays.stream(dp[n-1]).min().getAsInt());
    }
}
