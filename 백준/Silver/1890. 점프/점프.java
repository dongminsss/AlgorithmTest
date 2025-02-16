import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] matrix;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        dp = new long[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(dfs(0, 0));

    }
    static long dfs(int i, int j) {
        if(i == N - 1 && j == N - 1) return 1;
        if(dp[i][j] != -1) return dp[i][j];

        int jump = matrix[i][j];
        dp[i][j] = 0;
        if(jump == 0) return dp[i][j];

        if(i + jump < N) dp[i][j] += dfs(i + jump, j);
        if(j + jump < N) dp[i][j] += dfs(i, j + jump);

        return dp[i][j];
    }
}
